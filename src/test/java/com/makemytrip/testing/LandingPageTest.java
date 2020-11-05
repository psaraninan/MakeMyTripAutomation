package com.makemytrip.testing;

import java.io.IOException;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

public class LandingPageTest extends DriverInitialisationTest {
	private WebDriver driverLanding;

	@Test
	public void startPageTest() throws IOException, InterruptedException {
		driverLanding = driverInitialise();
		driverLanding.get("https://www.makemytrip.com/");
		driverLanding.manage().window().maximize();
		Thread.sleep(9000);
	}

}
