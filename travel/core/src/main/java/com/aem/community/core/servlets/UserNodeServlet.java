package com.aem.community.core.servlets;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.EmployeesNodeService;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Employees Node Login Servlet",
		"sling.servlet.methods =" + HttpConstants.METHOD_POST, "sling.servlet.paths =" + "/bin/usernode" })

public class UserNodeServlet extends SlingAllMethodsServlet {

	Logger log = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;
	ResourceResolver resourceResolver;

	@Reference
	EmployeesNodeService nodeService;

	public void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try {
			String UserName = request.getParameter("user");
			String Password = request.getParameter("pass");
			log.info("UserName is *********===*****  " + UserName + " +++Password is *********===*****  " + Password);
			nodeService.loginEmployee(UserName, Password);			
		}
		catch (Exception e) {
			log.error(e.getMessage());
		}
		response.getWriter().close();
	}
}
