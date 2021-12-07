package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.resourceTypes="+ "travel/components/structure/page",
                   "sling.servlet.selectors=" + "tests"
           })
public class SimpleServlet extends SlingSafeMethodsServlet {        

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(SimpleServlet.class);
    
    @Override
    protected void doGet(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
    	
    	log.info("doGet method called---simpleservlet");
    	
        resp.setContentType("text/plain");
        
        log.info("doGet method called---end");
        resp.getWriter().write("Simple Servlet Resource----Using Resource Type");
        log.info("doGet method called---ends");
    }
}
