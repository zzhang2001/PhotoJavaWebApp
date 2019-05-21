<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<div class="row">
			<div class="col-md-12">
				<div class="pull-left">
					<a href="${pageContext.request.contextPath}/">Home</a>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<form action="${pageContext.request.contextPath}/login"
					method="post">
						<div class="text-danger">${ requestScope.loginModel.errMsg }</div>
					<div class="form-group">
						<label for="username">User name</label> <input type="text"
							class="form-control" id="username" name="username"
							value="${ requestScope.loginModel.username }" />
					</div>
					<div class="form-group">
						<label for="password">Password</label> <input type="password"
							class="form-control" id="password" name="password"
							value="${ requestScope.loginModel.password }" />
					</div>
					<div class="form-group">
						<input type="submit" class="btn btn-default" value="Submit" />
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/respond.js"></script>
</body>
</html>
