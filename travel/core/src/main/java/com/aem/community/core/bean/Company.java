package com.aem.community.core.bean;

public class Company {

	private String companyName;
	private String companyTagline;
	private int employees;

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyTagline() {
		return companyTagline;
	}

	public int getEmployees() {
		return employees;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanyTagline(String companyTagline) {
		this.companyTagline = companyTagline;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Company [companyName " + companyName + ", companyTagline = " + companyTagline + ", employees = "
				+ employees + "]";
	}

}
