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

import com.aem.community.core.service.MyEmploy;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service=Servlet.class,
           property={
                   Constants.SERVICE_DESCRIPTION + "=Simple Demo Servlet",
                   "sling.servlet.methods=" + HttpConstants.METHOD_POST,
                   "sling.servlet.paths=" + "/bin/test"
           })
public class PathBaseServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PathBaseServlet.class);
    
    @Reference
    MyEmploy employ; //we are creating object of interface here 
    
    @Override
    protected void doPost(final SlingHttpServletRequest req,
            final SlingHttpServletResponse resp) throws ServletException, IOException {
    	
    	employ.getEmployDetails(); //we are calling impl method from  here 
    	
    	log.info("doPost method called---simpleservlet");      
        resp.setContentType("text/plain");
        log.info("doPost method called---end");
        resp.getWriter().write("Path Based Servlet----Using Path");
        log.info("doPost method called---ends");
    }
}
