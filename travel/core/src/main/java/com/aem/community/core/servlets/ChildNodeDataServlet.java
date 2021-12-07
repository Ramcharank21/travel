package com.aem.community.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Child Node Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/childnodedata" })
public class ChildNodeDataServlet extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ChildNodeDataServlet.class);

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain");
		response.getWriter().write("Child Node Data Servlet is Called-----");
		String nodePath = "/content/travel/en/par";
		try {
			Resource resource = request.getResourceResolver().getResource(nodePath);
			Node node = resource.adaptTo(Node.class);
			NodeIterator parChildNodes = node.getNodes();
			while (parChildNodes.hasNext()) {
				Node tabbedCarouselItemNode = parChildNodes.nextNode();
				log.info("tabbedCarouselItemNode-----" + tabbedCarouselItemNode);
				NodeIterator tabbedCarouselItemChildNodes = tabbedCarouselItemNode.getNodes();
				while (tabbedCarouselItemChildNodes.hasNext()) {
					Node tabImgNode = tabbedCarouselItemChildNodes.nextNode();
					log.info("tabImgNode-----"+tabImgNode);
					if (!tabImgNode.hasProperty("firstName")) {
		                continue;
		            }
					log.info("First Name: " + tabImgNode.getProperties("firstName").toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
