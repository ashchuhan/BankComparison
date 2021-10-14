<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ratnaafin</title>
<%-- <link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script> --%>

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

.td-space {
	width: 150px;
	text-align: center;
	border: 1px solid black;
	padding: 5px;
}

.table-content {
	border-collapse: separate;
	border-spacing: 20px 0;
}

.modal-content1 {
	margin: 50px auto;
	border: 1px solid #999;
	width: 18%;
	background-color: rgb(255, 255, 255);
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

input, textarea, select {
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
	background: #2371a0;
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

.close1 {
	color: black;
	float: right;
	font-size: 28px;
	font-weight: bold;
	position: absolute;
	right: 41%;
	top: 5%;
	width: 32px;
	height: 32px;
	opacity: 1;
}

.close1:hover, .close1:focus {
	color: black;
	text-decoration: none;
	cursor: pointer;
	opacity: 1;
}

.backBtn {
	align-self: flex-end;
	float: left;
}

#dataTable {
	width: 100%;
}

.delBtn {
	align-self: flex-end;
	float: right;
}

.col-md-offset-1 {
	width: 100%;
}
</style>
<script></script>
</head>
<body onload="addRowFixed('dataTableFixed')">
	<form:form action="/bankcomparisoninterest/bankInterest/saveFixedInterest" cssClass="form-horizontal" method="post">
		<h3 align="center">Interest Calculation Form</h3>
		<input type="number" name="collectionAmnt" value="0" hidden="true" />
		<input type="text" name="interestType" value="Fixed" hidden="true" />
		<input type="number" name="customerId" hidden="true" value="${bankInterestMasterDetails.customerId}" />
		<input type="number" name="comparisonId" hidden="true" value="${bankInterestMasterDetails.comparisonId}" />
		<input type="number" name="loanAmount" id="loanAmount" value="${bankComparison.loanAmount}" readonly="readonly"> <br>
		<table id = "dataTableFixed">
			<tr>
				<th>Month Ending On</th>
				<th>Principal Amount</th>
				<th>Repayment to Bank</th>
			</tr>
			<c:forEach var="tempCustomer" items="${moratoriumPeriodSequenceDate}"
				varStatus="theCount">
				<tr>
					<td><input type="date" value="${tempCustomer}" name="monthEndingOn" required="required" /></td>
					<td><input type="number" id="addPrincipleAmt[${theCount.index}]" name="principleAmountforInterest" onfocus="focusData(this)" onblur="blurData(this)" value="0" oninput="getInputValue();" /></td>
					<td><input type="number" id="addRepaymentAmt[${theCount.index}]" name="repaymentToBank" value="0" readonly="readonly" oninput="getInputValue();" /> <input type="number" name="advancedCollection" hidden="true" value="0" /></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		<button type="submit">Submit</button>
	</form:form>
</body>

<script>
	function focusData(el) {
		if(el.value == 0) {
        	el.value = '';
		}
    }
	
	function blurData(el) {
		if(el.value=='')el.value="0";
    }

     function getInputValue(){
    	 debugger;
    	var table = document.getElementById("dataTableFixed");
  		var rowCount = table.rows.length;
		var addPrincipleAmt = 0;
		var addRepaymentAmt = 0;
		for (let i = 0; i < rowCount-2; i++) {
			addPrincipleAmt = Number(document.getElementById("addPrincipleAmt["+i+"]").value) + Number(addPrincipleAmt);
			addRepaymentAmt = Number(document.getElementById("addRepaymentAmt["+i+"]").value) + Number(addRepaymentAmt);
		}
		document.getElementById("principleAmtTotal").value = addPrincipleAmt.toFixed(2);
		document.getElementById("repaymentAmtTotal").value = addRepaymentAmt.toFixed(2);
     }
     
     function addRowFixed(tableID) {
    	 debugger;
 		var table = document.getElementById(tableID);
 		var rowCount = table.rows.length;
 		var x = document.getElementById(tableID).rows.length;
 		x = x-1;
 		<c:forEach items="${repaymentPeriodSequenceDate}" var="d">
         var table = document.getElementById(tableID);

         var rowCount = table.rows.length;
         var row = table.insertRow(rowCount);

         var cell0 = row.insertCell(0);
         cell0.innerHTML = cell0.innerHTML +' <input type="date" value="${d}" name="monthEndingOn" required="required"/>';
    
         var cell1 = row.insertCell(1);
         cell1.innerHTML = cell1.innerHTML +' <input type="number" id="addPrincipleAmt['+x+']" name="principleAmountforInterest" value="0" oninput="getInputValue();" readonly="readonly"/>';
         
         var cell2 = row.insertCell(2);
         cell2.innerHTML = cell2.innerHTML +' <input type="number" id="addRepaymentAmt['+x+']" name="repaymentToBank" value="${repaymentcalculate}" oninput="getInputValue();" /><input type="number" name="advancedCollection" hidden="true" value="0" />';
         
         x++;
 		</c:forEach>
 		
 		var table3 = document.getElementById(tableID);
        var rowCount3 = table3.rows.length;
        var row3 = table3.insertRow(rowCount3);
        
        var cell0 = row3.insertCell(0);
        cell0.innerHTML = cell0.innerHTML +'';
   
        var cell1 = row3.insertCell(1);
        cell1.innerHTML = cell1.innerHTML +'<input type="number" name="principleAmtTotal" id="principleAmtTotal" readonly="readonly"/>';
        
        var cell2 = row3.insertCell(2);
        cell2.innerHTML = cell2.innerHTML +'<input type="number" name="repaymentAmtTotal" id="repaymentAmtTotal" value="${bankComparison.loanAmount}"  readonly="readonly"/>';
 	}
    </script>
</html>