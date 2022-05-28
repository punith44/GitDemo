package com.test.BaseClass;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

public class TestBase {


	public  static WebDriver webdriver;


	public static void initialization() throws Exception{

		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+ File.separator + "src/test/resources/Drivers/chromedriver"));
		webdriver = new ChromeDriver();
		webdriver.manage().window().maximize();
		webdriver.manage().deleteAllCookies();



	}

public WebDriver getDriver() throws Exception {
	initialization();
	return this.webdriver;

}
	public static void CloseBrowser(){
		webdriver.quit();
	}


}
