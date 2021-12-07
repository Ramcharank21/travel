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

import com.aem.community.core.serviceimpl.BookImpl;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Inserting Values In Book Table",
		"sling.servlet.methods=" + HttpConstants.METHOD_POST, "sling.servlet.paths=" + "/bin/getter" })
public class BookServlet extends SlingAllMethodsServlet {
	
	private static final long serialVersionUID= 1L;

	@Reference
	BookImpl impl;
	private static final Logger log = LoggerFactory.getLogger(BookServlet.class);

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
	}
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try {
			response.setContentType("text/plain");
			response.getWriter().write("Book Servlet Is Called.........");
			
			String name = request.getParameter("book");
			int price = Integer.parseInt(request.getParameter("price"));
			int year = Integer.parseInt(request.getParameter("year"));
			
			impl.bookDetails(name, price, year);
			log.info("Book Name : " + name + "  Price : " + price + " Year : " + year);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
