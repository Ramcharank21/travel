package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Login Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                   "sling.servlet.paths="+ "/bin/enter"
           })
public class LoginServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
    
    private static final Logger log = LoggerFactory.getLogger(LoginServlet.class);
    
    @Override
    protected void doPost(final SlingHttpServletRequest request,
            final SlingHttpServletResponse response) throws ServletException, IOException {

    	String name = request.getParameter("name");
    	String pass = request.getParameter("pass");
    	log.info("UserName: "+name+"  Password: "+pass);
    	
        response.setContentType("text/plain");  
        response.getWriter().write("Login Servlet is Called-----"+name+"   "+pass);
        
    }
}
