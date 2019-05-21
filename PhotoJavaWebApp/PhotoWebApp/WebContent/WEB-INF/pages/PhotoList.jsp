<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photo List</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Photo List</h1>
		<jsp:include page="NavBar.jsp"></jsp:include>
		<div class="row">
			<c:forEach items="${requestScope.photoList}" var="photo">
				<div class="col-md-4">
					<div class="thumbnail" style="margin-top: 15px">
						<div>
							<img
								src="${pageContext.request.contextPath}/displayimage?id=${photo.photoId}"
								style="width: 100%" />
						</div>
						<div class="caption">
							<h3>${photo.title}</h3>
							<p>Created by: ${photo.userName}</p>
							<p>Created on: ${photo.createDate}</p>
							<p>
								<a
									href="${pageContext.request.contextPath}/photodetails?photoid=${photo.photoId}"
									class="btn btn-default">Details</a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/scripts/jquery-1.10.2.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/bootstrap.js"></script>
	<script src="${pageContext.request.contextPath}/scripts/respond.js"></script>
</body>
</html>