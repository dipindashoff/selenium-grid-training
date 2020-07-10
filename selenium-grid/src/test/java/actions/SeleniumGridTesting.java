package actions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGridTesting {

	WebDriver driver;
	String hubURL;

	@BeforeTest
	public void setUP() throws MalformedURLException {

		// Define desired capabilities
//		DesiredCapabilities cap = DesiredCapabilities.chrome();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.LINUX);

		// Chrome option
		ChromeOptions options = new ChromeOptions();
		options.merge(cap);
//		options.setHeadless(true);

		// Hub URL
		hubURL = "http://192.168.0.103:4444/wd/hub";

		// Create driver with hub address and capability
		driver = new RemoteWebDriver(new URL(hubURL), options);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Quitting...");
		driver.quit();
	}

	@Test
	public void simpleTest() {
		driver.get("http://newtours.demoaut.com/");
		System.out.println("Title: " + driver.getTitle());
	}

}
