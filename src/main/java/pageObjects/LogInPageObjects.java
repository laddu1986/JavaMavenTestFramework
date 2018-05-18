package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPageObjects {
	
	
	/*
	 * All the objects concerned to the login in page reside here
	 */

	WebDriver driver;
	
	public LogInPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	
	By loginButton = By.className("login");
	By emailButton = By.id("email");
	By passwordButton = By.id("passwd");
	By submitLoginButton  = By.id("SubmitLogin");
	By heading = By.cssSelector("h1");
	By infoAccount = By.className("info-account");
	By logoutButton = By.className("logout");
	By accountButton = By.className("account");
	
	public By getLoginButton() {
		return loginButton;
	}
	public WebElement getEmailButton() {
		return driver.findElement(emailButton);
	}
	public WebElement getPasswordButton() {
		return driver.findElement(passwordButton);
	}
	public WebElement getSubmitLoginButton() {
		return driver.findElement(submitLoginButton);
	}
	public By getHeading() {
		return  heading;
	}
	public String getInfoAccountText() {
		return driver.findElement(infoAccount).getText();
	}
	public WebElement getLogoutButton() {
		return driver.findElement(logoutButton);
	}
	public WebElement getAccountButton() {
		return driver.findElement(accountButton);
	}
}
