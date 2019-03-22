package com.backbase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

// Page object model
// For each page in the application one class is created

public class AddComputerPage {

	protected WebDriver driver;
	protected Actions action;

	By computerName = By.id("name");

	By introduced = By.id("introduced");

	By discontinued = By.id("discontinued");

	By company = By.id("company");

	By createComputer = By.xpath("//input[@type='submit']");

	By cancel = By.xpath("//a[@href='/computers']");

	public AddComputerPage(WebDriver dri) {
		this.driver = dri;
		this.action = new Actions(driver);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void typeComputerName(String name) {
		WebElement item = driver.findElement(computerName);
		item.sendKeys(name);
	}

	public void typeIntroduced(String date) {
		WebElement item = driver.findElement(introduced);
		item.sendKeys(date);
	}

	public void typeDiscontinuted(String date) {
		WebElement item = driver.findElement(discontinued);
		item.sendKeys(date);
	}

	public void typeCompany(String com) {
		WebElement item = driver.findElement(company);
		Select dropdown = new Select(item);
		dropdown.selectByVisibleText(com);
	}

	public void clickCreateComputerButton() {
		WebElement item = driver.findElement(createComputer);
		item.click();
	}

	public void clickCancelButton() {
		WebElement item = driver.findElement(cancel);
		item.click();
	}

}
