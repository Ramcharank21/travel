package com.aem.community.core.serviceimpl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.EmployeesNodeService;

@Component(service = EmployeesNodeService.class, immediate = true)
public class EmployeeNodeServiceImpl implements EmployeesNodeService {

	private static Logger log = LoggerFactory.getLogger(EmployeeNodeServiceImpl.class);

	@Reference
	private ResourceResolverFactory resolverFactory;

	ResourceResolver resourceResolver = null;
	private Session session;
	Resource resource;
	String resourcePath = "/content/travel/en/jcr:content/employees";

	@Override
	public boolean registerEmployDetails(String firstName, String lastName, String userName, String password) {
		boolean flag = false;
		try {

			resourceResolver = resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session = resourceResolver.adaptTo(Session.class);
			log.info("session ****" + session);
			resource = resourceResolver.getResource(resourcePath);

			// create random numbers

			java.util.Random r = new java.util.Random();

			int low = 10;
			int high = 1000;
			int result = r.nextInt(high - low) + low;

			String numberValues = "employee" + result;

			Node node = resource.adaptTo(Node.class);

			if (node != null) {

				Node empRoot = node.addNode(numberValues, "nt:unstructured");
				empRoot.setProperty("FirstName", firstName);
				empRoot.setProperty("LastName", lastName);
				empRoot.setProperty("UserName", userName);
				empRoot.setProperty("Password", password);
				session.save();
				flag = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.logout();
			}
		}
		return flag;
	}

	@Override
	public boolean loginEmployee(String user, String pass) {

		boolean flag = false;
		Session session = null;
		Resource resource;
		String resourcePath = "/content/travel/en/jcr:content/employees";

		try {

			resourceResolver = resolverFactory.getServiceResourceResolver(getSubServiceMap());
			session = resourceResolver.adaptTo(Session.class);
			log.info("session ****" + session);
			resource = resourceResolver.getResource(resourcePath);
			Node node = resource.adaptTo(Node.class);

			NodeIterator nodeItr = node.getNodes();

			while (nodeItr.hasNext()) {

				Node cNode = nodeItr.nextNode();

				String userName = cNode.getProperty("UserName").getValue().getString();
				String pwd = cNode.getProperty("Password").getValue().getString();

				Map<String, String> map = new HashMap<String, String>();

				map.put("UserName", userName);
				map.put("Password", pwd);
				log.info("Mapping....." + map);

				if (map.containsValue(user) && map.containsValue(pass)) {
					log.info("Inside if condition..");
					flag = true;
					break;
				} else {
					log.info("Inside else condition");
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private Map<String, Object> getSubServiceMap() {
		log.info("*****Inside getSubservice method **");
		Map<String, Object> serviceMap = null;

		try {

			serviceMap = new HashMap<String, Object>();
			serviceMap.put(ResourceResolverFactory.SUBSERVICE, "aemjuly");

		} catch (Exception e) {
			e.printStackTrace();
			StringWriter errors = new StringWriter();
			e.printStackTrace(new PrintWriter(errors));
			log.info("errorr ***" + errors.toString());
		}
		log.info("*****getSubservice Method End**");
		return serviceMap;
	}
}
