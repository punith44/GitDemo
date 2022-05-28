package com.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.BaseClass.TestBase.webdriver;

public class JQueryPage {



    public JQueryPage() {

        PageFactory.initElements(webdriver, this);
    }


    @FindBy(xpath = " //a[text()='Droppable']")
    public WebElement droppableLink;

    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement src;

    @FindBy(xpath = "//div[@id='droppable']")
    public WebElement trgt;

    public void performDragAndDrop() throws InterruptedException {

        Thread.sleep(3000);

        Actions actions = new Actions(webdriver);

        webdriver.switchTo().frame(webdriver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        //        actions.clickAndHold(src)
//                .moveToElement(trgt)
//                .release()
//                .build()
//                .perform();


        actions.dragAndDrop(src,trgt).build().perform();


    }

}
