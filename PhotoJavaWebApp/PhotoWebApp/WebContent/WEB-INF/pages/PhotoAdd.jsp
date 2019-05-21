<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Photo</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Add Photo</h1>
		<jsp:include page="NavBar.jsp"></jsp:include>
		<div class="row">
			<div class="col-md-6">
				<form action="${pageContext.request.contextPath}/photoadd"
					method="post" enctype="multipart/form-data">
					<div class="text-danger">${ requestScope.addModel.errMsg }</div>
					<div class="form-group">
						<label for="title">Title</label> <input type="text"
							class="form-control" id="title" name="title"
							value="${ requestScope.addModel.title }" />
					</div>
					<div class="form-group">
						<label for="description">Description</label> <input type="text"
							class="form-control" id="description" name="description"
							value="${ requestScope.addModel.description }" />
					</div>
					<div class="form-group">
						<label for="fileData">Select an image file</label> <input
							type="file" id="fileData" name="fileData" />
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