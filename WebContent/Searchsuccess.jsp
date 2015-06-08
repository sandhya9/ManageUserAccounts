<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.ibm.cloudoe.samples.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
	<% ArrayList<SearchBean> a = (ArrayList<SearchBean>)request.getAttribute("courses");  %>
	<div align="center">
	
	<table>
	<tr>
	<td>
	Search Details are as follows
	</td>
	</tr>
	</table>
		<table border="1">
			<tr>
			<th> Account Names </th>
				<th>Username</th>
				<th>Password</th>
			</tr>
			<%for(SearchBean i:a)
{%>
			<tr>
			<td> Github Credentials </td>
				<td><%=i.getGithubname() %></td>
				<td><%=i.getGpass() %></td>
			</tr>
			
			<tr>
			<td> Twilio Credentials </td>
				<td><%=i.getTwiname() %></td>
				<td><%=i.getTwipass() %></td>
			</tr>
			<tr>
			<td> Twitter Credentials </td>
				<td><%=i.getTttname() %></td>
				<td><%=i.getTttpass() %></td>
			</tr>
			<tr>
			<td> Dropbox Credentials </td>
				<td><%=i.getDbname() %></td>
				<td><%=i.getDbpass() %></td>
			</tr>
			<% }%>
			
		</table>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>