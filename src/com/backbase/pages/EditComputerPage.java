package com.backbase.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Page object model
// For each page in the application one class is created

public class EditComputerPage extends AddComputerPage {

	By delete = By.xpath("//form/input[@type='submit']");

	public EditComputerPage(WebDriver dri) {
		super(dri);
	}

	public boolean clickDeleteButton() {
		WebElement item = driver.findElement(delete);
		item.click();
		return true;
	}

}
