package com.backbase.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.backbase.lib.ComputerLib;
import com.backbase.lib.HomePageLib;
import com.backbase.pages.EditComputerPage;
import com.backbase.pages.HomePage;
import com.backbase.utils.Computer;

// Page Object Model is followed - POM
// Thread.sleep just to used only for ease of  viewing on the browser. 
// In real time we need use fluent or explicit wait and sleep need to be avoided as it kills the performance

public class CreateComputerTest {

	public static void main(String[] args) throws InterruptedException {

		String path = System.getProperty("user.dir");
		System.out.println(path);

		// System.setProperty("webdriver.chrome.driver", "C:\\Users\\suguna
		// kumar\\eclipse-workspace\\Discovery\\resources\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://computer-database.herokuapp.com/computers");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		Thread.sleep(2000);

		HomePage home = new HomePage(driver);

		// click on "Add a new computer"
		home.clickAddNewComputer();

		Thread.sleep(2000);

		// ------- Add Computer ------------

		String computerName = "BackBaseTestComputer";

		Computer comp = new Computer(computerName);

		comp.setIntroducedDate("2000-04-04");

		comp.setDiscontinuedDate("2011-11-11");

		comp.setCompany("Thinking Machines");

		ComputerLib addcomputer = new ComputerLib(driver);
		// add a computer
		if (addcomputer.add(comp))
			System.out.println("Computer creted successfully with name : " + comp.getComputerName());

		// ------------ Verify the added computer in the list -----------
		HomePageLib filter = new HomePageLib(driver);
		Computer actualComputer = filter.getFirstFilterItem(comp.getComputerName());

		if (actualComputer.compareTo(comp))
			System.out.println("Computer verified successfully with name : " + comp.getComputerName());

		filter.clickItem(1);

		EditComputerPage edit = new EditComputerPage(driver);

		// ------------- Delete the added computer ----------------------
		if (edit.clickDeleteButton())
			System.out.println("Computer Deleted successfully with name : " + comp.getComputerName());

		driver.quit();

	}

}
