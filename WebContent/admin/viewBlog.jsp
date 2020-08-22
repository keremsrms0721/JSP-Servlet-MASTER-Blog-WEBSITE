<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="../error/404error.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.username == null}">
		<c:redirect url="../adminLogin.jsp"/>
	</c:if>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Title</th>
			<th>Settings</th>
		</tr>

		<c:forEach var="blog" items="${blogList}">
			<tr>
				<td><c:out value="${blog.id}" /></td>
				<td><c:out value="${blog.title}" /></td>
				<td><a href="addblog?id=${blog.id}"> <span
						class="glyphicon glyphicon-remove"></span>
				</a>
				<a href="updateblog?id=${blog.id}">
		          <span class="glyphicon glyphicon-cog"></span>
		        </a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
		<nav class="blog-nav nav nav-justified my-5">
					<c:forEach begin="1" end="${totalPages}" step="1" var="i">
					<a
					href="addblog?page=${i}"
					>${i}</a>
					</c:forEach>
			</nav>
	
	<a href="blogadd.jsp">Add Blog</a>
	<a href="../admincontroller">logout</a>
	

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>