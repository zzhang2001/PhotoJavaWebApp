<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Navigation bar begin -->
<div class="row">
	<div class="col-md-12">
		<c:if test="${ sessionScope.username != null }">
			<div class="pull-left">
				<a href="${pageContext.request.contextPath}/">Home</a> |
				<a href="${pageContext.request.contextPath}/photoadd">Add photo</a>
			</div>
			<div class="pull-right">
				Welcome ${sessionScope.username}! | <a
					href="${pageContext.request.contextPath}/logout">Logout</a>
			</div>
		</c:if>
		<c:if test="${ sessionScope.username == null }">
			<div class="pull-left">
				<a href="${pageContext.request.contextPath}/">Home</a>
			</div>
			<div class="pull-right">
				<a href="${pageContext.request.contextPath}/login">Login</a> | <a
					href="${pageContext.request.contextPath}/register">Register</a>
			</div>
		</c:if>
	</div>
</div>
<!-- Navigation bar end -->
