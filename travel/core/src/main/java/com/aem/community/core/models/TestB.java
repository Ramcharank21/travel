package com.aem.community.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables = Resource.class)
public class TestB {
	
	@OSGiService
	TestA a;	
	
	private static final Logger Log = LoggerFactory.getLogger(TestB.class);
	public String name() {
	String aa = a.getName();	
	Log.info("Name : "+aa);
	return aa;
	}
}
