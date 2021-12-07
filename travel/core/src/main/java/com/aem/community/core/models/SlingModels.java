package com.aem.community.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;

@Model(adaptables = Resource.class)
public class SlingModels {

	@ChildResource(name="content")
	Resource child;
	
	public String getChildPath() {
		return child.getPath();
	}
}
