package com.aem.community.core.serviceimpl;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.installer.api.info.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.AuthorGeeksInt;
import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;

@Model(adaptables = SlingHttpServletRequest.class, 
			adapters = AuthorGeeksInt.class,
			defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AuthorGeeksImpl implements AuthorGeeksInt{
	private static Logger LOG = LoggerFactory.getLogger(AuthorGeeksImpl.class);
	
	@SlingObject
	ResourceResolver resourceResolver;
	
	@Self
	SlingHttpServletRequest slingHttpServletRequest;
	
	@RequestAttribute(name = "rAttribute")
	private String reqAttribute;
	
	@ResourcePath(path="/content/travel/us/en/home")@Via("resource")
	Resource resource;
	
	@OSGiService
	QueryBuilder queryBuilder;
	
	@Inject
	@Via("resource")
	@Default(values = "AEM")
	String fname;
	
	@ValueMapValue
	@Default(values = "GEEKS")
	String lname;
	
	@Inject
	@Via("resource")
	boolean professor;
	
	@ScriptVariable
	Page currentPage;
	
	@Override
	public String getFirstName() {
		return fname;
	}

	@Override
	public String getLastName() {
		return lname;
	}

	@Override
	public boolean getIsProfessor() {
		return professor;
	}

	@Override
	public String getPageTitle() {
		return currentPage.getTitle();
	}

	@Override
	public String getRequestAttribute() {
		return reqAttribute;
	}

	@Override
	public String getHomePageName() {
		return  ((Page) resource).getName();
	}
	
	@PostConstruct
	protected void init() {
		LOG.info("/n Inside init {} : {}",currentPage.getTitle(), ((Page) resource).getPath());
	}
}
