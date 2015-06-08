<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<table width=780 border="0" height=240 cellspacing="0" cellpadding="0"
		class="bg1" align="center">
		<tr valign="top">
			<td class="text8">User &nbsp;&nbsp; <%=request.getSession().getAttribute("name") %>
				registered successfully !!!!<br>
			</td>
		</tr>

		<tr>
			<td>Store your login id's and password for your various account
				on the web e.g. github, twilio, dropbox and twitter.</td>
		</tr>
		</br>
		<tr>
			<td><a href="UserConfiguration.jsp">Start Registering</a></td>
		</tr>
	</table>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>