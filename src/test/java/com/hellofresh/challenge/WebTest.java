package com.hellofresh.challenge;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.CheckOutPageObjects;
import pageObjects.LogInPageObjects;
import pageObjects.SignInPageObjects;
import resources.BaseConnection;
import resources.DataObjects;
import resources.Utilities;

public class WebTest extends BaseConnection {

	public static Logger log = LogManager.getLogger(BaseConnection.class.getName());
	ApplicationContext context;

	@Parameters({ "url" })
	@BeforeTest
	public void setUp(String url) throws IOException {
		driver = initializeDriver();
		driver.get(url);
		context = new ClassPathXmlApplicationContext("spring.xml");
		log.info("All instance initialization done!!");
	}

	@Test(priority = 1)
	public void signInTest() {

		DataObjects databean = context.getBean("signUpDataBean", DataObjects.class);
		SignInPageObjects signObj = new SignInPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(signObj.getLoginButton())).click();
		signObj.getEmailCreateButton().sendKeys(Utilities.getTestAccount());
		signObj.getSubmitCreateButton().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(signObj.getGenderButton())).click();
		signObj.getCustomerFirstName().sendKeys(databean.getName());
		signObj.getCustomerLastName().sendKeys(databean.getLastName());
		signObj.getPasswordButton().sendKeys(databean.getPassword());
		Select select = new Select(signObj.getSelectOptionByDays());
		select.selectByValue("1");
		select = new Select(signObj.getSelectOptionByMonths());
		select.selectByValue("1");
		select = new Select(signObj.getSelectOptionByYears());
		select.selectByValue("2000");
		signObj.getCompanyTextBox().sendKeys(databean.getCompany());
		signObj.getAddressOneTextBox().sendKeys(databean.getAddressLine1());
		signObj.getAddressTwoTextBox().sendKeys(databean.getAddressLine2());
		signObj.getCityTextBox().sendKeys(databean.getCity());
		select = new Select(signObj.getStateTextBox());
		select.selectByVisibleText("Colorado");
		signObj.getPostCodeTextBox().sendKeys(databean.getPostCode());
		signObj.getOtherTextBox().sendKeys(databean.getOtherCode());
		signObj.getPhoneTextBox().sendKeys(databean.getPhoneNumber());
		signObj.getPhoneMobileTextBox().sendKeys(databean.getMobilePhoneNumber());
		signObj.getAliasTextBox().sendKeys("hf");
		signObj.getSubmitAccountButton().click();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(signObj.getHeadingText()));
		assertEquals(heading.getText(), "MY ACCOUNT");
		assertEquals(signObj.getAccountText(), databean.getName() + " " + databean.getLastName());
		Assert.assertTrue(signObj.getInfoAccountText().contains(databean.getWelcomeText()));
		Assert.assertTrue(signObj.getLogoutButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains(databean.getUrlText()));
		signObj.getLogoutButton().click();
		log.info("SignIn test completed Successfully!!!");
	}

	@Test(dependsOnMethods = { "signInTest" }, dataProvider = "getData")
	public void logInTest(String existingUserEmail, String existingUserPassword) {

		DataObjects loginDataBean = context.getBean("logInTestDataBean", DataObjects.class);
		LogInPageObjects loginObj = new LogInPageObjects(driver);
		// String fullName = "Joe Black";
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginObj.getLoginButton())).click();
		loginObj.getEmailButton().sendKeys(existingUserEmail);
		loginObj.getPasswordButton().sendKeys(existingUserPassword);
		loginObj.getSubmitLoginButton().click();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(loginObj.getHeading()));
		assertEquals("MY ACCOUNT", heading.getText());
		assertEquals(loginDataBean.getFullName(), loginObj.getAccountButton().getText());
		Assert.assertTrue(loginObj.getInfoAccountText().contains(loginDataBean.getInfoAccountText()));
		Assert.assertTrue(loginObj.getLogoutButton().isDisplayed());
		Assert.assertTrue(driver.getCurrentUrl().contains(loginDataBean.getUrlText()));
		log.info("Log In test completed Successfully!!!");
	}

	@Test(dependsOnMethods = { "logInTest" })
	public void checkoutTest() {
		DataObjects dataBean = context.getBean("checkOutDataBean", DataObjects.class);
		CheckOutPageObjects checkOutObj = new CheckOutPageObjects(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getWomenButtonOnTab())).click();
		checkOutObj.getProduct().click();
		checkOutObj.getProduct().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getSubmitButton())).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.proceedToCheckOutButton())).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getCartNavigation())).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getProcessAddress())).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.uniformCgv())).click();
		checkOutObj.processCarrier().click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.bankWireButton())).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getCartNavigationButton())).click();
		WebElement heading = wait.until(ExpectedConditions.visibilityOfElementLocated(checkOutObj.getHeading()));
		assertEquals("ORDER CONFIRMATION", heading.getText());
		Assert.assertTrue(checkOutObj.stepDoneDisplayText().isDisplayed());
		Assert.assertTrue(checkOutObj.stepEndDisplayText().isDisplayed());
		Assert.assertTrue(checkOutObj.orderMessage().getText().contains(dataBean.getCheckOutMessage()));
		Assert.assertTrue(driver.getCurrentUrl().contains(dataBean.getUrlOrder()));
		log.info("Check Out test completed Successfully!!!");
	}

	@DataProvider
	private Object[][] getData() {
		return new Object[][] { { "hf_challenge_123456@hf12345.com", "12345678" } };
	}

	@AfterTest
	public void tearDown() {
		driver.close();

	}
}
