package com.makemytrip.testing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends DriverInitialisationTest {
	private SearchPage searchPage;

	@BeforeClass
	public void assignSearchPage() {
		System.out.println("set up...");
		searchPage = new SearchPage(driver);
	}

	@Test
	public void handleRandomPopupTest() throws IOException, InterruptedException {

		Thread.sleep(5000);
		// handling random popup
		try {
			driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
			searchPage.getPopupCloseBtn().click();
			driver.switchTo().defaultContent();
		} catch (NoSuchFrameException e) {
			System.out.println("no frame this time");
		}
	}

	@Test
	public void handleLoginPopupTest() throws IOException, InterruptedException {
		Thread.sleep(3000);
		// handling login pop up that appears random.
		try {
			// System.out.println(searchPage.getModalPopup());
			if (searchPage.getModalPopup().isDisplayed()) {
				System.out.println("modal pop up in...");

				searchPage.getLoginPopup().click();
			}
		} catch (Exception e) {
			System.out.println("modal not present this time.");
		}
	}

	@Test
	public void selectTripTypeTest() {
		// one way trip selected.
		searchPage.getOneWayTrip().click();
	}

	@Test
	public void fromCityTest() throws InterruptedException {
		// entering From city as Cochin.
		searchPage.getFromCity().click();
		Thread.sleep(2000);
		searchPage.typeFromCity().sendKeys("Cochin");
		Thread.sleep(2000);
		searchPage.typeFromCity().sendKeys(Keys.DOWN);
		searchPage.typeFromCity().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test
	public void toCityTest() throws InterruptedException {
		// entering To city as Delhi
		searchPage.typeToCity().sendKeys("Delhi");
		Thread.sleep(3000);
		searchPage.typeToCity().sendKeys(Keys.DOWN);
		searchPage.typeToCity().sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@Test
	public void departureDateTest() {
		// read upto 20 days price and select the day with lowest price as
		// departure date.
		List<WebElement> elements = new ArrayList<WebElement>();
		elements = (driver.findElements(By.xpath("//div[@class='DayPicker-Day']")));
		int leastPrice = Integer
				.parseInt(elements.get(0).findElement(By.xpath("//div[@class='dateInnerCell']/p[2]")).getText());
		int currentPrice;
		WebElement selectedDay = elements.get(0).findElement(By.xpath("//div[@class='dateInnerCell']/p[2]"));
		for (int i = 1; i < 20; i++) {
			currentPrice = Integer.parseInt(elements.get(i).findElement(By.xpath("div/p[2]")).getText());
			if (currentPrice < leastPrice) {
				leastPrice = currentPrice;
				selectedDay = elements.get(i).findElement(By.xpath("div/p[2]"));
			}
		}
		System.out.println("least price:" + leastPrice);
		selectedDay.click();
	}

	@Test
	public void selectPassengerTest() {
		// selecting 2 adults
		searchPage.getTravellerBtn().click();
		searchPage.getAdults().click();
	}

	@Test
	public void searchTest() {
		searchPage.getTravellerBtnApply().click();
		searchPage.getSearchButton().click();
	}
}
