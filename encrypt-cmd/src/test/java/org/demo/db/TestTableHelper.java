package org.demo.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestTableHelper {

	private PreparedStatement stmt = null;
	private Connection conn = null;
	private ResultSet rs = null;
	/**
	 * initial connections
	 */
	@Before
	public void setUp() {
		// one-time initialization code
		// System.out.println("@BeforeClass - oneTimeSetUp");
		Properties properties = new Properties();
        try {
			properties.load(TestTableHelper.class.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String dbDriver=properties.getProperty("db_driver");
        String dbUrl=properties.getProperty("db_url");
        String dbUser=properties.getProperty("db_user");
        String dbPassword=properties.getProperty("db_password");
        
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@After
	public void teardown() {
		if (conn != null) {
	        try {
	            conn.close();
	        } catch (SQLException sqlEx) { } // ignore

	        conn = null;
	    }
//
//	    if (stmt != null) {
//	        try {
//	            stmt.close();
//	        } catch (SQLException sqlEx) { } // ignore
//
//	        stmt = null;
//	    }
	}
	
	@Test
	public void runSQL(){
		try {
			//"id", "username", "password", "backup_password" password
		    stmt = conn.prepareStatement("SELECT id,backup_password,username FROM user order by id");
		    rs = stmt.executeQuery();

		    while (rs.next()) {
		    	String[] aString = new String[3];
                aString[0] = rs.getString(1);
                aString[1] = rs.getString(2);                
                aString[2] = rs.getString(3);					
                //aString[3] = rs.getString(4);
                
                System.out.println(StringUtils.join(aString, ","));
		    }
		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...

//		    if (stmt.execute("SELECT foo FROM bar")) {
//		        rs = stmt.getResultSet();
//		    }

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}
}
