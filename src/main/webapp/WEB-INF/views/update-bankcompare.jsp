<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false" %>
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

h2{
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
	/* padding-top: 0px; */
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
</style>
</head>
<body>

<div class="main-blue-button scroll-to-section">
	<a href="/bankcomparisoninterest/bankcomparison/list/${bankComparisonUpdate.customerId}" class="backBtn">Back To Bank Comparison</a>
</div>
<form:form action="save" method="post" modelAttribute="bankcomparison">
					<h3>Update Comparison Form</h3>
					<div>
							<input type="number" name="customerId" hidden="true" value="${bankComparisonUpdate.customerId}"> 
							<input type="number" name="id" hidden="true" value="${bankComparisonUpdate.id}">
							<span>Bank Name</span>
							<input type="number" name="bankId"  value="${bankMaster.bankId}" hidden="true">
							<input type="text" name="bankName"  value="${bankMaster.bankName}" readonly="readonly">
							<span>Loan amount</span>
							<input type="number" id="loanAmnt" name="loanAmount" value="${bankComparisonUpdate.loanAmount}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Loan amount" required="required" oninput="getInputValue();"> 
							
							
							<span>Loan Tenure in Months</span>
							<input type="number" id="loanTenure" name="loanTenure" value="${bankComparisonUpdate.loanTenure}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Loan Tenure In Months" required="required" oninput="getInputValue();"> 
							
							<span>Loan Tenure Start Date</span>
							<input type="date" id="loanStartDate" name="loanStartDate" value="${bankComparisonUpdate.loanStartDate}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="loan Start Date" required="required" oninput="getInputValue();"> 
							
							<span>Processing Fees(%)</span> 
							<input type="number" id="prcsFeesPer" name="processingFeesPer" value="${bankComparisonUpdate.processingFeesPer}" step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Processing Fees (%)" oninput="getInputValue();" required="required"> 
							
							<span>Processing Fees</span> 
							<input type="number" id="prcsFees" name="processingFees" step="0.01" value="${bankComparisonUpdate.processingFees}" onKeyPress="if(this.value.length==10) return false;" placeholder="Processing Fees" readonly="readonly" value="0">
							
							<span>Processing Fees With GST</span> 
							<input type="number" id="processingFeesGst" name="processingFeesGst" value="${bankComparisonUpdate.processingFeesGst}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Processing Fees With GST" value="0" readonly="readonly">
							
							<span>Consultancy Fees</span> 
							<input type="number" id="consultancyFees" name="consultancyFees" value="${bankComparisonUpdate.consultancyFees}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Consultancy Fees" required="required" oninput="getInputValue();">
							
							<span>Consultancy Fees Gst</span> 
							<input type="number" id="consultancyFeesGst" name="consultancyFeesGst" value="${bankComparisonUpdate.consultancyFeesGst}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Consultancy Fees Gst" value="0" readonly="readonly">
							
							<span>Interest Rate (ROI)(%)</span> 
							<input type="number" name="interestRate" value="${bankComparisonUpdate.interestRate}" step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Interest Rate (ROI)" required="required"> 
							<input type="number" id="intrstExpns" value="${bankComparisonUpdate.interestExpense}" hidden="true" name="interestExpense" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Interest Expense" oninput="getInputValue();"> 
							<span>Renewal Fees(%)</span> 
							<input type="number" name="renewalFees" value="${bankComparisonUpdate.renewalFees}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Renewal Fees">
							<span>Renewal Expenses</span> 
							<input type="number" id="renewExpns" name="renewalExpenses" value="${bankComparisonUpdate.renewalExpenses}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Renewal Expenses" oninput="getInputValue();" required="required"> 
							<span>Hypothecation</span> 
							<input type="number" id="hypothction" name="hypothecation" value="${bankComparisonUpdate.hypothecation}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Hypothecation" oninput="getInputValue();"> 
							<span>Mortgage Charges</span> 
							<input type="number" id="mortgageAmnt" name="mortgageCharges" value="${bankComparisonUpdate.mortgageCharges}" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Mortgage Charges" oninput="getInputValue();" > 
							<span>Progress Report on Quaterly Basis</span> 
							<input type="number" id="prgsRpt" name="progressReport" value="${bankComparisonUpdate.progressReport}" step="0.01" onKeyPress="if(this.value.length==10) return false;" oninput="getInputValue();" placeholder="Progress Report on Quaterly Basis of Rs. 5000/- (3 years project plan, so 12 quarters)">
							<span>Collateral</span> 
							<select id="coltrl" name="collateral">
								<option value="default">Select</option>
								<c:if test="${bankComparisonUpdate.collateral == 'Yes'}">
									<option value="Yes" selected>Yes</option>
									<option value="No">No</option>
								</c:if>
								<c:if test="${bankComparisonUpdate.collateral == 'No'}">
									<option value="Yes">Yes</option>
									<option value="No" selected>No</option>
								</c:if>
							</select> 
							<span id="coltrlPer" style="visibility: hidden; ">Collateral(%)</span> 
							<input type="hidden" id="coltrlPerVal" name="collateralPer" value="${bankComparisonUpdate.collateralPer}" step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Collateral (%)" value="0"> 
							<span id="valRpt" style="visibility: hidden;">Valuation Report & Title Report charges of Collateral Security</span> 
							<input type="hidden" id="valRptVal" name="valuationReport" value="${bankComparisonUpdate.valuationReport}" step="0.01" onKeyPress="if(this.value.length==10) return false;" value="0" oninput="getInputValue();" placeholder="Valuation Report & Title Report charges of Collateral Security">
							<span>Total Expenses</span> <input type="number" value="${bankComparisonUpdate.totalExpenses}" step="0.01" id="totalAmnt" name="totalExpenses" placeholder="Total Expenses" value="0" readonly="readonly">
					</div>
					<span>Minimum Capital Clause</span>
					<div>
						<textarea rows="4" name="minimumCapitalClause">${bankComparisonUpdate.minimumCapitalClause}</textarea>
					</div>
					<span>Further Disbursement</span>
					<div>
						<textarea rows="4" name="furtherDisbursement">${bankComparisonUpdate.furtherDisbursement}</textarea>
					</div>
					<span>Possibilities of Disbursement Amount</span>
					<div>
						<textarea rows="4" name="possibilitiesofDisbursementAmount">${bankComparisonUpdate.possibilitiesofDisbursementAmount}</textarea>
					</div>
					<button type="submit">Submit</button>
				</form:form>
				<script>
			    	document.getElementById('coltrl').onchange = function() {
			    	
			    	if(this.value == 'Yes') {
			    		document.getElementById('coltrlPer').style.visibility='visible'; 
			    		document.getElementById("coltrlPerVal").type='visible';
			    		document.getElementById('valRpt').style.visibility='visible'; 
			    		document.getElementById("valRptVal").type='visible';
			    	} else {
			    		document.getElementById('coltrlPer').style.visibility='hidden'; 
			    		document.getElementById("coltrlPerVal").type='hidden';
			    		document.getElementById('valRpt').style.visibility='hidden';
			    		document.getElementById("valRptVal").type='hidden';
			    	}
			    	}
			   </script>

	<script>
        function getInputValue(){
			var loanAmntVal = document.getElementById("loanAmnt").value;
			var prcsFessPerVal = document.getElementById("prcsFeesPer").value;
			var hypothection = document.getElementById("hypothction").value;
			var mortgageAmnt = document.getElementById("mortgageAmnt").value;
			var consultancyFees = document.getElementById("consultancyFees").value;
			var consultancyFeesGst = 0;
			var processingFeesGst = 0;
			var prcsFees = 0;
			var hypothectionPer = 0;
			var mortgagePer = 0;
			if(isNaN(loanAmntVal) || isNaN(prcsFessPerVal)){
				prcsFees = 0;
	        } else {
	        	prcsFees = ((loanAmntVal*prcsFessPerVal) / 100).toFixed(2);
	        	processingFeesGst = ((Number(prcsFees)*18) / 100).toFixed(2);
	        	consultancyFeesGst = ((Number(consultancyFees)*18) / 100).toFixed(2)
	        	if(Number(loanAmntVal) <= 100000000){
	        		hypothectionPer = ((0.25) * Number(loanAmntVal))/100;
	        		if(Number(hypothectionPer) <= 800000){
	        			document.getElementById("hypothction").value = Number(hypothectionPer).toFixed(2);
	        		}
	        		else
	        		{	
	        			hypothectionPer = 800000;
	        			document.getElementById("hypothction").value = Number(hypothectionPer).toFixed(2);
	        		}
	        		
	        		mortgagePer = ((0.35) * Number(loanAmntVal))/100;
	        		if(Number(mortgagePer) <= 1120000){
	        			document.getElementById("mortgageAmnt").value = Number(mortgagePer).toFixed(2);
	        		}
	        		else
	        		{	
	        			mortgagePer = 1120000;
	        			document.getElementById("mortgageAmnt").value = Number(mortgagePer).toFixed(2);
	        		}
	        	}
	        	else
	        	{
	        		hypothectionPer = ((0.50) * Number(loanAmntVal))/100;
	        		if(Number(hypothectionPer) <= 800000){
	        			document.getElementById("hypothction").value = Number(hypothectionPer).toFixed(2);
	        		}
	        		else
	        		{	
	        			hypothectionPer = 800000;
	        			document.getElementById("hypothction").value = Number(hypothectionPer).toFixed(2);
	        		}
	        		
	        		mortgagePer = ((0.70) * Number(loanAmntVal))/100;
	        		if(Number(mortgagePer) <= 1120000){
	        			document.getElementById("mortgageAmnt").value = Number(mortgagePer).toFixed(2);
	        		}
	        		else
	        		{	
	        			mortgagePer = 1120000;
	        			document.getElementById("mortgageAmnt").value = Number(mortgagePer).toFixed(2);
	        		}
	        	}
	        }
			document.getElementById("prcsFees").value = prcsFees;
			document.getElementById("processingFeesGst").value = processingFeesGst;
			document.getElementById("consultancyFeesGst").value = consultancyFeesGst;
			var intrExpnse = document.getElementById("intrstExpns").value;
			var renewExpnse = document.getElementById("renewExpns").value;
			var prgsRptVal = document.getElementById("prgsRpt").value;
			var valRptVal = document.getElementById("valRptVal").value;
			
        	var sum = Number(prcsFees) + Number(intrExpnse) + Number(renewExpnse) + Number(hypothection) + Number(mortgageAmnt) + Number(prgsRptVal) + Number(valRptVal) + Number(processingFeesGst) + Number(consultancyFees) + Number(consultancyFeesGst);
        	
			document.getElementById("totalAmnt").value = sum.toFixed(2);
        }
    </script>
</body>
</html>