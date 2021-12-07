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

import com.aem.community.core.dbutils.DatabaseConnectionHelper;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/data" })

public class DataBaseServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;

	@Reference
	DatabaseConnectionHelper obj;
	
	private static final Logger log = LoggerFactory.getLogger(DataBaseServlet.class);

	@Override
	protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp)
			throws ServletException, IOException {

		try {
			obj.getDataBaseConnection("data");
			
			resp.setContentType("text/plain");
			resp.getWriter().write("JDBC connection is successful");

			log.info("DataSource()---called");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
