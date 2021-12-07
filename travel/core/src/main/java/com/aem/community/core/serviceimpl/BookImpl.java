package com.aem.community.core.serviceimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aem.community.core.dbutils.DatabaseConnectionHelper;
import com.aem.community.core.service.BookInt;

@Component(service=BookImpl.class,immediate=true)
public class BookImpl implements BookInt {

	@Reference
	DatabaseConnectionHelper base;

	private static final Logger log = LoggerFactory.getLogger(BookImpl.class);

	int status = 0;
	Connection conn = null;

	@Override
	public int bookDetails(String book, int price, int year) {
		try {
			conn = base.getDataBaseConnection("data");
			log.info("Connection Established Successfully: "+conn);
			PreparedStatement statement = conn.prepareStatement("insert into book(book, price, year) values(?,?,?)");
			statement.setString(1, book);
			statement.setInt(2, price);
			statement.setInt(3, year);
			status = statement.executeUpdate();
			log.info("Values Are Inserted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		log.info("Crud Operation Is Completed");
		return status;
	}

}
