<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Photo Details</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet" />
</head>
<body>
	<div class="container">
		<h1>Photo Details</h1>
		<jsp:include page="NavBar.jsp"></jsp:include>
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
					<p>
						<a
							href="${pageContext.request.contextPath}/photodelete?photoid=${photo.photoId}"
							class="btn btn-primary">Delete</a>
					</p>
				</c:if>
			</div>
		</div>

		<!-- Comments section -->
		<div class="panel panel-primary">
			<div class="panel-heading">
				<div class="panel-title">Comments</div>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="md-col-10">
						<span class="text-danger">${newCommentErrMsg}</span>
					</div>
				</div>
				<c:forEach items="${photo.comments}" var="comment">
					<div class="row">
						<div class="md-col-10">
							<div>${comment.commentBody}</div>
							<div>
								<i>By ${comment.userName} on ${comment.createDate}</i>
							</div>
							<c:if test="${sessionScope.username != null}">
								<form action="${pageContext.request.contextPath}/commentdelete"
									method="post">
									<div class="form-group">
										<input type="hidden" name="photoId" value="${photo.photoId}" />
										<input type="hidden" name="commentId"
											value="${comment.commentId}" /> <input type="submit"
											class="btn btn-primary" value="Delete Comment" />
									</div>
								</form>
							</c:if>
						</div>
					</div>
				</c:forEach>
				<c:if test="${sessionScope.username != null}">
					<div class="row">
						<div class="md-col-10">
							<form action="${pageContext.request.contextPath}/commentadd"
								method="post">
								<div class="form-group">
									<input type="hidden" name="photoId" value="${photo.photoId}" />
									<textarea class="form-control" rows="3" name="commentBody"></textarea>
								</div>
								<div class="form-group">
									<input type="submit" class="btn btn-primary"
										value="Add Comment" />
								</div>
							</form>
						</div>
					</div>
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
