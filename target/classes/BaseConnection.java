package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseConnection {

	protected Properties prop;
	static protected WebDriver driver;
	protected WebDriverWait wait;

	public WebDriver initializeDriver() throws IOException {

		/*
		 * Retrieving the values from a properties file and then as per the need we can
		 * change the keys(url, browser etc)
		 */

		prop = new Properties();
		FileInputStream fs = new FileInputStream("src/main/java/resources/config.properties");
		prop.load(fs);
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/resources/chromedriver");
			driver = new ChromeDriver();
		}
		if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/src/main/java/geckodriver");
			driver = new FirefoxDriver();
		}

		// Adding implicit wait so that the wait is applicable to all the elements for
		// the particular instance
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().window(driver.getWindowHandle());
		wait = new WebDriverWait(driver, 10, 50);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Screenshot/" + result + " ss.png"));
		

	}

}
