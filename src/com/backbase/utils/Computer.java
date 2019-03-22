package com.backbase.utils;

public class Computer {

	String computerName;
	String introducedDate = null;
	String discontintuedDate = null;
	String company = null;

	public Computer(String computerName) {
		this.computerName = computerName;
	}

	public String getComputerName() {
		return this.computerName;
	}

	public String getIntroducedDate() {
		return this.introducedDate;
	}

	public String getDiscontinutedDate() {
		return this.discontintuedDate;
	}

	public String getCompany() {
		return this.company;
	}

	public void setIntroducedDate(String introducedDate) {
		this.introducedDate = introducedDate;
	}

	public void setDiscontinuedDate(String discontinuedDate) {
		this.discontintuedDate = discontinuedDate;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public boolean compareTo(Computer expectedComputer) {
		if (!expectedComputer.computerName.equals(this.computerName.trim())) {
			System.out.println(
					"Expected computer name is " + expectedComputer.computerName + " but was " + this.computerName);
			return false;
		}
		String[] date = this.introducedDate.trim().split(" ");
		String day = date[0];
		String year = date[2];
		if (!expectedComputer.introducedDate.startsWith(year) || !expectedComputer.introducedDate.endsWith(day)) {
			System.out.println("Expected introduced date is " + expectedComputer.introducedDate + " but was "
					+ this.introducedDate);
			return false;
		}

		date = this.discontintuedDate.trim().split(" ");
		day = date[0];
		year = date[2];

		if (!expectedComputer.discontintuedDate.startsWith(year) || !expectedComputer.discontintuedDate.endsWith(day)) {
			System.out.println("Expected discontinued date is " + expectedComputer.discontintuedDate + " but was "
					+ this.discontintuedDate);
			return false;
		}
		if (!expectedComputer.company.equals(this.company.trim())) {
			System.out.println("Expected company is " + expectedComputer.company + " but was " + this.company);
			return false;
		}
		return true;
	}

}
