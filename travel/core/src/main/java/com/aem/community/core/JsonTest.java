package com.aem.community.core;

import com.google.gson.Gson;

public class JsonTest {
	
	String firstName;
	String lastName;
	String city;
	
	public JsonTest() {
	
	}

	public JsonTest(String firstName, String lastName, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}
	
	public static void main(String[] args) {
		JsonTest test = new JsonTest("Vijay","Simha","Hyderabad");
		System.out.println(test.toString());
		Gson son = new Gson();
		String json = son.toJson(test);
		System.out.println("Values are : "+json);
	}
}
