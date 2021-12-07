package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.CompanyInt;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Json Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/getjson" })
public class CompanyServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(CompanyServlet.class);
	
	@Reference
	CompanyInt impl;
	
	@Override
	protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String json = impl.getJsonData();
			log.info("Company Details"+json);
			resp.setContentType("text/plain");
			resp.getWriter().write("Company Details : "+json);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
