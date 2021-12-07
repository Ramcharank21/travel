package com.aem.community.core.serviceimpl;

import org.osgi.service.component.annotations.Component;
import com.aem.community.core.bean.Company;
import com.aem.community.core.service.CompanyInt;
import com.google.gson.Gson;

@Component(service = CompanyInt.class)
public class CompanyImpl implements CompanyInt {
	String json;

	@Override
	public String getJsonData() {
		try {
			Company comp = new Company();
			comp.setCompanyName("Nike");
			comp.setCompanyTagline("Just Do It!");
			comp.setEmployees(1000);
			
			json = new Gson().toJson(comp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}
	
	

}
