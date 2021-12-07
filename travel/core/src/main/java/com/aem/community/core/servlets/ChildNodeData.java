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

@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Login Demo Servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/bin/childnode" })
public class ChildNodeData extends SlingSafeMethodsServlet {

	private static final long serialVersionUID = 1L;

	private static final Logger log = LoggerFactory.getLogger(ChildNodeData.class);

	@Override
	protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response)
			throws ServletException, IOException {

		String nodePath = "/content/we-retail/language-masters";
		try {
			Node node = null;
			log.info("Node------" + node);
			NodeIterator nodes = null;
			log.info("Nodes-----" + nodes);
			String result = "";

			Resource resource = request.getResourceResolver().getResource(nodePath);
			log.info("Resource-----" + resource);
			if (resource != null) {
				node = resource.adaptTo(Node.class);
				NodeIterator nodeItr = node.getNodes();

				while (nodeItr.hasNext()) {

					Node cNode = nodeItr.nextNode();
					result = cNode.getProperty("jcr:primaryType").getValue().getString();
					log.info("Result-----" + result);
				}
			}
			response.setContentType("text/plain");
			response.getWriter().write("ChildNode Servlet is Called-----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
