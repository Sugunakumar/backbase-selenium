package com.backbase.lib;

import org.openqa.selenium.WebDriver;

import com.backbase.pages.HomePage;
import com.backbase.utils.Computer;

public class HomePageLib extends HomePage {

	public HomePageLib(WebDriver dri) {
		super(dri);
	}

	public Computer getFirstFilterItem(String computerName) {
		typefilterText(computerName);
		clickfilterButton();
		return getComputerItemDetails(1);
	}

}
