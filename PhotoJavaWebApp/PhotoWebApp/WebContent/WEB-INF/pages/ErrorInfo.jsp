<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Error</h1>
		<div class="row">
			<div class="col-md-12">
				<div class="pull-left">
					<a href="${pageContext.request.contextPath}/">Home</a>
				</div>
			</div>
		</div>
		<h3>An error occurred. Here is the error details.</h3>
		<div class="row">
			<div class="col-md-12">
			<p>Request URI: ${requestScope.errorViewModel.requestUri}</p>
			<p>Status Code: ${requestScope.errorViewModel.statusCode}</p>
			<p>Servlet Name: ${requestScope.errorViewModel.servletName}</p>
			<p>Exception Name: ${requestScope.errorViewModel.exceptionName}</p>
			<p>Exception Message: ${requestScope.errorViewModel.exceptionMessage}</p>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/respond.js"></script>
</body>
</html>
