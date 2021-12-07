package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.EmployeesNodeService;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Employees Node Demo Servlet",
		"sling.servlet.methods =" + HttpConstants.METHOD_POST, "sling.servlet.paths =" + "/bin/register" })
public class EmployeesServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	@Reference
	EmployeesNodeService nodeService;

	private static final Logger log = LoggerFactory.getLogger(EmployeesServlet.class);

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().write("EmployeesServlet is Called.....");

		String FirstName = request.getParameter("firstName");
		String LastName = request.getParameter("lastName");
		String UserName = request.getParameter("userName");
		String Password = request.getParameter("password");
		nodeService.registerEmployDetails(FirstName, LastName, UserName, Password);
		
		log.info("registerEmployDetails() is called successfully.....");
	}
}
