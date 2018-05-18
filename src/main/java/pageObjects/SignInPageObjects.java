package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPageObjects {

	
	WebDriver driver;
	
	public SignInPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By loginButton = By.className("login");
	By emailCreateButton = By.id("email_create");
	By submitCreate = By.id("SubmitCreate");
	By gender = By.id("id_gender2");
	By customerFirstName= By.id("customer_firstname");
	By customerLastName = By.id("customer_lastname");
	By passwordButton = By.id("passwd");
	By selectByDays = By.id("days");
	By selectByMonths = By.id("months");
	By selectByYears = By.id("years");
	By companyTextBox = By.id("company");
	By addressOneTextBox = By.id("address1");
	By addressTwoTextBox = By.id("address2");
	By cityTextBox = By.id("city");
	By stateTextBox = By.id("id_state");
	By postCodeTextBox = By.id("postcode");
	By otherTextBox = By.id("other");
	By phoneTextBox = By.id("phone");
	By phoneMobileTextBox = By.id("phone_mobile");
	By aliasTextBox = By.id("alias");
	By submitAccountButton = By.id("submitAccount");
	By heading = By.cssSelector("h1");
	By accountText = By.className("account");
	By infoAccount = By.className("info-account");
	By logoutButton = By.className("logout");
	
	public By getLoginButton() {
		return loginButton;
	}
	public WebElement getEmailCreateButton() {
		return driver.findElement(emailCreateButton);
	}
	
	public WebElement getSubmitCreateButton() {
		return driver.findElement(submitCreate);
	}
	public By getGenderButton() {
		return gender;
	}
	public WebElement getCustomerFirstName() {
		return driver.findElement(customerFirstName);
	}
	
	public WebElement getCustomerLastName() {
		return driver.findElement(customerLastName);
	}
	public WebElement getPasswordButton() {
		return driver.findElement(passwordButton);
	}
	
	public WebElement getSelectOptionByDays() {
		return driver.findElement(selectByDays);
	}
	public WebElement getSelectOptionByMonths() {
		return driver.findElement(selectByMonths);
	}
	public WebElement getSelectOptionByYears(){
		return driver.findElement(selectByYears);
	}
	
	public WebElement getCompanyTextBox(){
		return driver.findElement(companyTextBox);
	}
	public WebElement getAddressOneTextBox(){
		return driver.findElement(addressOneTextBox);
	}
	public WebElement getAddressTwoTextBox(){
		return driver.findElement(addressTwoTextBox);
	}
	
	public WebElement getCityTextBox(){
		return driver.findElement(cityTextBox);
	}
	public WebElement getStateTextBox(){
		return driver.findElement(stateTextBox);
	}
	public WebElement getPostCodeTextBox(){
		return driver.findElement(postCodeTextBox);
	}
	
	public WebElement getOtherTextBox(){
		return driver.findElement(otherTextBox);
	}
	public WebElement getPhoneTextBox(){
		return driver.findElement(phoneTextBox);
	}
	
	public WebElement getPhoneMobileTextBox(){
		return driver.findElement(phoneMobileTextBox);
	}
	public WebElement getAliasTextBox(){
		return driver.findElement(aliasTextBox);
	}
	public WebElement getSubmitAccountButton(){
		return driver.findElement(submitAccountButton);
	}
	
	public By getHeadingText() {
		return  heading;
	}
	
	public String getAccountText() {
		return driver.findElement(accountText).getText();
	}
	
	public String getInfoAccountText() {
		return driver.findElement(infoAccount).getText();
	}
	public WebElement getLogoutButton() {
		return driver.findElement(logoutButton);
	}
	
	
}
