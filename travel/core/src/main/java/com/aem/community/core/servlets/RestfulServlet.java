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

import com.aem.community.core.service.ReadJsonService;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Restful Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_GET,
                   "sling.servlet.paths="+ "/bin/restful"
           })
public class RestfulServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
    
    private static final Logger log = LoggerFactory.getLogger(RestfulServlet.class);
    
    @Reference
    ReadJsonService readJson;
    
    @Override
    protected void doGet(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {

    	String result = readJson.getData();
    	log.info("Json object from jsonplace holder server "+result);
    	
        response.setContentType("text/plain");  
        response.getWriter().write("Restful Servlet is Called-----");
        
    }
}
