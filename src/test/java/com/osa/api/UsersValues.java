package com.osa.api;

public class UsersValues {
	private String xpath=null;
	private String expectedValue=null;
	
	public UsersValues(String xpath, String expectedValue) {
		this.xpath = xpath;
		this.expectedValue = expectedValue;
	}
	public String getXpath() {
		return xpath;
	}
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	public String getExpectedValue() {
		return expectedValue;
	}
	public void setExpectedValue(String expectedValue) {
		this.expectedValue = expectedValue;
	}
}
