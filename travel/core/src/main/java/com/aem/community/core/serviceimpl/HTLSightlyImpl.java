package com.aem.community.core.serviceimpl;

import com.aem.community.core.service.HTLSightly;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.*;

@Model(adaptables = SlingHttpServletRequest.class, adapters = HTLSightly.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HTLSightlyImpl implements HTLSightly {
	private static final Logger LOG = LoggerFactory.getLogger(HTLSightlyImpl.class);

	@Inject
	Resource resource;

	@ValueMapValue
	private List<String> books;

	@Override
	public String[] getBooksArray() {
		String[] booksArray = { "JAVA", "AEM", "OS", "NETWORK" };
		return booksArray;
	}

	@Override
	public List<String> getBooks() {
		if (books != null) {
			return new ArrayList<String>(books);
		} else {
			return Collections.emptyList();
		}
	}
	
	@Override
	public List<Map<String, String>> getBookDetailsWithMap() {
		List<Map<String, String>> bookDetailsMap = new ArrayList<>();
		try {
			Resource bookDetail = resource.getChild("bookdetailswithmap");
			if (bookDetail != null) {
				for (Resource book : bookDetail.getChildren()) {
					Map<String, String> bookMap = new HashMap<>();
					bookMap.put("bookname", book.getValueMap().get("bookname", String.class));
					bookMap.put("booksubject", book.getValueMap().get("booksubject", String.class));
					bookDetailsMap.add(bookMap);
				}
			}
		} catch (Exception e) {
			LOG.info("ERROR while getting Book Details {}", e.getMessage());
		}
		return bookDetailsMap;
	}
	
	@Override
	public Map<String, String> getBooksMap() {
		Map<String, String> mapBooks = new HashMap<>();
		mapBooks.put("attribute1", "Value1");
		mapBooks.put("attribute2", "Value2");
		mapBooks.put("attribute3", "Value3");
		mapBooks.put("attribute4", "Value4");
		mapBooks.put("attribute5", "Value5");
		mapBooks.put("attribute6", "Value6");
		mapBooks.put("attribute7", "Value7");
		return mapBooks;
	}
}