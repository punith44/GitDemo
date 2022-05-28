package com.test.glueCode;


import com.test.BaseClass.TestBase;

import com.test.Pages.*;
import com.test.Utils.CommonFunctions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.test.Utils.CommonFunctions.getOrangeHRMURL;


public class GlueCode  extends TestBase {

	public LoginPage loginPage;
	public MyInfoPage myInfoPage;
	public AdminPage adminPage;
	public PIMPage pimPage;
	public AmazonPage amazonPage;
	public  JQueryPage jQueryPage;
	@Before
	public void LaunchBrowser() throws Exception {

		TestBase.initialization();
		loginPage = new LoginPage();
		myInfoPage = new MyInfoPage();
		adminPage = new AdminPage();
		pimPage = new PIMPage();
		amazonPage = new AmazonPage();
		jQueryPage = new JQueryPage();
	}

	@After
	public void Hide() throws Exception {

		TestBase.CloseBrowser();
	}



	@Given("I Navigate to OrangeHRM URL")
	public void i_navigate_to_orange_hrm_url() {

		webdriver.get(getOrangeHRMURL());
		
	}
	@When("I Enters Valid Username and Valid Password")
	public void i_enters_valid_username_and_valid_password() {

		loginPage.UserNamefld.sendKeys("Admin");
		loginPage.passwordfld.sendKeys("admin123");
	}
	@Then("I Clicks On Login Button")
	public void i_clicks_on_login_button() {

		loginPage.loginButton.click();
	}
	@Then("I Should be able to Login into Application")
	public void i_should_be_able_to_login_into_application() {

		Assert.assertTrue(myInfoPage.MyInfoLink.isDisplayed());
		
	}
	
	@Given("I am on JQuery html Page")
	public void IamonJQueryhtmlPage() throws InterruptedException {

		webdriver.get(CommonFunctions.getjqueryURL());
		Thread.sleep(3000);

	}



	@Then("I Click On Droppable Link")
	public void IClickOnDroppableLink() throws InterruptedException {
		jQueryPage.droppableLink.click();
		Thread.sleep(3000);
	}

	@Then("I perform Drag and Drop on the Web Page")
	public void IperformDragandDropontheWebPage() throws InterruptedException {
		jQueryPage.performDragAndDrop();
		Thread.sleep(3000);
	}



	@When("^I Enters InValid Username (.*) and InValid Password (.*)$")
	public void i_enters_in_valid_username_admin_and_in_valid_password_pass(String UserName, String Password) {

		loginPage.UserNamefld.sendKeys(UserName);
		loginPage.passwordfld.sendKeys(Password);
	}

	@Then("I Should Not be able to Login into Application")
	public void i_should_not_be_able_to_login_into_application() {
		Assert.assertTrue(loginPage.invalidCredentialsmsg.isDisplayed());
	}

	@Given("I Navigate to Orange HRM URL And Login to the Application")
	public void INavigatetoOrangeHRMURLAndLogintotheApplication()  {

		webdriver.get(getOrangeHRMURL());
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		loginPage.UserNamefld.sendKeys(CommonFunctions.getUserName());
		loginPage.passwordfld.sendKeys(CommonFunctions.getPassword());
		loginPage.loginButton.click();
	}

	@Then("I Click on {string} Link on Main Page")
	public void IClickOnHeaderLinks(String LinkName){
		adminPage.ClickOnRespectiveMainMenuLink(LinkName);

	}

	@When("I Click on {string} User button")
	public void ClickOnGenericWebButtons(String Button){
		adminPage.ClickOnGenericWebButtons(Button);

	}

	@Then("^I Enter following User details in Add User Page$")
	public void IEnterUserdetailsinAddUserPage(DataTable DataTable) throws InterruptedException {
		adminPage.EnterUserDetailsOnAddUserPage(DataTable);

	}

	@Then("^I Click on Nationalities Link under Admin Section$")
	public void IClickonNationalitiesLinkunderAdminSection() throws InterruptedException {
		adminPage.nationalitiesLink.click();

	}

	@Then("^I Validate the list of Nationalities in the page are as Expected$")
	public void ValidateNationalitiesinWebPage() throws InterruptedException, IOException {
		adminPage.ValidateNationalities();

	}


	@When("I Click on {string} Menu Icon")
	public void ClickOnSubMenuIcon(String MenuName){
		pimPage.ClickOnGenericSubMenus(MenuName);

	}

	@When("I Create New Employee in Add Employee Page")
	public void ICreateNewEmployeeinAddEmployeePageEmployeePage() throws IOException, InterruptedException {
		pimPage.AddNewEmployeeinHRMSSystem();

	}

	@Then("I Search Employee by Employee Name in Employee List Page")
	public void ISearchEmployeebyEmployeeNameinEmployeeListPage() throws IOException, InterruptedException {
		pimPage.SearchEmployeeByEmployeeName();

	}



	@When("I Click on Employee Id on Employee Page")
	public void IClickonEmployeeIdonEmployeePage() throws IOException, InterruptedException {
		pimPage.employeeTable.get(0).click();

	}

	@Then("I Click On Edit Personal Details Button")
	public void IClickOnEditPersonalDetailsButton() throws IOException, InterruptedException {
		new WebDriverWait(webdriver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnSave']")));
		pimPage.personalDtlsEditBtn.click();
	}

	@Then("I Validate Whether the Employee is Created in the System")
	public void IValidateWhethertheEmployeeisCreatedintheSystem() throws IOException, InterruptedException {
		pimPage.validateEmployeisCreatedOrNotinTheSystem();

	}

	@Then("I Click on Save Button And validate All Employee Details")
	public void IClickonSaveButtonAndvalidateAllEmployeeDetails() throws IOException, InterruptedException {

		new WebDriverWait(webdriver, 40).until(ExpectedConditions.visibilityOf(pimPage.personalDtlsEditBtn));

		pimPage.personalDtlsEditBtn.click();

	}


	@When("I Update all the personal details in the employee Page")
	public void IUpdateallthepersonaldetailsintheemployeePage() throws IOException, InterruptedException {
		pimPage.enterPersonalDetailsinEmployeePage();

	}

	@Then("I validate whether all the Web Elements are displayed in Login Page")
	public void IvalidatewhetheralltheWebElementsaredisplayedinLoginPage() throws IOException, InterruptedException {

		new WebDriverWait(webdriver, 40).until(ExpectedConditions.visibilityOf(loginPage.footerLink));
		new WebDriverWait(webdriver, 40).until(ExpectedConditions.visibilityOf(loginPage.forgetPwdLink));

		Assert.assertTrue(loginPage.footerLink.isDisplayed());
		Assert.assertTrue(loginPage.orangeHrmLogo.isDisplayed());
		Assert.assertFalse(loginPage.socialIcons.isEmpty());
		Assert.assertEquals(loginPage.socialIcons.size(), 4);
		Assert.assertTrue(loginPage.footerElements.isDisplayed());
		Assert.assertTrue(loginPage.forgetPwdLink.isDisplayed());

	}


	@Then("I Validate All the following main Menu links are displayed")
	public void IValidateAllthefollowingmainMenulinksaredisplayed(DataTable dataTable) throws IOException, InterruptedException {
		List<String> mainMenuLinksList = dataTable.transpose().asList(String.class);

		List<String>  links = new LinkedList<>();
		Assert.assertFalse(adminPage.mainMenuLinks.isEmpty());
		Assert.assertEquals(adminPage.mainMenuLinks.size(),mainMenuLinksList.size() );
		for(int i=0; i<adminPage.mainMenuLinks.size(); i++){

			links.add(adminPage.mainMenuLinks.get(i).getText());

		}
		System.out.println(links);

		for(int i=0; i<mainMenuLinksList.size();i++){

			Assert.assertTrue(links.contains(mainMenuLinksList.get(i)));
		}

	}


	@When("I Navigate to Amazon url")
	public void INavigatetoAmazonurl() throws IOException, InterruptedException {
		webdriver.get(CommonFunctions.getamazonUrl());
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(5000);
	}


	@When("I Click On {string} menu Link")
	public void ClickOnamazonSubMenuIcon(String MenuName) throws InterruptedException {
		amazonPage.ClickOnRespectiveMainMenuLink(MenuName);

	}
	@Then("I check whether I am on Mobile Phones Page")
	public void IcheckwhetherIamonMobilePhonesPage() throws IOException, InterruptedException {

		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = webdriver.getTitle();
		System.out.println("======>>>>"+ actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);

		Thread.sleep(3000);
	}


	@Then("I perform Some Navigation Commands")
	public void IperformSomeNavigationCommands() throws IOException, InterruptedException {

		//Navigation Commands
		webdriver.navigate().back();
		String homePageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("------->>>" + homePageTitle);
		String homePageTitle_Expected = webdriver.getTitle();
		Assert.assertEquals(homePageTitle,homePageTitle_Expected);
		Thread.sleep(3000);

		//Navigation Commands
		webdriver.navigate().refresh();
		Thread.sleep(3000);

		String homePageTitlea = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("------->>>" + homePageTitlea);
		String homePageTitle_Expecteda = webdriver.getTitle();
		Assert.assertEquals(homePageTitlea,homePageTitle_Expecteda);
		Thread.sleep(3000);


		//Navigation Commands
		webdriver.navigate().forward();
		String expectedTitle = "Mobile Phones: Buy New Mobiles Online at Best Prices in India | Buy Cell Phones Online - Amazon.in";
		String actualTitle = webdriver.getTitle();
		System.out.println("======>>>>"+ actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
		Thread.sleep(3000);


	}

	@When("I search product {string} Keyword")
	public void INavigatetoAmazonurl(String keyword) throws IOException, InterruptedException {
	CommonFunctions.enterTextinSearchField(amazonPage.amazonsearchbox, keyword);
	Thread.sleep(4000);
	}

	@Then("I select {string} product")
	public void Iselectproduct(String product) throws IOException, InterruptedException {

		amazonPage.SelectProductBasedOnInput(product);

	}

	@Then("I take the Amazon Home Page ScreenShot")
	public void ItaketheAmazonHomePageScreenShot() throws IOException, InterruptedException {

		amazonPage.takeScreenShot();

	}

	@Then("I Find total Number of Broken Links present in a Web Page")
	public void IFindtotalNumberofBrokenLinkspresentinaWebPage() throws IOException, InterruptedException {

		amazonPage.findTotalBrokenLinksPresentInAPage();

	}

	@Then("I Validate Tooltip is Present or Not on image Icon")
	public void IValidateTooltipisPresentorNotonimageIcon() throws IOException, InterruptedException {

		myInfoPage.validateToolTip();

	}

	@Then("I Choose the Image and Click on Upload Button")
	public void IChoosetheImageandClickonUploadButton() throws IOException, InterruptedException, AWTException {

		myInfoPage.ChooseFile();

	}

	@Then("I Test the Scroll up and Scroll Down function")
	public void ITesttheScrollupandScrollDownfunction() throws IOException, InterruptedException, AWTException {

		adminPage.PerformScrollUpAndScrollDown();

	}

	@Then("I Test Scroll to View Function on the Web Page")
	public void ITestScrolltoViewFunctionontheWebPage() throws IOException, InterruptedException, AWTException {

		adminPage.scrolltoRespectiveWebElement();

	}


	}


