<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spaghetti</title>
</head>
<body>
	<h1>Spaghetti</h1>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/gb_practice" user="root"
		password="root" />

	<sql:query dataSource="${snapshot}" var="result">
         SELECT * from test_native;
      </sql:query>
	<table border="1" width="100%">
		<tr>
			<th>ID</th>
			<th>Value1</th>
			<th>Value2</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}" /></td>
				<td><c:out value="${row.value1}" /></td>
				<td><c:out value="${row.value2}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>