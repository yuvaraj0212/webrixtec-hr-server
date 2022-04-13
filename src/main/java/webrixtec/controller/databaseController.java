package webrixtec.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import webrixtec.service.databaseService;

@RestController
public class databaseController {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	databaseService dbservice;

	@PostMapping(value = "/db-connection")
	public Connection getConnection() throws SQLException {
		try {
			// Registering the Driver
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			// Getting the connection
			Connection con = DriverManager.getConnection(url, username, password);
			System.out.println("Connection established......");
			// Creating the Statement
			Statement stmt = con.createStatement();
			String phone = "phone";
			// Query to alter the table
			String query = "ALTER TABLE tbl_resume_model ADD " + phone + " varchar(40) DEFAULT '' NOT NULL";
			// Executing the query
			stmt.executeUpdate(query);
			System.out.println("Column added......");

		} catch (Exception e) {
			System.err.println(e);
		}

		return null;

	}

}
