package com.test.Pages;

import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.test.BaseClass.TestBase.webdriver;

public class AdminPage {

    public AdminPage() {

        PageFactory.initElements(webdriver, this);
    }

    /*   User Management Page under Admin Page Elements Starts Here  */
    private static final String LinkHeaders = "//b[text()='%s']";
    private static final String LinkButtons = "//input[@value='%s']";


    @FindBy(xpath = "//a[@id ='menu_admin_viewAdminModule']")
    public WebElement adminLink;

    @FindBy(xpath = "//Select[@id='systemUser_userType']")
    public WebElement selectuserType;

    @FindBy(xpath = "//a[text()='Nationalities']")
    public WebElement nationalitiesLink;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td[2]/a")
    public List<WebElement> listOfNationalities;

    @FindBy(xpath = "//b")
    public List<WebElement> mainMenuLinks;




    public static WebElement DynamicClick(String xpath, String text) {
        return webdriver.findElement(By.xpath(String.format(xpath, text)));
    }

    public static WebElement DynamicClickButtons(String text) {
        return webdriver.findElement(By.xpath(String.format(LinkButtons, text)));
    }

    /*   Admin Page Methods Web Elements Ends Here      */

    /*   Admin Page Methods Implementation Starts Here      */

    public void ClickOnRespectiveMainMenuLink(String LinkName){
      WebElement element =   DynamicClick(LinkHeaders,LinkName);
        element.click();
    }


    public void ClickOnGenericWebButtons(String LinkName){
        WebElement element =   DynamicClickButtons(LinkName);
        element.click();
    }

    public void EnterUserDetailsOnAddUserPage(DataTable dataTable) throws InterruptedException {



        Actions actions = new Actions(webdriver);

        List<String>  UserDetails = dataTable.transpose().asList(String.class);

        actions.moveToElement(selectuserType)
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys(UserDetails.get(1))
                .sendKeys(Keys.TAB)
                .sendKeys(UserDetails.get(2))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(UserDetails.get(3))
                .sendKeys(Keys.TAB)
                .sendKeys(UserDetails.get(3))
                .build()
                .perform();

        Thread.sleep(9000);

    }

    public void ValidateNationalities() throws IOException {
        FileReader fis  = new FileReader("/Users/thryakshari/Documents/ConnectPostgreSQL/ConnectPostgreSQL/src/main/resources/tableBulkData/tbl_code_value_data.txt");
        BufferedReader br = new BufferedReader(fis);
        List<String> NatyList = new LinkedList<>();
        List<String> ActualNatyList = new LinkedList<>();
        String Naty;
        while((Naty = br.readLine())!=null){
            NatyList.add(Naty);
           System.out.println(Naty);
        }
         listOfNationalities.forEach(p -> ActualNatyList.add(p.getText()));

        Collections.sort(ActualNatyList);
        Collections.sort(NatyList);
        Assert.assertEquals(ActualNatyList,NatyList);

    }

        public void PerformScrollUpAndScrollDown() throws InterruptedException {

            JavascriptExecutor js = (JavascriptExecutor)webdriver;

            for(int i=0; i<8;i++) {
                js.executeScript("window.scrollBy(0,1000)");
                Thread.sleep(1000);
            }

            for(int i=0; i<8;i++) {
                js.executeScript("window.scrollBy(0,-1000)");
                Thread.sleep(1000);
            }
        }


        public  void scrolltoRespectiveWebElement() throws InterruptedException {

            JavascriptExecutor js = (JavascriptExecutor)webdriver;
           WebElement  element = webdriver.findElement(By.xpath("//a[text()='Indian']"));
            js.executeScript("arguments[0].scrollIntoView();",element );
            Thread.sleep(4000);
        }

}
