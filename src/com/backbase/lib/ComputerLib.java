package com.backbase.lib;

import org.openqa.selenium.WebDriver;

import com.backbase.pages.AddComputerPage;
import com.backbase.utils.Computer;

public class ComputerLib extends AddComputerPage {

	public ComputerLib(WebDriver dri) {
		super(dri);
	}

	public boolean add(Computer computer) {
		typeComputerName(computer.getComputerName());
		typeIntroduced(computer.getIntroducedDate());
		typeDiscontinuted(computer.getDiscontinutedDate());
		typeCompany(computer.getCompany());

		clickCreateComputerButton();
		return true;
	}

}
