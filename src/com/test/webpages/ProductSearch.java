package com.test.webpages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearch {

	By searchTextBox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");
	By productNames = By.xpath(
			"//*[@data-component-type='s-search-results']/div[1]//div//div[contains(@class,'s-title-instructions-style')]//span[contains(@class,'a-size-medium a-color-base a-text-normal')]");
	By productPrices = By.xpath(
			"//*[@data-component-type='s-search-results']/div[1]//div//div[contains(@class,'a-row a-size-base a-color-base')]//span[@class='a-price-whole']");

	public void SearchProductPage(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.com/ref=nav_logo");
	}

	public void searchForProduct(String product, WebDriver driver) {
		driver.findElement(searchTextBox).sendKeys(product);
		driver.findElement(searchButton).click();
	}

	public List<String> getProductNames(WebDriver driver) {
		List<String> actualProductList = new ArrayList<>();
		List<WebElement> productNameElementList = driver.findElements(productNames);
		System.out.println("Total Products ::" + productNameElementList.size());
		for (WebElement productNameElement : productNameElementList) {
			String productName = productNameElement.getText().substring(0, 20);
			actualProductList.add(productName);
		}
		return actualProductList;
	}

	public List<String> getProductPrices(WebDriver driver) {
		List<String> actualPriceList = new ArrayList<>();
		List<WebElement> productPriceElementList = driver.findElements(productPrices);
		System.out.println("Total Prices ::" + productPriceElementList.size());
		for (WebElement productPriceElement : productPriceElementList) {
			try {
				String productPrice = productPriceElement.getText();
				actualPriceList.add(productPrice);
			} catch (Exception e) {

				continue;
			}
		}

		return actualPriceList;
	}

}
