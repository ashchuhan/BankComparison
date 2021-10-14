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
	float: left;
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
	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2 align="center" style="font-weight: bold;">Bank Comparison</h2>
			<h3 class="customername">Customer Name : ${customer.customerName}</h3>
			<br />
			<!-- <button class="button" data-modal="fieldform">Insert Bank</button> -->
			<!-- <br> <br> -->
			<div class="main-blue-button scroll-to-section">
				<a href="/bankcomparisoninterest/" class="backBtn">Back To Create/Search Customer</a>
				<button class="button" data-modal="fieldform">Add Bank</button>
				<c:url var="exportLink" value="/bankcomparison/list/export/">
					<c:param name="customerId" value="${custId}" />
				</c:url>
				<a href="${exportLink}">export Excel</a>
				<br><br><br>
			</div>
			<table class="table table-striped table-bordered" border="1">
				<thead>
					<tr>
						<th>Bank Name</th>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<th>${tempCustomer.bankName}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Loan amount</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.loanAmount}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Loan Tenure in Months</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.loanTenure}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Loan Tenure Start Date</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.loanStartDate}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Processing Fees (%)</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.processingFeesPer}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Processing Fees</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.processingFees}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Processing Fees With GST</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.processingFeesGst}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Interest Rate (ROI)</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.interestRate}</td>

						</c:forEach>
					</tr>
					<tr>
						<td>Consultancy Fees</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.consultancyFees}</td>

						</c:forEach>
					</tr>
					<tr>
						<td>Consultancy Fees Gst</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.consultancyFeesGst}</td>

						</c:forEach>
					</tr>
					<tr>
						<td>Interest Expense</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.interestExpense}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Renewal Fees</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.renewalFees}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Renewal Expenses</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.renewalExpenses}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Hypothecation</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.hypothecation}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Mortgage Charges</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.mortgageCharges}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Progress Report on Quaterly Basis of Rs. 5000/- (3 years
							project plan, so 12 quarters)</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.progressReport}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Collateral</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.collateral}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Collateral %</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.collateralPer}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Valuation Report & Title Report charges of Collateral
							Security</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.valuationReport}</td>
						</c:forEach>
					</tr>
					<tr>
						<td><b>Total Expenses</b></td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.totalExpenses}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Minimum Capital Clause</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.minimumCapitalClause}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Further Disbursement</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.furtherDisbursement}</td>
						</c:forEach>
					</tr>
					<tr>
						<td>Possibilities of Disbursement Amount</td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<td>${tempCustomer.possibilitiesofDisbursementAmount}</td>
						</c:forEach>
					</tr>
					<tr>
						<td><b>Action</b></td>
						<c:forEach var="tempCustomer" items="${bankComparison}">
							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/bankcomparison/list/updateForm">
								<c:param name="bankcomparisonId" value="${tempCustomer.id}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/bankcomparison/list/delete/">
								<c:param name="comparisonId" value="${tempCustomer.id}" />
								<c:param name="customerId" value="${tempCustomer.customerId}" />
							</c:url>
							<c:url var="interestLink" value="/bankcomparison/list/interest/">
								<c:param name="customerId" value="${tempCustomer.customerId}" />
								<c:param name="comparisonId" value="${tempCustomer.id}" />
							</c:url>
							<td>
								<div class="main-blue-button scroll-to-section">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
									<a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this bank?'))) return false">Delete</a>
									<a href="${interestLink}">Add/View Interest</a>
								</div>
							</td>
						</c:forEach>
					</tr>
				<tbody>
			</table>
		</div>
	</div>

	<div id="fieldform" class="modal">
		<div class="modal-content">
			<div class="contact-form">
				<span class="close">&times;</span>
				<form:form action="save" cssClass="form-horizontal" method="post"
					modelAttribute="bankcomparison">
					<h3>Comparison Form</h3>
					<div>
						<input type="number" name="customerId" hidden="true" value="${custId}"> 
						<input type="number" name="collectionAmnt" hidden="true" value="0"> 
							<span>Bank Name</span> 
							<select name="bankId" id="bankId" onchange="bankdetails()" required="required">
							<option value="">Select Bank</option>
							<c:forEach var="tempCustomer1" items="${bankList}">
								<option value="${tempCustomer1.bankId}" >${tempCustomer1.bankName}</option>
							</c:forEach>
							</select> 
							<span>Loan amount</span>
							<input type="text" id="loanAmnt" name="loanAmount" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Loan amount" required="required" oninput="getInputValue(); numberToEnglish()"> 
							<span id="error"></span>
							<span>Loan Tenure in Months</span>
							<input type="number" id="loanTenure" name="loanTenure" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Loan Tenure In Months" required="required" oninput="getInputValue();"> 
							
							<span>Loan Tenure Start Date</span>
							<input type="date" id="loanStartDate" name="loanStartDate" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="loan Start Date" required="required" oninput="getInputValue();"> 
							
							<span>Processing Fees(%)</span> 
							<input type="number" id="prcsFeesPer" name="processingFeesPer" step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Processing Fees (%)" oninput="getInputValue();" required="required"> 
							
							<span>Processing Fees</span> 
							<input type="number" id="prcsFees" name="processingFees" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Processing Fees" readonly="readonly" value="0">
							
							<span>Processing Fees GST</span> 
							<input type="number" id="processingFeesGst" name="processingFeesGst" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Processing Fees With GST" value="0" readonly="readonly">
							
							<span>Consultancy Fees</span> 
							<input type="number" id="consultancyFees" name="consultancyFees" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Consultancy Fees" required="required" oninput="getInputValue();">
							
							<span>Consultancy Fees Gst</span> 
							<input type="number" id="consultancyFeesGst" name="consultancyFeesGst" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Consultancy Fees Gst" value="0" readonly="readonly">
							
							<span>Interest Rate (ROI)(%)</span> 
							<input type="number" name="interestRate"  step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Interest Rate (ROI)" required="required"> 
							<input type="number" id="intrstExpns" onfocus="value=''" onblur="if(this.value=='')this.value='0'"  value="0" hidden="true" name="interestExpense" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Interest Expense" oninput="getInputValue();"> 
							<span>Renewal Fees(%)</span> 
							<input type="number" id="renewFees" name="renewalFees" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Renewal Fees" required="required" oninput="getInputValue();">
							<span>Renewal Expenses</span> 
							<input type="number" id="renewExpns" name="renewalExpenses" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Renewal Expenses" oninput="getInputValue();" onfocus="value=''" onblur="if(this.value=='')this.value='0'"  value="0"> 
							<span>Hypothecation</span> 
							<input type="number" id="hypothction" name="hypothecation" step="0.01" onKeyPress="if(this.value.length==10) return false;" onfocus="value=''" onblur="if(this.value=='')this.value='0'"  value="0" placeholder="Hypothecation" oninput="getInputValue();"> 
							<span>Mortgage Charges</span> 
							<input type="number" id="mortgageAmnt" name="mortgageCharges" step="0.01" onKeyPress="if(this.value.length==10) return false;" placeholder="Mortgage Charges" oninput="getInputValue();" onfocus="value=''" onblur="if(this.value=='')this.value='0'"  value="0">  
							<span>Progress Report on Quaterly Basis</span> 
							<input type="number" id="prgsRpt" name="progressReport" step="0.01" onfocus="value=''" onblur="if(this.value=='')this.value='0'"  value="0" onKeyPress="if(this.value.length==10) return false;" oninput="getInputValue();" placeholder="Progress Report on Quaterly Basis of Rs. 5000/- (3 years project plan, so 12 quarters)">
							<span>Collateral</span> 
							<select id="coltrl" name="collateral">
								<option value="Yes" >Yes</option>
								<option value="No" selected>No</option>
							</select> 
							<span id="coltrlPer" style="visibility: hidden; ">Collateral(%)</span> 
							<input type="hidden" id="coltrlPerVal" name="collateralPer" step="0.01" onKeyPress="if(this.value.length==5) return false;" placeholder="Collateral (%)" value="0"> 
							<span id="valRpt" style="visibility: hidden;">Valuation Report & Title Report charges of Collateral Security</span> 
							<input type="hidden" id="valRptVal" name="valuationReport" step="0.01" onKeyPress="if(this.value.length==10) return false;" value="0" oninput="getInputValue();" placeholder="Valuation Report & Title Report charges of Collateral Security">
							<span>Total Expenses</span> <input type="number" step="0.01" id="totalAmnt" name="totalExpenses" placeholder="Total Expenses" value="0">
					</div>
					<span>Minimum Capital Clause</span>
					<div>
						<textarea rows="4" name="minimumCapitalClause" id="minimumCapitalClause"></textarea>
					</div>
					<span>Further Disbursement</span>
					<div>
						<textarea rows="4" name="furtherDisbursement" id="furtherDisbursement"></textarea>
					</div>
					<span>Possibilities of Disbursement Amount</span>
					<div>
						<textarea rows="4" name="possibilitiesofDisbursementAmount" id="possibilitiesofDisbursementAmount"></textarea>
					</div>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>

	<script>
    	document.getElementById('coltrl').onchange = function() {
    	
    	if(this.value == 'Yes') {
    		document.getElementById('coltrlPer').style.visibility='visible'; 
    		document.getElementById('coltrlPerVal').type='visible';
    		document.getElementById('valRpt').style.visibility='visible'; 
    		document.getElementById('valRptVal').type='visible';
    	} else {
    		document.getElementById('coltrlPer').style.visibility='hidden'; 
    		document.getElementById('coltrlPerVal').type='hidden';
    		document.getElementById('valRpt').style.visibility='hidden';
    		document.getElementById('valRptVal').type='hidden';
    	}
    	}
    </script>

	<script>
      let modalBtns = [...document.querySelectorAll(".button")];
      modalBtns.forEach(function(btn) {
        btn.onclick = function() {
          let modal = btn.getAttribute('data-modal');
          document.getElementById(modal)
            .style.display = "block";
        }
      });
      let closeBtns = [...document.querySelectorAll(".close")];
      closeBtns.forEach(function(btn) {
        btn.onclick = function() {
          let modal = btn.closest('.modal');
          modal.style.display = "none";
        }
      });
      window.onclick = function(event) {
        if(event.target.className === "modal") {
          event.target.style.display = "block";
        }
      }
    </script>
	<script>
        function getInputValue(){
        	debugger;
			var loanAmntVal = document.getElementById("loanAmnt").value;
			var lakh = Math.floor(Number(loanAmntVal) * 100000);
			var prcsFessPerVal = document.getElementById("prcsFeesPer").value;
			var hypothection = document.getElementById("hypothction").value;
			var mortgageAmnt = document.getElementById("mortgageAmnt").value;
			var consultancyFees = document.getElementById("consultancyFees").value;
			var renewalFees = document.getElementById("renewFees").value;
			var consultancyFeesGst = 0;
			var processingFeesGst = 0;
			var prcsFees = 0;
			var hypothectionPer = 0;
			var mortgagePer = 0;
			var renewExpnse = 0;
			if(isNaN(loanAmntVal) || isNaN(prcsFessPerVal)){
				prcsFees = 0;
	        } else {
	        	prcsFees = ((loanAmntVal*prcsFessPerVal) / 100).toFixed(2);
	        	renewExpnse = ((loanAmntVal*renewalFees) / 100).toFixed(2);
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
			document.getElementById("renewExpns").value = renewExpnse;
			document.getElementById("prcsFees").value = prcsFees;
			document.getElementById("processingFeesGst").value = processingFeesGst;
			document.getElementById("consultancyFeesGst").value = consultancyFeesGst;
			var intrExpnse = document.getElementById("intrstExpns").value;
			var prgsRptVal = document.getElementById("prgsRpt").value;
			var valRptVal = document.getElementById("valRptVal").value;
         	var sum = Number(prcsFees) + Number(intrExpnse) + Number(renewExpnse) + Number(hypothection) + Number(mortgageAmnt) + Number(prgsRptVal) + Number(valRptVal) + Number(processingFeesGst) + Number(consultancyFees) + Number(consultancyFeesGst);
			document.getElementById("totalAmnt").value = sum.toFixed(2);
        }
        
        function bankdetails(){
        	debugger;
        	var iterable ="${bankList}";
        	var bankId = document.getElementById("bankId").value;
            <c:forEach items="${bankList}" var="bank" varStatus="loop">
            	if(bankId == "${bank.bankId}")
            	{
            		document.getElementById("minimumCapitalClause").value = "${bank.minimumCapitalClause}";
            		document.getElementById("furtherDisbursement").value = "${bank.furtherDisbursement}";
            		document.getElementById("possibilitiesofDisbursementAmount").value = "${bank.possibilitiesofDisbursementAmount}";
            	}
            	else if(bankId == "")
            	{
            		document.getElementById("minimumCapitalClause").value = "";
            		document.getElementById("furtherDisbursement").value = "";
            		document.getElementById("possibilitiesofDisbursementAmount").value = "";

            	}
            </c:forEach>
        }
    </script>
    <script>
    /**
     * Convert an integer to its words representation
     * 
     * @author McShaman (http://stackoverflow.com/users/788657/mcshaman)
     * @source http://stackoverflow.com/questions/14766951/convert-digits-into-words-with-javascript
     */
    function numberToEnglish() {
    	 debugger;
		var n = document.getElementById("loanAmnt").value
		
		
        var string = n.toString(),
            units, tens, scales, start, end, chunks, chunksLen, chunk, ints, i, word, words;

       // var and = custom_join_character || 'and';

        /* Is number zero? */
        if (parseInt(string) === 0) {
            return 'zero';
        }

        /* Array of units as words */
        units = ['', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine', 'ten', 'eleven', 'twelve', 'thirteen', 'fourteen', 'fifteen', 'sixteen', 'seventeen', 'eighteen', 'nineteen'];

        /* Array of tens as words */
        tens = ['', '', 'twenty', 'thirty', 'forty', 'fifty', 'sixty', 'seventy', 'eighty', 'ninety'];

        /* Array of scales as words */
        scales = ['', 'thousand', 'million', 'billion', 'trillion', 'quadrillion', 'quintillion', 'sextillion', 'septillion', 'octillion', 'nonillion', 'decillion', 'undecillion', 'duodecillion', 'tredecillion', 'quatttuor-decillion', 'quindecillion', 'sexdecillion', 'septen-decillion', 'octodecillion', 'novemdecillion', 'vigintillion', 'centillion'];

        /* Split user arguemnt into 3 digit chunks from right to left */
        start = string.length;
        chunks = [];
        while (start > 0) {
            end = start;
            chunks.push(string.slice((start = Math.max(0, start - 3)), end));
        }

        /* Check if function has enough scale words to be able to stringify the user argument */
        chunksLen = chunks.length;
        if (chunksLen > scales.length) {
            return '';
        }

        /* Stringify each integer in each chunk */
        words = [];
        for (i = 0; i < chunksLen; i++) {

            chunk = parseInt(chunks[i]);

            if (chunk) {

                /* Split chunk into array of individual integers */
                ints = chunks[i].split('').reverse().map(parseFloat);

                /* If tens integer is 1, i.e. 10, then add 10 to units integer */
                if (ints[1] === 1) {
                    ints[0] += 10;
                }

                /* Add scale word if chunk is not zero and array item exists */
                if ((word = scales[i])) {
                    words.push(word);
                }

                /* Add unit word if array item exists */
                if ((word = units[ints[0]])) {
                    words.push(word);
                }

                /* Add tens word if array item exists */
                if ((word = tens[ints[1]])) {
                    words.push(word);
                }

                /* Add 'and' string after units or tens integer if: */
                if (ints[0] || ints[1]) {

                    /* Chunk has a hundreds integer or chunk is the first of multiple chunks */
                    if (ints[2] || !i && chunksLen) {
                        //words.push(and);
                    }

                }

                /* Add hundreds word if array item exists */
                if ((word = units[ints[2]])) {
                    words.push(word + ' hundred');
                }

            }

        }
		var error = document.getElementById("error");
		error.innerHTML = "<span style='color: black;'>"+
        ""+ words.reverse().join(' ') +"</span>"
        return words.reverse().join(' ');
        
    }
    
    </script>
</body>
</html>