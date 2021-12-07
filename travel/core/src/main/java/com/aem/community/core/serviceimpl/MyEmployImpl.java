package com.aem.community.core.serviceimpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.MyEmploy;
import com.aem.community.core.service.MyStudent;

@Component(service=MyEmploy.class,immediate=true) //osgi service creation using R6/oij/Ds annotations.
public class MyEmployImpl implements MyEmploy{
	
	private static final Logger log = LoggerFactory.getLogger(MyEmployImpl.class);
	
	@Reference
	MyStudent student;
	
	@Override
	public void getEmployDetails() {
		// TODO Auto-generated method stub
		
		log.info("getEmployDetails()---started");
		try {
			student.addStudentDetails();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
		}
		
		log.info("getEmployDetails()---end");
		
	}
}
