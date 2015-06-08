<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet" type="text/css" />
</head>

<script language="javascript" type="text/JavaScript">

function checkForm(form)
{
	b=true
	if(   form.unamesearch.value=='' )
    {
	alert('User Name should be entered')
	b=false
	form.pname.focus()
	return b
}
}
</script>
<body>

	<jsp:include page="Header.jsp"></jsp:include>
	<form method=get action="DetailsSearch.do"
		onSubmit="return checkForm(this)">
		<table width=780 border="0" height=240 cellspacing="0" cellpadding="0"
			class="bg1" align="center">
			<tr valign="top">
				<td class="text8">Details Registered Successfully !!!!<br>
				<br>
				<br>
				<br>
				</td>
			</tr>
			<tr>
				<td>Enter the Username to get the details</td>
				<td>
				<td align="left"><input type=text name=unamesearch /></td>
				</td>
			</tr>
			<tr>
				<td></td>
				<td align="left"><input type=submit value="Search"
					class="link3" /></td>
			</tr>
		</table>
	</form>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>