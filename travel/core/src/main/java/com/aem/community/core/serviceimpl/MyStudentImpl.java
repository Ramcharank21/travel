package com.aem.community.core.serviceimpl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.MyStudent;

@Component(service=MyStudent.class,immediate=true)

public class MyStudentImpl implements MyStudent{

	private static final Logger log = LoggerFactory.getLogger(MyStudentImpl.class);
	@Override
	public void addStudentDetails() {
		// TODO Auto-generated method stub
		
		log.info("addStudentDatails() called");
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
		}
		log.info("addStudentDatails method called");
	}

}
