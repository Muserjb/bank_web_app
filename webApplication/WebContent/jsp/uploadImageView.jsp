<%@page import="javawebapplication.utilility.ServletUtility"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-8">
			<h2>Image</h2>
			<img alt="" src="../image/3.jpg" >
			</div>
		</div>

		<h3 class="text-success text-center"><%=ServletUtility.getSuccessMessage(request)%>
		</h3>

		<h2>Image Uploading example in JSP and Servlet</h2>
		<form action="<%=JWAView.UploadImageCTL%>"
			enctype="multipart/form-data" method="post">
			<input type="file" id="myFile" name="photo" multiple> <input
				type="submit">
		</form>


	</div>
	<br>
	<br>
</body>
<%@ include file="footer.jsp"%>
</html>