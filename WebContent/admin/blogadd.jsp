<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="../error/404error.jsp"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
	
	 <style>
body {
  background-image: url('images/as.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: 100% 100%;
}
</style>
     <script src="../ckeditor/ckeditor.js"></script>
     
</head>
<body>
<c:if test="${sessionScope.username == null}">
		<c:redirect url="../adminLogin.jsp"/>
	</c:if>
<form action="addblog" method="post">
	<table>
		<tr>
		<td>
		<div class="form-group">
			<label for="formGroupExampleInput">Title</label> <input
				type="text" class="form-control" id="formGroupExampleInput" name="title">
		</div></td></tr>
		<tr>
			<td>
			<label>Content</label>
				<textarea rows="40" cols="150" id="editor1" name="editor1"></textarea>
				<script>
                // Replace the <textarea id="editor1"> with a CKEditor 4
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
          	  </script>
			</td>
		</tr>
		<tr>
			<td>
				<br>
				<button type="submit" class="btn btn-primary">Add Blog</button>
			</td>
		</tr>
	</table>
	</form>
	<br>
	<a href="addblog">View Blogs</a>
	
	<br>
<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>