package com.backbase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.backbase.utils.Computer;

// Page object model
// For each page in the application one class is created

public class HomePage {

	protected WebDriver driver;
	protected Actions action;

	By addNewComputer = By.id("add");

	By filterinput = By.id("searchbox");

	By filterbutton = By.id("searchsubmit");

	public HomePage(WebDriver dri) {
		this.driver = dri;
		this.action = new Actions(driver);
	}

	public void typefilterText(String text) {
		WebElement item = driver.findElement(filterinput);
		item.sendKeys(text);
	}

	public void clickfilterButton() {
		WebElement item = driver.findElement(filterbutton);
		item.click();
	}

	public void clickAddNewComputer() {
		WebElement item = driver.findElement(addNewComputer);
		item.click();
	}

	public boolean clickItem(int item) {
		if (item > 0 && item <= 10) {
			By itemComputerName = By.xpath("//tbody/tr[" + item + "]/td[1]/a");

			driver.findElement(itemComputerName).click();
			return true;
		}
		return false;
	}

	public Computer getComputerItemDetails(int item) {

		if (item > 0 && item <= 10) {

			By itemComputerName = By.xpath("//tbody/tr[" + item + "]/td[1]");
			By itemIntroduced = By.xpath("//tbody/tr[" + item + "]/td[2]");
			By itemDiscontinued = By.xpath("//tbody/tr[" + item + "]/td[3]");
			By itemCompany = By.xpath("//tbody/tr[" + item + "]/td[4]");

			String computerName = driver.findElement(itemComputerName).getAttribute("textContent");
			String introduced = driver.findElement(itemIntroduced).getAttribute("textContent");
			String discontinued = driver.findElement(itemDiscontinued).getAttribute("textContent");
			String company = driver.findElement(itemCompany).getAttribute("textContent");

			Computer com = new Computer(computerName);
			if (!introduced.isEmpty())
				com.setIntroducedDate(introduced);
			if (!discontinued.isEmpty())
				com.setDiscontinuedDate(discontinued);
			if (!company.isEmpty())
				com.setCompany(company);

			return com;
		}
		return null;
	}

	public void mouseHover(WebElement element) {
		action.moveToElement(element).perform();
	}

}
