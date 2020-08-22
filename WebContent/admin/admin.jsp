<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    errorPage="../error/404error.jsp"
    %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${sessionScope.username == null}">
		<c:redirect url="../adminLogin.jsp"/>
	</c:if>
	<a href="admin/blogadd.jsp">Add Blog</a>
	<a href="../admincontroller">logout</a>
</body>
</html>