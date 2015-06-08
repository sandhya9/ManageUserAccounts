package com.ibm.cloudoe.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ibm.db2.jcc.DB2SimpleDataSource;
import com.ibm.nosql.json.api.BasicDBList;
import com.ibm.nosql.json.api.BasicDBObject;
import com.ibm.nosql.json.util.JSON;

/**
 * Servlet implementation class NewUserRegistration
 */
@WebServlet("/DetailsSearch.do")
public class DetailsSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// set defaults
	private String databaseHost = "localhost";
	private int port = 50000;
	private String databaseName = "mydb";
	private String user = "myuser";
	private String password = "mypass";
	private String url = "myurl";
    public DetailsSearch() {
        // TODO Auto-generated constructor stub
    }

    
    private boolean processVCAP(PrintWriter writer) {
		// VCAP_SERVICES is a system environment variable
		// Parse it to obtain the for DB2 connection info
		String VCAP_SERVICES = System.getenv("VCAP_SERVICES");
		System.out.println("VCAP_SERVICES content: " + VCAP_SERVICES);

		if (VCAP_SERVICES != null) {
			System.out.println("inside VCAP SERVCIES");
			// parse the VCAP JSON structure
			BasicDBObject obj = (BasicDBObject) JSON.parse(VCAP_SERVICES);
			System.out.println("inside VCAP SERVCIES1");
			String thekey = null;
			Set<String> keys = obj.keySet();
			System.out.println("Searching through VCAP keys");
			// Look for the VCAP key that holds the SQLDB information
			for (String eachkey : keys) {
				System.out.println("Key is: " + eachkey);
				// Just in case the service name gets changed to lower case in the future, use toUpperCase
				if (eachkey.toUpperCase().contains("SQLDB")) {
					thekey = eachkey;
				}
			}
			if (thekey == null) {
				writer.println("Cannot find any SQLDB service in the VCAP; exiting");
				return false;
			}
			BasicDBList list = (BasicDBList) obj.get(thekey);
			obj = (BasicDBObject) list.get("0");
			writer.println("Service found: " + obj.get("name"));
			// parse all the credentials from the vcap env variable
			obj = (BasicDBObject) obj.get("credentials");
			databaseHost = (String) obj.get("host");
			databaseName = (String) obj.get("db");
			port = (int)obj.get("port");
			user = (String) obj.get("username");
			password = (String) obj.get("password");
			url = (String) obj.get("jdbcurl");
		} else {
			writer.println("VCAP_SERVICES is null");
			return false;
		}
		System.out.println();
		System.out.println("database host: " + databaseHost);
		System.out.println("database port: " + port);
		System.out.println("database name: " + databaseName);
		System.out.println("username: " + user);
		System.out.println("password: " + password);
		System.out.println("url: " + url);
		return true;
	}
	
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		
		System.out.println("in do get in searchhhhhhhhhhhhhhhhhh");
		response.setContentType("text/plain");
		response.setStatus(200);
		PrintWriter writer = response.getWriter();
		System.out.println("IBM SQL Database, Java Demo Application using DB2 drivers");
		System.out.println("Servlet: " + this.getClass().getName());
		writer.println();
		System.out.println("Host IP:" + InetAddress.getLocalHost().getHostAddress());

		// process the VCAP env variable and set all the global connection parameters
		if (processVCAP(writer)) {
			System.out.println("inside VCAP SERVCIES33333333333");
			// Connect to the Database
			Connection con = null;
			try {
				System.out.println();
				System.out.println("Connecting to the database11111111111111111111");
				DB2SimpleDataSource dataSource = new DB2SimpleDataSource();
				dataSource.setServerName(databaseHost);
				dataSource.setPortNumber(port);
				dataSource.setDatabaseName(databaseName);
				dataSource.setUser(user);
				dataSource.setPassword (password);
				dataSource.setDriverType(4);
				con=dataSource.getConnection();
				writer.println();
				con.setAutoCommit(false);
			} catch (SQLException e) {
				System.out.println("Error connecting to database");
				writer.println("SQL Exception: " + e);
				return;
			} 
	
			// Try out some dynamic SQL Statements
			Statement stmt = null;
			String tableName = "";
			String sqlStatement = "";
			// It is recommend NOT to use the default schema since it is correlated
			// to the generated user ID
			String schemaName = "SQLDBAM";
			// create a unique table name to make sure we deal with our own table
			// If another version of this sample app binds to the same database, 
			// this gives us some level of isolation
			tableName = schemaName + "." + "ACCOUNTDETAILSAM";
	
		/*	try {
				stmt = con.createStatement();
				// Create the CREATE SCHEMA SQL statement and execute it
				sqlStatement = "CREATE SCHEMA " + schemaName;
				System.out.println("Executing: " + sqlStatement);
				stmt.executeUpdate(sqlStatement);
			} catch (SQLException e) {
				writer.println("Error creating schema: " + e);
			}
	
			// create a table
			try {
				stmt = con.createStatement();
				// Create the CREATE TABLE SQL statement and execute it
				sqlStatement = "CREATE TABLE " + tableName
						+ " (NAME VARCHAR(20) NOT NULL , SSN VARCHAR(20) NOT NULL , PASS VARCHAR(20), PRIMARY KEY (NAME))";
				writer.println("Executing: " + sqlStatement);
				stmt.executeUpdate(sqlStatement);
			} catch (SQLException e) {
				writer.println("Error creating table: " + e);
			}
	
			String name =request.getParameter("uname");
			String pwd =request.getParameter("pword");
			String ssn =request.getParameter("ssn");
			System.out.println(name+pwd);
			System.out.println("ssn--------->>>>"+ssn);
			HttpSession session = request.getSession();
			session.setAttribute("name", name); */
			String name =request.getParameter("unamesearch");
			System.out.println("search--------->>>>"+name);
			try{
				stmt = con.createStatement();
			sqlStatement = "SELECT * FROM " + tableName +" where NAME ='" +name+"'";
			System.out.println("Executing: " + sqlStatement);
			ResultSet rs = stmt.executeQuery(sqlStatement);
			
			
			System.out.println("result set details----"+rs);
			ArrayList<SearchBean> courses = new ArrayList<SearchBean>();
			while (rs.next()) {
				
				SearchBean searchDetails = new SearchBean();
								
				searchDetails.setGithubname(rs.getString("GITHUB"));
				searchDetails.setGpass(rs.getString("GITHUBPASS"));
				searchDetails.setTwiname(rs.getString("TWILIO"));
				searchDetails.setTwipass(rs.getString("TWILIOPASS"));
		          searchDetails.setTttname(rs.getString("TWITTER"));
		            searchDetails.setTttpass(rs.getString("TWITTERPASS"));
		            searchDetails.setDbname(rs.getString("DROPBOX"));
		             searchDetails.setDbpass(rs.getString("DROPBOXPASS"));
		             courses.add(searchDetails);
		             
		             request.setAttribute("courses", courses);
		             
		          /*  System.out.println("name1---"+githubname);
		            System.out.println("pass1---"+githubpass);
		            System.out.println("name2---"+twilioname);
		            System.out.println("pass2--"+twiliopass);
		            System.out.println("name3---"+twittername);
		            System.out.println("pass3---"+twitterpass);
		            System.out.println("name4---"+dropboxname);
		            System.out.println("pass4---"+dropboxpass);*/

		          //  request.setAttribute("githubname", githubname);
		         }
			// request.setAttribute("githubname", githubname);
			 RequestDispatcher rd= request.getRequestDispatcher("/Searchsuccess.jsp");
			
			rd.forward(request, response);
			rs.close();
			}
			 catch (SQLException e) {
					writer.println("Error executing:" + sqlStatement);
					writer.println("SQL Exception: " + e);
				}
			// Close the ResultSet
		
					
			
			
			// Close everything off
		/*	try {
				// Close the Statement
				stmt.close();
				// Connection must be on a unit-of-work boundary to allow close
				con.commit();
				// Close the connection
				con.close();
				writer.println("Finished");
	
			} catch (SQLException e) {
				writer.println("Error closing things off");
				writer.println("SQL Exception: " + e);
			}*/
		}
		writer.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
