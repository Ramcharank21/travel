package com.aem.community.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import com.aem.community.core.service.JsonInt;

@Model(adaptables = Resource.class,
		   adapters = JsonInt.class,
		   resourceType = {"travel/components/content/jsontest"},
		   defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
		   )
@Exporter(name = "jackson", extensions = "json", options = {
		@ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true") })
public class JsonModel implements JsonInt {
	
	@Inject
	String firstName;
	
	@Inject
	String lastName;
	
	@Inject
	String city;
	
	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getCity() {
		return city;
	}

}
