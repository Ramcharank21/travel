package com.aem.community.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class UserModel {

	@Inject 
	private String firstName;
	
	@Inject
	private String lastName;
	
	@Inject
	private String gender;
	
	@Inject
	private String country;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}
	
}
