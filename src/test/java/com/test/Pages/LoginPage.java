package com.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.BaseClass.TestBase;

import java.util.List;

public class LoginPage extends TestBase {

    public LoginPage() {

        PageFactory.initElements(webdriver, this);

    }


    // Page Factory or Object Repository

    @FindBy(xpath = "//input[@id='txtUsername']")
    public WebElement UserNamefld;

    @FindBy(xpath = "//input[@id='txtPassword']")
    public WebElement passwordfld;

    @FindBy(xpath = "//input[@id='btnLogin']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Forgot your password?']")
    public WebElement forgetPwdLink;

    @FindBy(xpath = "//span[text()='Invalid credentials']")
    public WebElement invalidCredentialsmsg;

    @FindBy(xpath = "//div[@id='divLogo']/img")
    public WebElement orangeHrmLogo;

	@FindBy(xpath = "//div[@id='social-icons']/a")
	public List<WebElement> socialIcons;

	@FindBy(xpath = "//div[@id='footer']/div[1]/a")
	public WebElement footerLink;

	@FindBy(xpath = "//div[@id='footer']/div[1]")
	public WebElement footerElements;




}
