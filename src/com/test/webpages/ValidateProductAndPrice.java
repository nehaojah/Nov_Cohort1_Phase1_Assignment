package com.test.webpages;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.utitlites.JdbcConn;
import com.test.utitlites.ManageDriver;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class ValidateProductAndPrice {

	ProductSearch productSearchobj = new ProductSearch();
	ManageDriver manageDriverobj = new ManageDriver();
	JdbcConn jdbcConnobj = new JdbcConn();
	GetDBdetails getdbDetailsobj = new GetDBdetails();

	public WebDriver TestCompare() {
		WebDriver driver = manageDriverobj.OpenBrowser("Chrome");
		productSearchobj.SearchProductPage(driver);
		ResultSet resultset_col1 = getdbDetailsobj.getResultSet();
		ResultSet resultset_col2 = getdbDetailsobj.getResultSet();
		productSearchobj.searchForProduct("apple watch", driver);
		List<String> ActualProductNames = productSearchobj.getProductNames(driver);
		List<String> ActualProductPrices = productSearchobj.getProductPrices(driver);
		List<String> ExpectedProductNames = getdbDetailsobj.getDbProductNames(resultset_col1);
		List<String> ExpectedProductPrices = getdbDetailsobj.getDbProdPriceList(resultset_col2);

		if (((ExpectedProductNames.size()) == (ActualProductNames.size()))
				|| ((ExpectedProductPrices.size()) == (ActualProductPrices.size()))) {
			if ((!ExpectedProductNames.isEmpty()) && (!ActualProductNames.isEmpty())) {
				for (int i = 0; i < ActualProductNames.size(); i++) {

					try {
						if (ExpectedProductNames.get(i).equals(ActualProductNames.get(i))
								&& (ExpectedProductPrices.get(i).equals(ActualProductPrices.get(i)))) {

							System.out.println("Testcase" + (i) + " " + "passed as" + " Expected Name :"
									+ ExpectedProductNames.get(i) + " and " + " Expected Price :"
									+ ExpectedProductPrices.get(i) + " is equal to " + " Actual Name :"
									+ ActualProductNames.get(i) + " and " + " Actual Price :"
									+ ActualProductPrices.get(i));

						} else {
							System.out.println("Testcase" + (i) + " " + "failed as" + " Expected Name :"
									+ ExpectedProductNames.get(i) + " and " + " Expected Price :"
									+ ExpectedProductPrices.get(i) + " is not equal to " + " Actual Name :"
									+ ActualProductNames.get(i) + " and " + " Actual Price :"
									+ ActualProductPrices.get(i));
						}
					} catch (IndexOutOfBoundsException e) {
						System.out.println(
								" In Actual Result, some products does not have a price associated with Product name");
						continue;
					}
				}

			}

			else {
				System.out.println("null values for either Product or Price column in Database");
			}
		} else {
			System.out.println("Expected list and Actual List size is not same ");
		}

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File screenshot_path = new File("C:\\Users\\User\\Pictures\\screenshot_SerachResult.png");
		try {
			FileUtils.copyFile(screenshot, screenshot_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

}
