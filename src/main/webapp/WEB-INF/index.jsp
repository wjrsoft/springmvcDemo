<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size: 30px;">
	Login success
	<br /> adminCode: ${adminCode }
	<br /> adminCode:  request.getAttribute("adminCode");
	<br /> adminCode: ${data }
		<%
				String adminCode = (String) request.getAttribute("adminCode");
			%>
			<td><%=adminCode%></td>
</body>
</html>
