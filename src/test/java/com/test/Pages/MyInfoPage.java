package com.test.Pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static com.test.BaseClass.TestBase.webdriver;

public class MyInfoPage {


    public MyInfoPage() {

        PageFactory.initElements(webdriver, this);
    }



    @FindBy(xpath = "//input[@value='Marketplace']")
    public  WebElement Marketplace;


    @FindBy(xpath = "//a[@id='menu_pim_viewMyDetails']")
    public  WebElement MyInfoLink;

    @FindBy(xpath = "//input[@id='btnSave']")
    public  WebElement personalEditButton;

    @FindBy(xpath = "//img[@id='empPic']")
    public  WebElement empPicIcon;

    @FindBy(xpath = "//div[@id='tiptip_content']")
    public  WebElement tooltiptext;

    @FindBy(xpath = "//input[@id='photofile']")
    public  WebElement chooseFileBtn;

    @FindBy(xpath = "//input[@id='btnSave']")
    public  WebElement uploadBtn;




    public void validateToolTip() throws InterruptedException {

        String expectedtooltipMsg = "Change Photo";

        Actions actions = new Actions(webdriver);

        actions.moveToElement(empPicIcon)
                .build()
                .perform();

        Thread.sleep(5000);
        String actualToolTipmsg = tooltiptext.getText();
        System.out.println("The Actual tool tip is " + actualToolTipmsg);
        Assert.assertEquals(actualToolTipmsg,expectedtooltipMsg);
        Assert.assertTrue(tooltiptext.isDisplayed());

    }

    public void ChooseFile() throws InterruptedException, AWTException {


        Actions actions = new Actions(webdriver);

        empPicIcon.click();
        Thread.sleep(2000);

        actions.moveToElement(chooseFileBtn)
                .click()
                .build()
                .perform();

        Thread.sleep(4000);


        StringSelection ss = new StringSelection("C:\\Users\\lokan\\OneDrive\\Documents\\Selenium_Logo.png");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        //imitate mouse events like ENTER, CTRL+C, CTRL+V
        Robot robot = new Robot();
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(90);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(7000);
        uploadBtn.click();
        Thread.sleep(7000);

    }

}
