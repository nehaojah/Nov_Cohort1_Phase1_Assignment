package com.test.utitlites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ManageDriver {

	public WebDriver OpenBrowser(String browserName) {

		WebDriver driver = null;
		if (browserName.contains("Chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}

		return driver;

	}

	public void CloseBrowser(WebDriver driver) {
		driver.close();
	}
}
