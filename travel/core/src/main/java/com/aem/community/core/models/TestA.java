package com.aem.community.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class)
public class TestA {
	
	public String getName() {
		return "Vijay";
	}
}
