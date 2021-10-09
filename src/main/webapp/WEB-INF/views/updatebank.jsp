<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
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
<style>
.modal {
	display: none;
	position: fixed;
	z-index: 8;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	overflow: auto;
	background-color: rgb(0, 0, 0);
	background-color: rgba(0, 0, 0, 0.4);
}

.modal-content {
	margin: 50px auto;
	border: 1px solid #999;
	width: 60%;
}

h2 {
	margin: 0 0 20px;
	font-weight: 400;
	color: #fff;
}

h3, p {
	margin: 0 0 20px;
	font-weight: 400;
	color: #999;
}

span {
	color: #666;
	display: block;
	padding: 0 0 5px;
}

form {
	padding: 25px;
	margin: 25px;
	box-shadow: 0 2px 5px #f5f5f5;
	background: #eee;
}

textarea, select {
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #1c87c9;
	outline: none;
}

.inputclass{
	width: 100%;
	padding: 10px;
	margin-bottom: 20px;
	border: 1px solid #1c87c9;
	outline: none;
}

.contact-form button {
	width: 100%;
	padding: 10px;
	border: none;
	background: #1c87c9;
	font-size: 16px;
	font-weight: 400;
	color: #fff;
}

button:hover {
	/* background: #2371a0; */
	align-self: flex-end;
}

.close {
	color: black;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	right: 32px;
	top: 32px;
	width: 32px;
	height: 32px;
	opacity: 1;
}

.close:hover, .close:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
	opacity: 1;
}

.backBtn {
	align-self: flex-end;
	float: right;
}

.button {
	float: right;
}

.col-md-offset-1 {
	width: 100%;
}

.customername {
	color: #fff;
}
</style>

</head>
<body>
		<div class="main-blue-button scroll-to-section">
			<a href="/bankcomparisoninterest/" class="backBtn">Back To Create/Search Customer</a>
		</div>
				<form:form action="/bankcomparisoninterest/bank/updatebank"
					cssClass="form-horizontal" method="post" modelAttribute="bank"> 
					<h3>Update Bank Form</h3>
					<input type="radio" id="nationalized" name="bankType" value="Nationalized" required="required"/> Nationalized<br>
					<input type="radio" id="private" name="bankType" value="Private"/> Private<br>
					<input type="radio" id="nbfc" name="bankType" value="NBFC"/> NBFC<br><br>
					
						<!-- <input type="number" name="bankId" hidden="true">  -->
							<span>Select Bank Name</span> 
						<select name="bankId" id="bankId" required="required" onchange="bankdetails()">
							<option value="">Select Bank</option>
							<c:forEach var="tempCustomer1" items="${bankList}">
								<option value="${tempCustomer1.bankId}">${tempCustomer1.bankName}</option>
							</c:forEach>
					</select> 
					<br>
					<span>Change Bank Name</span> 
					<input type="text" id="bankName" name="bankName" required="required" class="inputclass" />	
					<span>Minimum Capital Clause</span>
					<div>
						<textarea rows="4" id="minimumCapitalClause" name="minimumCapitalClause" required="required"></textarea>
					</div>
					<span>Further Disbursement</span>
					<div>
						<textarea rows="4" id="furtherDisbursement" name="furtherDisbursement" required="required"></textarea>
					</div>
					<span>Possibilities of Disbursement Amount</span>
					<div>
						<textarea rows="4" id="possibilitiesofDisbursementAmount" name="possibilitiesofDisbursementAmount" required="required"></textarea>
					</div>
					<button type="submit">Submit</button>
				</form:form>

	<script>
			function bankdetails(){
	        	debugger;
	        	var iterable ="${bankList}";
	        	var bankId = document.getElementById("bankId").value;
	            <c:forEach items="${bankList}" var="bank" varStatus="loop">
	            	if(bankId == "${bank.bankId}")
	            	{
	            		$("input[name=bankType][value=${bank.bankType}]").prop('checked', true);
	            		document.getElementById("bankName").value = "${bank.bankName}";
	            		document.getElementById("minimumCapitalClause").value = "${bank.minimumCapitalClause}";
	            		document.getElementById("furtherDisbursement").value = "${bank.furtherDisbursement}";
	            		document.getElementById("possibilitiesofDisbursementAmount").value = "${bank.possibilitiesofDisbursementAmount}";

	            	}
	            	else if(bankId == "")
	            	{
	            		document.getElementById("bankName").value = "";
	            		document.getElementById("minimumCapitalClause").value = "";
	            		document.getElementById("furtherDisbursement").value = "";
	            		document.getElementById("possibilitiesofDisbursementAmount").value = "";

	            	}
	            </c:forEach>
	        }
	</script>
</body>
</html>