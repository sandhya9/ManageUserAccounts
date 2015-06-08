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
	<form name="registration" method="get" action="NewUserRegistration.do">
		<jsp:include page="Header.jsp"></jsp:include>

		<table>
			<tr>
				<td class="link2">LOGIN</td>
			</tr>
		</table>

		<table>

			<tr>
				<td class="text7" align="right">UserName:</td>
				<td align="left"><input type=text name=uname /></td>
			</tr>
			<tr>
				<td class="text7" align="right">SSN Last four digits:</td>
				<td align="left"><input type=text name=ssn /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Password:</td>
				<td align="left"><input type=password name=pword /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type=submit value="Login" class="link3" />

				</td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>