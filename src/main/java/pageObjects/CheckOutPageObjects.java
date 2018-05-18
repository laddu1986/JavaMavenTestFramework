package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPageObjects {

	

	WebDriver driver;
	
	public CheckOutPageObjects(WebDriver driver) {
		this.driver=driver;
	}
	
	By womenButtonOnTab = By.linkText("Women");
	By product = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
	By submitButton = By.name("Submit");
	By proceedToCheckOutButton = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");
	By cartNavigation = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
	By processAddress = By.name("processAddress");
	By uniformCgv = By.id("uniform-cgv");
	By processCarrier = By.name("processCarrier");
	By bankWireButton = By.className("bankwire");
	By cartNavigationButton = By.xpath("//*[@id='cart_navigation']/button");
	By heading = By.cssSelector("h1");
	By stepDoneDisplayText= By.xpath("//li[@class='step_done step_done_last four']");
	By stepEndDisplayText = By.xpath("//li[@id='step_end' and @class='step_current last']");	
	By orderMessage = By.xpath("//*[@class='cheque-indent']/strong");
	
	
	public By getWomenButtonOnTab() {
		return  womenButtonOnTab;
	}
	public WebElement getProduct() {
		return driver.findElement(product);
	}
	
	public By getSubmitButton() {
		return  submitButton;
	}
	public By proceedToCheckOutButton() {
		return  proceedToCheckOutButton;
	}
	public By getCartNavigation() {
		return  cartNavigation;
	}
	public By getProcessAddress() {
		return  processAddress;
	}
	public By uniformCgv() {
		return  uniformCgv;
	}
	public WebElement processCarrier() {
		return  driver.findElement(processCarrier);
	}
	public By bankWireButton() {
		return  bankWireButton;
	}
	public By getCartNavigationButton() {
		return  cartNavigationButton;
	}
	public By getHeading() {
		return  heading;
	}
	public WebElement stepDoneDisplayText() {
		return  driver.findElement(stepDoneDisplayText);
	}
	public WebElement stepEndDisplayText() {
		return  driver.findElement(stepEndDisplayText);
	}
	
	public WebElement orderMessage() {
		return  driver.findElement(orderMessage);
	}
}
