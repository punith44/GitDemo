package com.test.Pages;

import com.test.Utils.CommonFunctions;
import com.test.Utils.ExcelFileUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.security.Key;
import java.util.List;
import java.util.Map;

import static com.test.BaseClass.TestBase.webdriver;
import static com.test.Utils.ExcelFileUtils.getCellValueFromSheet;
import static com.test.Utils.ExcelFileUtils.returnExcelSheet;

public class PIMPage extends ExcelFileUtils {

    private static final String SubLink = "//a[text()='%s']";
    public static Map ExcelDataMap;
    public String employeeFullName;

    public PIMPage() {

        PageFactory.initElements(webdriver, this);
    }


    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement fullNameField;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text()='Employee Name']/following-sibling::input[1]")
    public WebElement employeeNameSerachField;

    @FindBy(xpath = "//input[@id='searchBtn']")
    public WebElement searchButton;

    @FindBy(xpath = "//table/tbody/tr/td/a")
    public List<WebElement> employeeTable;

    @FindBy(xpath = "//input[@id='btnSave']")
    public WebElement personalDtlsEditBtn;

    @FindBy(xpath = "//input[@id='personal_txtOtherID']")
    public WebElement otherId;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement natyDropdown;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    public WebElement maritialstsdropdown;



    private WebElement DynamicClickOnSubMenu(String text) {
        return webdriver.findElement(By.xpath(String.format(SubLink, text)));
    }


    public void ClickOnGenericSubMenus(String LinkName) {
        WebElement element = DynamicClickOnSubMenu(LinkName);
        element.click();
    }

    public void AddNewEmployeeinHRMSSystem() throws IOException, InterruptedException {

        Actions actions = new Actions(webdriver);
        XSSFSheet sheet = ExcelFileUtils.returnExcelSheet(CommonFunctions.getEmployeeDataFilePath(), "PersonalDetails");
        ExcelDataMap = LoadExcelDataIntoHashMap(sheet, 1);

        actions.moveToElement(fullNameField)
                .click()
                .sendKeys(getCellValueFromSheet(sheet, "FirstName", 1))
                .sendKeys(Keys.TAB)
                .sendKeys(getCellValueFromSheet(sheet, "MiddleName", 1))
                .sendKeys(Keys.TAB)
                .sendKeys(getCellValueFromSheet(sheet, "LastName", 1))
                .sendKeys(Keys.TAB)
                .sendKeys(getCellValueFromSheet(sheet, "EmployeeId", 1))
                .build()
                .perform();

        CLoseExcelSheet();
        Thread.sleep(2000);
        saveButton.click();

    }


    public void SearchEmployeeByEmployeeName() throws InterruptedException {
        //new WebDriverWait(webdriver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Marketplace']")));
        Thread.sleep(3000);
        employeeFullName = ExcelDataMap.get("FirstName") + " " + ExcelDataMap.get("MiddleName") + " " +ExcelDataMap.get("LastName");
        System.out.println("Employee Full name Iss :"  + ExcelDataMap);
        System.out.println("Employee Full name Iss :"  + employeeFullName);
        employeeNameSerachField.sendKeys(employeeFullName);
        Thread.sleep(3000);
        searchButton.click();
    }

    public void validateEmployeisCreatedOrNotinTheSystem() throws InterruptedException {

        Thread.sleep(2000);
        List<WebElement> list = employeeTable;
        Assert.assertEquals(ExcelDataMap.get("EmployeeId"), list.get(0).getText());
        Assert.assertEquals(ExcelDataMap.get("FirstName") + " " + ExcelDataMap.get("MiddleName"),list.get(1).getText());
        Assert.assertEquals(ExcelDataMap.get("LastName"), list.get(2).getText());

    }


    public void enterPersonalDetailsinEmployeePage() throws InterruptedException {

        Actions actions = new Actions(webdriver);

        actions.moveToElement(otherId)
                .click()
                .sendKeys(ExcelDataMap.get("OtherId").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("DriversLicenseNumber").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("LicenseExpiryDate").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("SSNNumber").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("SINNumber").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("DateofBirth").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("NickName").toString())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(ExcelDataMap.get("MilitaryService").toString())
                .build()
                .perform();

                SelectValueFromDropDown(natyDropdown, ExcelDataMap.get("Nationality").toString());
                SelectValueFromDropDown(maritialstsdropdown, ExcelDataMap.get("MaritalStatus").toString());

                Thread.sleep(8000);
    }


    public void SelectValueFromDropDown(WebElement element, String value ){
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(value);
    }

}
