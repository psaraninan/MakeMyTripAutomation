package com.makemytrip.testing;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverInitialisationTest {
	private static Logger log = LogManager.getLogger(DriverInitialisationTest.class.getName());
	protected static WebDriver driver;

	public WebDriver driverInitialise() throws IOException, InterruptedException {
		System.out.println("Driver initialisation...");
		FileInputStream inputFile = new FileInputStream(
				System.getProperty("user.dir") + "\\resources\\data.properties");
		Properties properties = new Properties();
		properties.load(inputFile);
		String browser = properties.getProperty("browser");
		log.always().log(browser);
		if (browser.equalsIgnoreCase("chrome")) {
			log.always().log("inside chrome initialisation");
			System.setProperty("webdriver.chrome.driver",
					(System.getProperty("user.dir") + "\\resources\\chromedriver.exe"));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--enable-automation");
			if (browser.contains("headless")) {
				options.addArguments("headless");
			}

			driver = new ChromeDriver(options);
			Thread.sleep(3000);
			return driver;

		} else {
			log.always().log("inside chrome ELSE initialisation");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			return driver;

		}

	}

}
