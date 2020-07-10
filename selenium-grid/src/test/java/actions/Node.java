package actions;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Node {

	WebDriver driver;
	String hubURL;

	@Test
	public void simpleTest() throws MalformedURLException {
		
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
		driver.get("http://newtours.demoaut.com/");
		System.out.println("Title: " + driver.getTitle());
		
		System.out.println("Quitting...");
		driver.quit();
	}
	
	@Test
	public void simpleTest2() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.LINUX);


		// Hub URL
		hubURL = "http://192.168.0.103:4444/wd/hub";

		// Create driver with hub address and capability
		driver = new RemoteWebDriver(new URL(hubURL), cap);
		driver.get("http://gmail.com/");
		System.out.println("Title: " + driver.getTitle());
		
		System.out.println("Quitting...");
		driver.quit();
	}

}
