<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registering accounts</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<form name="acctregistration" method="get"
		action="AccountRegistration.do">

		String username =
		<%= request.getSession().getAttribute("name") %>

		<table width="780" border="0" height="150" cellspacing="0"
			cellpadding="0" align="center" class="bg1">
			<tr>
				<td>username:</td>
				<td align="left"><input type="hidden" name=uname1
					value="<%= request.getSession().getAttribute("name") %>" /></td>
			<tr>
				<td class="text7" align="right">Github Userid:</td>
				<td align="left"><input type=text name=acc1 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Github Password:</td>
				<td align="left"><input type=password name=pass1 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Twilio Userid:</td>
				<td align="left"><input type=text name=acc2 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Twilio Password:</td>
				<td align="left"><input type=password name=pass2 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Twitter Userid:</td>
				<td align="left"><input type=text name=acc3 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Twitter Password:</td>
				<td align="left"><input type=password name=pass3 /></td>
			</tr>

			<tr>
				<td class="text7" align="right">Dropbox Userid:</td>
				<td align="left"><input type=text name=acc4 /></td>
			</tr>
			<tr>
				<td class="text7" align="right">Dropbox Password:</td>
				<td align="left"><input type=password name=pass4 /></td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type=submit value="submit" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>