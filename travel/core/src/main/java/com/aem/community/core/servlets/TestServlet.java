package com.aem.community.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import com.aem.community.core.models.TestB;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Test Demo Servlet",
		"sling.servlet.methods =" + HttpConstants.METHOD_GET, "sling.servlet.paths =" + "/bin/proof" })

public class TestServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;
	
	@OSGiService
	TestB b; 
	
	public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String bb = b.name();
		response.getWriter().write("Test Servlet Called"+bb);		
	}
}
