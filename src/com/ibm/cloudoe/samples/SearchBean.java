package com.ibm.cloudoe.samples;

public class SearchBean {

	private String name;
	private String githubname;
	private String gpass;
	private String twiname;
	private String twipass;
	private String tttname;
	private String tttpass;
	private String dbname;
	private String dbpass;
	
	public SearchBean(String name,String githubname,String gpass,String twiname,String twipass,String tttname,String tttpass,String dbname,String dbpass) 
	{
		this.name = name;
		this.githubname = githubname;
		this.gpass =gpass;
		this.twiname=twiname;
		this.twipass =twipass;		
		this.tttname=tttname;
		this.tttpass=tttpass;
		this.dbname=dbname;
		this.dbpass=dbpass;
	}

	public SearchBean() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGithubname() {
		return githubname;
	}
	public void setGithubname(String githubname) {
		this.githubname = githubname;
	}
	public String getGpass() {
		return gpass;
	}
	public void setGpass(String gpass) {
		this.gpass = gpass;
	}
	public String getTwiname() {
		return twiname;
	}
	public void setTwiname(String twiname) {
		this.twiname = twiname;
	}
	public String getTwipass() {
		return twipass;
	}
	public void setTwipass(String twipass) {
		this.twipass = twipass;
	}
	public String getTttname() {
		return tttname;
	}
	public void setTttname(String tttname) {
		this.tttname = tttname;
	}
	public String getTttpass() {
		return tttpass;
	}
	public void setTttpass(String tttpass) {
		this.tttpass = tttpass;
	}
	public String getDbname() {
		return dbname;
	}
	public void setDbname(String dbname) {
		this.dbname = dbname;
	}
	public String getDbpass() {
		return dbpass;
	}
	public void setDbpass(String dbpass) {
		this.dbpass = dbpass;
	}
	
}
