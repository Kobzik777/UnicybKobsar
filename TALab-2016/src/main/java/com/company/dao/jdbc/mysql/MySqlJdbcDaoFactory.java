package com.company.dao.jdbc.mysql;


import com.company.dao.AuthorsDao;
import com.company.dao.DaoFactory;
import com.company.dao.BooksDao;
import com.company.dao.GenresDao;
import com.company.dao.GenericDao;
import com.company.enitites.Books;
import com.mysql.cj.jdbc.Driver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MySqlJdbcDaoFactory extends DaoFactory {
	
	private static final String DB_CONFIG_FILE_NAME = "/db.properties";
	private static final String DB_USER = "db.user";
	private static final String DB_PASS = "db.pass";
	private static final String DB_URL = "db.url";
	
	private static Connection connection ;

	static Connection getConnection(){
		try {
			if( connection == null ){
				InputStream in = MySqlJdbcDaoFactory
				.class.getResourceAsStream(DB_CONFIG_FILE_NAME);
				Properties props = new Properties();
				props.load(in);
				new Driver();
				connection =  DriverManager
						.getConnection( props.getProperty(DB_URL) , 
    					        props.getProperty(DB_USER),
    					        props.getProperty(DB_PASS));
			}
			//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "6940");
			return connection;
		}catch(Exception ex){
			// add logging
			throw new RuntimeException( ex );
		}

	}
	
	@Override
	public BooksDao createBooksDao() {
		
		return new MySqlBooksDao();
	}

	@Override
	public AuthorsDao createAuthorsDao() {
		return new MySqlAuthorsDao();
	}
	@Override
	public GenresDao createGenresDao() {

		return new MySqlGenresDao();
	}



}
