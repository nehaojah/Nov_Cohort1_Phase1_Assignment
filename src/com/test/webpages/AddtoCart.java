package com.test.webpages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddtoCart {
	ValidateProductAndPrice valproductandpriceobj = new ValidateProductAndPrice();

	By Product = By
			.xpath("  //img[@class = 's-image']//parent::div[contains(@class,'a-section aok-relative s-image')]");
	By AddtoCart_btn = By.id("add-to-cart-button");
	By AddedtoCart_lbl = By.xpath("//span[contains(@class, 'a-size-medium-plus a-color')]");

	public void AddtoCartCheck() {

		WebDriver driver = valproductandpriceobj.TestCompare();
		driver.findElement(Product).click();
		driver.findElement(AddtoCart_btn).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		if (driver.findElement(AddedtoCart_lbl).isDisplayed()) {

			System.out.println("Testcase case Passed  : Product is added to Cart");

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File screenshot_path = new File("C:\\Users\\User\\Pictures\\screen_shot.png");

			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("//span[contains(@class, 'a-size-medium-plus a-color')]")));
				FileUtils.copyFile(screenshot, screenshot_path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Testcase case Failed");
		}

	}

}
