package com.test.Utils;

import com.test.BaseClass.TestBase;
import com.test.Pages.LoginPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommonFunctions {

    private static final String OrangeHRMURL = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";
    private static final String amazonUrl = "https://www.amazon.in/";
    private static final String jqueryURL = "https://jqueryui.com/";
    private static final String UserName = "Admin";
    private static final String Password = "admin123";
    private static final String EmpDataFilePath = (System.getProperty("user.dir")+ File.separator + "src/test/resources/CustomerData.xlsx");

    public static String getOrangeHRMURL(){
    return OrangeHRMURL;
    }

    public static String getjqueryURL(){
        return jqueryURL;
    }

    public static String getUserName(){
        return UserName;
    }

    public static String getPassword(){
        return Password;
    }

    public static String getEmployeeDataFilePath(){
        return EmpDataFilePath;
    }

    public static String getamazonUrl(){
        return amazonUrl;
    }


    public static void enterTextinSearchField(WebElement element, String text){
        element.clear();
        element.sendKeys(text);
    }


    public static void JsClick(WebElement element, WebDriver webDriver){

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].click();",element);
    }

public static String getCurrentDateTime(){

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    LocalDateTime now = LocalDateTime.now();
    System.out.println(dtf.format(now));
    return dtf.format(now);
}



}
