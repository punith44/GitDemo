package com.test.Pages;

import com.test.Utils.CommonFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import static com.test.BaseClass.TestBase.webdriver;

public class AmazonPage {

    public AmazonPage() {

        PageFactory.initElements(webdriver, this);
    }

    private static final String LinkHeaders = "//a[text()='%s']";


    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement amazonsearchbox;

    @FindBy(xpath = "//div[@class='autocomplete-results-container']/div/div/div/span")
    public List<WebElement> searchResults;


    public static WebElement DynamicClickButtons(String text) {
        return webdriver.findElement(By.xpath(String.format(LinkHeaders, text)));
    }

    public void ClickOnRespectiveMainMenuLink(String LinkName) throws InterruptedException {
        WebElement element =   DynamicClickButtons(LinkName);
        element.click();

        Thread.sleep(5000);
    }


    public void  SelectProductBasedOnInput(String product) throws InterruptedException {

        Thread.sleep(4000);
        List<WebElement>  list = webdriver.findElements(By.xpath("//div[@class='autocomplete-results-container']/div/div/div/span"));

        System.out.println("THe List Size iss " + list.size() );

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().trim().equals(product)){
                list.get(i).click();
                break;
            }

        }

        Thread.sleep(5000);
    }



    public void takeScreenShot() throws IOException {

        TakesScreenshot ts = (TakesScreenshot)webdriver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(file, new File((System.getProperty("user.dir")+ File.separator +"src/test/resources/TestEvidences/AmazonHomePage_"+ CommonFunctions.getCurrentDateTime()+".png")));
    }


    public void findTotalBrokenLinksPresentInAPage() throws IOException {

        List<WebElement> activeLinks = new LinkedList<>();

        List<WebElement>  linksList = webdriver.findElements(By.tagName("a"));

        System.out.println("The Total No Of Links PResent in a Web Page are "+ linksList.size());

        for (int i=0; i<linksList.size();i++){

            if(linksList.get(i).getAttribute("href") != null ){

                activeLinks.add(linksList.get(i));
                System.out.println(linksList.get(i).getAttribute("href"));
            }

        }

        for(int i=0;i<activeLinks.size(); i++){

            try {


                if (!activeLinks.get(i).getAttribute("href").contains("javascript")) {
                    HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(i).getAttribute("href")).openConnection();
                    connection.connect();
                    String msg = connection.getResponseMessage();
                    int statuscode = connection.getResponseCode();
                    connection.disconnect();
                    System.out.println(activeLinks.get(i).getAttribute("href") + "----->>>" + statuscode+ "------>"+ msg);

                }
            }catch (Exception e){

                continue;
            }


        }

    }

}
