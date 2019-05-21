<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photo Delete</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Photo Delete</h1>
		<jsp:include page="NavBar.jsp"></jsp:include>
		<h3>Are you sure to delete this photo and its comments?</h3>
		<div class="row">
			<div class="col-md-6">
				<div class="thumbnail">
					<div>
						<img
							src="${pageContext.request.contextPath}/displayimage?id=${photo.photoId}"
							style="width: 100%" />
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<h3>${photo.title}</h3>
				<p>Description: ${photo.description}</p>
				<p>Created by: ${photo.userName}</p>
				<p>Created on: ${photo.createDate}</p>
				<p>Modified on: ${photo.modifiedDate}</p>
				<c:if test="${sessionScope.username != null}">
					<form action="${pageContext.request.contextPath}/photodelete"
						method="post">
						<div class="form-group">
							<input type="hidden" name="photoId" value="${photo.photoId}" />
							<input type="submit" class="btn btn-primary" value="Delete" />
						</div>
					</form>
				</c:if>
			</div>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/respond.js"></script>
</body>
</html>
