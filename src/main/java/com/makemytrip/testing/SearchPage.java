package com.makemytrip.testing;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	By fromCity = By.xpath("//label[@for='fromCity']");
	By typeFromCity = By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/input");
	By toCity = By.xpath("//label[@for='toCity']");
	By loginPopup = By.xpath("//ul[@class='userSection pushRight']/li[6]");
	By modalPopup = By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser']/div[2]");
	By departure = By.id("departure");
	By popupCloseBtn = By.cssSelector("a[class='close']");
	By typeToCity = By.xpath("//div[@class='hsw_autocomplePopup autoSuggestPlugin']/div/input");
	By roundTrip = By.xpath("//li[@data-cy='roundTrip']");
	By oneWayTrip = By.xpath("//li[@data-cy='oneWayTrip']");
	By adults = By.xpath("//div[@class='travellers gbTravellers']/div/ul/li[2]");
	By travellerBtn = By.xpath("//div[@data-cy='flightTraveller']");
	By travellersApplyBtn = By.cssSelector("button[type='button']");
	By searchButton = By.xpath("//p[@data-cy='submit']/a");
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getFromCity() {
		return driver.findElement(fromCity);
	}

	public WebElement typeFromCity() {
		return driver.findElement(typeFromCity);
	}

	public WebElement typeToCity() {
		return driver.findElement(typeToCity);
	}

	public WebElement getToCity() {
		return driver.findElement(toCity);
	}

	public WebElement getLoginPopup() {
		return driver.findElement(loginPopup);
	}

	public WebElement getModalPopup() {
		return driver.findElement(modalPopup);
	}

	public WebElement getPopupCloseBtn() {
		return driver.findElement(popupCloseBtn);
	}

	public WebElement getRoundTrip() {
		return driver.findElement(roundTrip);
	}

	public WebElement getOneWayTrip() {
		return driver.findElement(oneWayTrip);
	}

	public WebElement getAdults() {
		System.out.println("get adults count");
		
		List<WebElement> adultsList = new ArrayList<WebElement>();
		adultsList = driver.findElements(adults);
		System.out.println("number of adults tabs :"+adultsList.size());
		return adultsList.get(0);
	}

	public WebElement getTravellerBtn() {
		return driver.findElement(travellerBtn);
	}
	public WebElement getTravellerBtnApply() {
		return driver.findElement(travellersApplyBtn);
	}
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

}
