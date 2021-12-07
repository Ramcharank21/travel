package com.aem.community.core.serviceimpl;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.service.ReadJsonService;
import static com.aem.community.core.serviceimpl.AppConstants.URL;

@Component(immediate = true, service = ReadJsonService.class)
public class ReadJsonDataImpl implements ReadJsonService {

	private static Logger LOG = LoggerFactory.getLogger(ReadJsonDataImpl.class);
	@Override
	public String getData() {
		
		String response = Network.readJson(URL);
		LOG.info("Json response from Jsonplace holder server"+response);
		return response;
	}

}
