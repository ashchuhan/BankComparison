<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ratnaafin</title>

<link
	href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/css/templatemo-seo-dream.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

<link href="<c:url value="/resources/assets/css/fontawesome.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/animated.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/owl.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-12 wow fadeInUp" data-wow-duration="0.5s"
				data-wow-delay="0.25s">
				<form:form action="saveCustomer" cssClass="form-horizontal" method="post" modelAttribute="customer" id="customer">
					<div class="row">
						<div class="col-lg-6 offset-lg-3">
							<div class="section-heading">
								<h2>Create New/Search Customer</h2>
							</div>
						</div>
						<div class="col-lg-6 offset-lg-3">
							<fieldset>
								<form:hidden path="customerId" />
							</fieldset>
						</div>
						<div class="col-lg-12 ">
							<fieldset>
								<div class="section-heading">
									<label for="customerName"><h6>Customer Name</h6></label><br>
									<form:input path="customerName" placeholder="Name" required="required" />
								</div>
							</fieldset>
						</div>
						<div class="col-lg-6 offset-lg-3">
							<fieldset>
								<form:button cssClass="main-blue-button scroll-to-section">Submit</form:button>
							</fieldset>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>