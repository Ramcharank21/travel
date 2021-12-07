package com.aem.community.core.service;

import java.util.List;
import java.util.Map;

public interface HTLSightly {

	public String[] getBooksArray();
	public List<String> getBooks();
	public Map<String, String> getBooksMap();
	public List<Map<String, String>> getBookDetailsWithMap();
}
