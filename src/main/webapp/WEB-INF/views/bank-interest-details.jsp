<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false"%>
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
<body>

	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2 align="center" style="font-weight: bold;">Loan Repayment Schedule With Interest Calculations</h2>
			<br />
			
			<c:if test="${bankInterestMaster == null}">
			<div class="main-blue-button scroll-to-section">
				<button class="button" data-modal="selectform">Select Interest Type</button>
				
				<a href="/bankcomparisoninterest/bankcomparison/list/${bankInterestMasterDetails.customerId}" class="backBtn">Back To Bank Comparison</a>
				<br><br><br>
			</div>
			</c:if>
			
			<c:if test="${bankInterestMaster != null}">
				<!-- construct an "delete" link with customer id -->
				<c:url var="deleteLink" value="/bankInterest/delete">
					<c:param name="comparisonId" value="${bankInterestMasterDetails.comparisonId}" />
					<c:param name="customerId" value="${bankInterestMasterDetails.customerId}" />
					<c:param name="totalInterest" value="${totalIntr}" />
				</c:url>
				<c:url var="exportLink" value="/bankInterest/export">
					<c:param name="comparisonId" value="${bankInterestMasterDetails.comparisonId}" />
					<c:param name="customerId" value="${bankInterestMasterDetails.customerId}" />
				</c:url>

				<div class="main-blue-button scroll-to-section">
					<a href="/bankcomparisoninterest/bankcomparison/list/${bankInterestMasterDetails.customerId}" class="backBtn">Back To Bank Comparison</a>
					<a href="${deleteLink}" class="delBtn" onclick="if (!(confirm('Are you sure you want to delete this interest calculation?'))) return false">Delete</a>	
					<a href="${exportLink}" class="delBtn" >export excel</a>	
					<c:if test="${interestType == 'Fixed'}">
						<button class="button1" data-modal="updateformfixed" >update</button>
					</c:if>
					<c:if test="${interestType == 'Advance'}">
						<button class="button" data-modal="updateformadvance">update</button>
					</c:if>			
					<br><br>
				</div>

				<br>
				<label style="font-weight: bold;">Bank Name</label>
				<input type="text" value="${bankMaster.bankName}"
					readonly="readonly">
				<br>
				<br>
				<label style="font-weight: bold;">Loan Amount</label>
				<input type="number" name="loanAmount"
					value="${bankComparison.loanAmount}" readonly="readonly">
				<br>
				<br>
				<label style="font-weight: bold;">Rate Of Interest</label>
				<input type="number" name="rateOfInterest"
					value="${bankComparison.interestRate}" readonly="readonly">
				<br>
				<br>

				<div class="panel panel-info">
					<div class="panel-body">
						<table class="table table-striped table-bordered" border="1"
							id="mtable">
							<thead>
								<tr>
									<th>Month Ending On</th>
									<th>Principal Amount for Interest Calculation</th>
									<th>Repayment to Bank</th>
									<th>Balance Outstanding</th>
									<th>Interest</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="tempCustomer" items="${bankInterestMaster}">
								<tr>
									<td>${tempCustomer.monthEndingOn}</td>
									<td>${tempCustomer.principleAmountforInterest}</td>
									<td>${tempCustomer.repaymentToBank}</td>
									<td>${tempCustomer.balanceOutsatanding}</td>
									<td>${tempCustomer.interest}</td>
								</tr>
								</c:forEach>
								
								<tr>
									<td><b>Total</b></td>
									<td><b>${totalPrincipalAmnt}</b></td>
									<td><b>${totalRepaymentAmnt}</b></td>
									<td><b></b></td>
									<td><b>${totalIntr}</b></td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</c:if>
		</div>
	</div>

	<div id="selectform" class="modal">
		<div class="modal-content1">
			<div class="contact-form">
				<span class="close1">&times;</span>
				<h3 align="center">Select Interest Type</h3>
				<table class="table-content">
					<tr>
						<td class="td-space">
						Fixed
						</td>
						<td class="td-space">
						<input type="radio" name="choice" value="1" onchange="getval();" />
						</td>
					</tr>
					<tr>
						<td class="td-space">
						Advance Collection
						</td>
						<td class="td-space">
						<input type="radio" name="choice" value="2" onchange="getval();" />
						</td>
					</tr>
				</table>
				<br><br>
					<button class="button" data-modal="fieldformfixed" hidden="true" id="Fixed">Add</button>
					<button class="button" data-modal="fieldformadvance" hidden="true" id="advance">Add</button>
			</div>
		</div>
	</div>

	<div id="fieldformfixed" class="modal">
		<div class="modal-content">
			<div class="contact-form">
				<span class="close">&times;</span>

				<form:form action="/bankcomparisoninterest/bankInterest/saveFixedInterest"
					cssClass="form-horizontal" method="post"> 
					<h3 align="center">Interest Calculation Form</h3>
						<input type="number" name="collectionAmnt" value="0" hidden="true" />
						<input type="text" name="interestType" value="Fixed" hidden="true" />
						<input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" />
						<input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" />
						<input type="number" id="loanTenure" value="${loanTenure}" hidden="true"/>
						<table>
							<tr>
								<th>Month Ending On</th>
								<th>Principal Amount</th>
								<th>Repayment to Bank</th>
							</tr>
							
							<c:forEach var="tempCustomer" items="${interestSequenceDate}" varStatus="theCount">
							<tr>
						
							<td><input type="date" value="${tempCustomer}" name="monthEndingOn" required="required"/></td>
							<td><input type="number" id="addPrincipleAmt[${theCount.index}]" name="principleAmountforInterest" onfocus="focusData(this)" onblur="blurData(this)" value="0" oninput="getInputValue();"/></td>
       						<td><input type="number" id="addRepaymentAmt[${theCount.index}]" name="repaymentToBank" onfocus="focusData(this)" onblur="blurData(this)" value="0" oninput="getInputValue();"/> <input type="number" name="advancedCollection" hidden="true" value="0" /></td>
       						
       						</tr>
       						
						</c:forEach>
						 <tr>
								<td></td>
								<td><input type="number" name="principleAmtTotal" id="principleAmtTotal" required="required" /></td>
								<td><input type="number" name="repaymentAmtTotal" id="repaymentAmtTotal" required="required"/></td>
							</tr>
						</table>
						
					<br><br>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	
	
		<div id="fieldformadvance" class="modal">
		<div class="modal-content">
			<div class="contact-form">
				<span class="close">&times;</span>

				<form:form action="/bankcomparisoninterest/bankInterest/saveAdvanceInterest"
					cssClass="form-horizontal" method="post"> 
					<h3 align="center">Advance Collection Form</h3>
					<div>
						
						<h3 align="center">Cutback</h3>
						
						<div>
						<input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" />
						<input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" />
						<input type="button" value="Add Cutback"
									onclick="addRowAdvanceCutback('dataTableAdvanceCutback')" class="btn_medium" />
						<table id="dataTableAdvanceCutback">
							<tr>
								<th>Cutback From Amount</th>
								<th>Cutback To Amount</th>
								<th>Cutback Ratio</th>
							</tr>
							<tr>
								<th><input type="number" id="addcutbackFromAmount[1]" name="cutbackFromAmount" required="required"/></th>
								<th><input type="number" id="addcutbackToAmount[1]" name="cutbackToAmount" required="required"/></th>
								<th><input type="number" id="addcutbackRatio[1]" name="cutbackRatio" required="required"/></th>
							</tr>
						</table>
						</div>
						<br>
						<label style="font-weight: bold;">Loan Amount</label> 
						<input type="number" name="loanAmount" id="advanceLoanAmount"
							value="${bankComparison.loanAmount}" readonly="readonly"> <br>
						<input type="number" id="loanTenure" value="${loanTenure}" hidden="true"/>
							
						<span>Collection amount till Date</span>
						<input type="number" name="collectionAmnt" onfocus="focusData(this)" onblur="blurData(this)" id="collectionAmnt" oninput="cal()" required="required"/>
						<input type="text" name="interestType" value="Advance" hidden="true" />
						<input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" />
						<input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" />
						
						<table>
							<tr>
								<th>Month Ending On</th>
								<th>Principal Amount</th>
								<th>Advance Collection</th>
								<th>Repayment to bank</th>
							</tr>
							
							<c:forEach var="tempCustomer" items="${interestSequenceDate}" varStatus="theCount">
							<tr>
							<td><input type="date" value="${tempCustomer}" name="monthEndingOn" required="required"/></td>
							<td><input type="number" id="addPrincipleAmtAdvance[${theCount.index}]" name="principleAmountforInterest" onfocus="focusData(this)" onblur="blurData(this)" value="0" oninput="cal()"/></td>
							<td><input type="number" id="addAdvanceCollection[${theCount.index}]" name="advancedCollection" onfocus="focusData(this)" onblur="blurData(this)" value="0" oninput="cal()"/></td>
       						<td><input type="number" id="repaymentToBankAdvance[${theCount.index}]" name="repaymentToBank" readonly="readonly"/></td>
       						<td><input type="number" id="cumulativeCollection[${theCount.index}]" name="cumulativeCollection" readonly="readonly"/></td>
       						</tr>
       						
						</c:forEach>
						<tr>
       							<th></th>
								<th><input type="number" name="principleAmtTotal" id="principleAmtTotalAdvance" readonly="readonly"/></th>
								<th><input type="number" name="advanceCollectionAmtTotal" id="advanceCollectionAmtTotal" readonly="readonly"/></th>
								<th><input type="number" name="repaymentAmtTotal" id="repaymentAmtTotalAdvance" readonly="readonly"/></th>
								<th><input type="number" name="CumulativeCollectionAmtTotal" id="CumulativeCollectionAmtTotal" readonly="readonly"/></th>
							</tr>
						</table>
					</div>
					<br><br>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<div id="updateformfixed" class="modal">
		<div class="modal-content">
			<div class="contact-form">
				<span class="close">&times;</span>

				<form:form action="/bankcomparisoninterest/bankInterest/updateFixedInterest"
					cssClass="form-horizontal" method="post"> 
					<h3 align="center">Interest Calculation Form</h3>
						<input type="number" name="collectionAmnt" value="0" hidden="true" />
						<input type="text" name="interestType" value="Fixed" hidden="true" />
						
					<div>
						<table>
							<tr>
								<td><input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" /></td>
								<td><input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" /></td>
							</tr>
							<tr>
								<th>Month Ending On</th>
								<th>Principal Amount</th>
								<th>Repayment to Bank</th>
							</tr>
							<c:forEach var="tempCustomer" items="${bankInterestMaster}" varStatus="theCount">
								<tr>
									<td><input type="date" name="monthEndingOn" value="${tempCustomer.monthEndingOn}"/></td>
									<td><input type="number" id="addPrincipleAmt[${theCount.index}]" class="principleAmountforInterest" name="principleAmountforInterest" value="${tempCustomer.principleAmountforInterest}" oninput="updateInputValue();"/></td>
									<td><input type="number" id="addRepaymentAmt[${theCount.index}]" class="repaymentToBank" name="repaymentToBank" value="${tempCustomer.repaymentToBank}" oninput="updateInputValue();"/>
										<input type="number" name="advancedCollection" hidden="true" value="0"/>
									</td>
									
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td><input type="number" name="principleAmtTotal" id="principleAmtTotalupdate" required="required" /></td>
								<td><input type="number" name="repaymentAmtTotal" id="repaymentAmtTotalupdate" required="required"/></td>
							</tr>
						</table>
					</div>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	
	<div id="updateformadvance" class="modal">
		<div class="modal-content">
			<div class="contact-form">
				<span class="close">&times;</span>

				<form:form action="/bankcomparisoninterest/bankInterest/updateAdvanceInterest"
					cssClass="form-horizontal" method="post"> 
					<h3 align="center">Advance Collection Form</h3>
						<span>Collection amount till Date</span>
						<input type="number" name="collectionAmnt" id="collectionAmntupdate" class="collectionAmnt" value="${bankComparison.collectionAmnt}" />
						<input type="text" name="interestType" value="Advance" hidden="true" />
						<label style="font-weight: bold;">Loan Amount</label> 
						<input type="number" name="loanAmount" id="advanceLoanAmountUpdate"
							value="${bankComparison.loanAmount}" readonly="readonly"> <br>
					<div>
						
						<h3 align="center">Cutback</h3>
						<div>
						<input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" />
						<input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" />
						<input type="button" value="Add Cutback"
									onclick="updateRowAdvanceCutback('dataTableUpdateAdvanceCutback')" class="btn_medium" />
						<table id="dataTableUpdateAdvanceCutback">
							<tr>
								<th>Cutback From Amount</th>
								<th>Cutback To Amount</th>
								<th>Cutback Ratio</th>
							</tr>
							<c:forEach var="tempCustomer" items="${cutbackDetails}" varStatus="theCount">
								<tr>
									<td><input type="number" name="cutbackFromAmount" class="cutbackFromAmountUpdate" id="cutbackFromAmountUpdate[${theCount.index}]" value="${tempCustomer.cutbackFromAmount}" oninput="updateAdvanceCalculation()"/></td>
									<td><input type="number" name="cutbackToAmount" class="cutbackToAmountUpdate" id="cutbackToAmountUpdate[${theCount.index}]" value="${tempCustomer.cutbackToAmount}" oninput="updateAdvanceCalculation()"/></td>
									<td><input type="number" name="cutbackRatio" class="cutbackRatioUpdate" id="cutbackRatioUpdate[${theCount.index}]" value="${tempCustomer.cutbackRatio}" oninput="updateAdvanceCalculation()"/></td>
									<td><input type="button" class="btn_medium" value="Remove" onclick="this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);" /></td>
								</tr>
							</c:forEach>
						</table>
						</div>
						
					
						<table>
							<tr>
								<td><input type="number" name="customerId" hidden="true"
									value="${bankInterestMasterDetails.customerId}" /></td>
								<td><input type="number" name="comparisonId" hidden="true"
									value="${bankInterestMasterDetails.comparisonId}" /></td>
							</tr>
							<tr>
								<tr>
								<th>Month Ending On</th>
								<th>Principal Amount</th>
								<th>Advance Collection</th>
								<th>Repayment to bank</th>
							</tr>
							</tr>
							<c:forEach var="tempCustomer" items="${bankInterestMaster}" varStatus="theCount">
								<tr>
									<td><input type="date" name="monthEndingOn" value="${tempCustomer.monthEndingOn}"/></td>
									<td><input type="number" name="principleAmountforInterest" class="principleAmountforInterestUpdate" id="principleAmountforInterestUpdate[${theCount.index}]" value="${tempCustomer.principleAmountforInterest}" oninput="updateAdvanceCalculation()"/></td>
									<td><input type="number" name="advancedCollection"  class="advancedCollectionUpdate" id="advancedCollectionUpdate[${theCount.index}]" value="${tempCustomer.advancedCollection}" oninput="updateAdvanceCalculation()"/></td>
									<td><input type="number" name="repaymentToBank" class="repaymentToBankUpdate" id="repaymentToBankUpdate[${theCount.index}]" value="${tempCustomer.repaymentToBank}" readonly="readonly"/></td>
									<td><input type="number" name="cumulativeCollection" class="cumulativeCollectionUpdate" id="cumulativeCollectionUpdate[${theCount.index}]"  value="${tempCustomer.cumulativeCollection}" readonly="readonly"/></td>
								</tr>
							</c:forEach>
							<tr>
       							<th></th>
								<th><input type="number" name="principleAmtTotal" id="principleAmtTotalAdvanceUpdate" readonly="readonly"/></th>
								<th><input type="number" name="advanceCollectionAmtTotal" id="advanceCollectionAmtTotalUpdate" readonly="readonly"/></th>
								<th><input type="number" name="repaymentAmtTotal" id="repaymentAmtTotalAdvanceUpdate" readonly="readonly"/></th>
								<th><input type="number" name="CumulativeCollectionAmtTotal" id="CumulativeCollectionAmtTotalUpdate" readonly="readonly"/></th>
							</tr>
						</table>
					</div>
					<button type="submit">Submit</button>
				</form:form>
			</div>
		</div>
	</div>
	
	
</body>

<script>

function getval() {
	const rbs = document.querySelectorAll('input[name="choice"]');
	let selectedValue;
    for (const rb of rbs) {
        if (rb.checked) {
            selectedValue = rb.value;
            break;
        }
    }
    if(selectedValue === "1") {
    	document.getElementById('Fixed').hidden=false; 
    	document.getElementById('advance').hidden=true;
    } else {
    	document.getElementById('Fixed').hidden=true;
    	document.getElementById('advance').hidden=false; 
    }
}
        const btn = document.querySelector('#btn');
        // handle button click
        btn.onclick = function () {
            const rbs = document.querySelectorAll('input[name="choice"]');
            let selectedValue;
            for (const rb of rbs) {
                if (rb.checked) {
                    selectedValue = rb.value;
                    break;
                }
            }
            alert(selectedValue);
        };
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
  let modalBtns1 = [...document.querySelectorAll(".button1")];
  modalBtns1.forEach(function(btn) {
    btn.onclick = function() {
      let modal = btn.getAttribute('data-modal');
      document.getElementById(modal)
        .style.display = "block";
      updateInputValue();
    }
  });   
    let modalBtns2 = [...document.querySelectorAll(".button2")];
    modalBtns2.forEach(function(btn) {
      btn.onclick = function() {
        let modal = btn.getAttribute('data-modal');
        document.getElementById(modal)
          .style.display = "block";
        updateInputValue();
      }
    });  

let closeBtns = [...document.querySelectorAll(".close")];
closeBtns.forEach(function(btn) {
  btn.onclick = function() {
    let modal = btn.closest('.modal');
    modal.style.display = "none";
  }
});

let closeBtns1 = [...document.querySelectorAll(".close1")];
closeBtns1.forEach(function(btn) {
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

	function addRowAdvanceCutback(tableID) {
		var table1 = document.getElementById(tableID);
		var rowCount = table1.rows.length;
		for (let i = rowCount ; i < rowCount+1 ; i++) {
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell0 = row.insertCell(0);
        cell0.innerHTML = cell0.innerHTML +' <input type="number" id="addcutbackFromAmount['+i+']" name="cutbackFromAmount" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
   
        var cell1 = row.insertCell(1);
        cell1.innerHTML = cell1.innerHTML +' <input type="number" id="addcutbackToAmount['+i+']" name="cutbackToAmount" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
        
        var cell2 = row.insertCell(2);
        cell2.innerHTML = cell2.innerHTML +' <input type="number" id="addcutbackRatio['+i+']" name="cutbackRatio" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
        
        var cell3 = row.insertCell(3);
        cell3.innerHTML = cell3.innerHTML +'<input type="button" class="btn_medium" value="Remove" onclick="this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);" />';
		}
	}
	
	
	function updateRowAdvanceCutback(tableID) {
		var table1 = document.getElementById(tableID);
		var rowCount = table1.rows.length;
		for (let i = rowCount ; i < rowCount+1 ; i++) {
        var table = document.getElementById(tableID);

        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);

        var cell0 = row.insertCell(0);
        cell0.innerHTML = cell0.innerHTML +' <input type="number" id="addcutbackFromAmount['+i+']" name="cutbackFromAmount" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
   
        var cell1 = row.insertCell(1);
        cell1.innerHTML = cell1.innerHTML +' <input type="number" id="addcutbackToAmount['+i+']" name="cutbackToAmount" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
        
        var cell2 = row.insertCell(2);
        cell2.innerHTML = cell2.innerHTML +' <input type="number" id="addcutbackRatio['+i+']" name="cutbackRatio" onfocus="focusData(this)" onblur="blurData(this)" value="0"/>';
        
        var cell3 = row.insertCell(3);
        cell3.innerHTML = cell3.innerHTML +'<input type="button" class="btn_medium" value="Remove" onclick="this.parentNode.parentNode.parentNode.removeChild(this.parentNode.parentNode);" />';
		}
	}
	
	function focusData(el) {
        el.value = '';
    }
	
	function blurData(el) {
       
		if(el.value=='')el.value="0";
    }

        function getInputValue(){
			var loanTenure =document.getElementById("loanTenure").value;
			var addPrincipleAmt = 0;
			var addRepaymentAmt = 0;
			for (let i = 0; i < loanTenure; i++) {
				addPrincipleAmt = Number(document.getElementById("addPrincipleAmt["+i+"]").value) + Number(addPrincipleAmt);
				addRepaymentAmt = Number(document.getElementById("addRepaymentAmt["+i+"]").value) + Number(addRepaymentAmt);
			}
			document.getElementById("principleAmtTotal").value = addPrincipleAmt.toFixed(2);
			document.getElementById("repaymentAmtTotal").value = addRepaymentAmt.toFixed(2);
        }
        
        function updateInputValue(){
       		debugger;
			var elements = document.querySelectorAll('.principleAmountforInterest');
			var principleAmount = document.querySelectorAll('.principleAmountforInterest');
			var repaymentToBank = document.querySelectorAll('.repaymentToBank');
			var addPrincipleAmt = 0;
			var addRepaymentAmt = 0;
			Array.prototype.slice.call(principleAmount).forEach(function(principleAmount) {
				addPrincipleAmt = Number(principleAmount.value) + Number(addPrincipleAmt);
			});
			Array.prototype.slice.call(repaymentToBank).forEach(function(repaymentToBank) {
				addRepaymentAmt = Number(repaymentToBank.value) + Number(addRepaymentAmt);
			});
			document.getElementById("principleAmtTotalupdate").value = addPrincipleAmt.toFixed(2);
			document.getElementById("repaymentAmtTotalupdate").value = addRepaymentAmt.toFixed(2);
        }
        
        function updateAdvanceCalculation(){
        	debugger;
        	var loanTenure = document.getElementById("loanTenure").value;
        	var collectionAmnt = document.getElementById("collectionAmntupdate").value;
        	var compareinterest = Number(loanTenure)-1;
			var advancedCollection = document.getElementsByClassName('advancedCollectionUpdate');
			var principleAmount = document.getElementsByClassName('principleAmountforInterestUpdate');
			var repaymentToBank = document.getElementsByClassName('repaymentToBankUpdate');
			var cumulativeCollection = document.getElementsByClassName('cumulativeCollectionUpdate');
			var cutbackFromAmountUpdate = document.getElementsByClassName('cutbackFromAmountUpdate');
			var cutbackToAmountUpdate = document.getElementsByClassName('cutbackToAmountUpdate');
			var cutbackRatioUpdate = document.getElementsByClassName('cutbackRatioUpdate');
			for (var i = 0; i < advancedCollection.length; i++) {
		    	if(i == 0){
	        		var addAdvanceCollection = advancedCollection[0].value;
	        		var addPrincipleAmount= principleAmount[0].value;
	        		var addcumulativeCollection= Number(collectionAmnt) + Number(addAdvanceCollection);
	        		document.getElementById("cumulativeCollectionUpdate[0]").value = addcumulativeCollection;
	        		document.getElementById("CumulativeCollectionAmtTotalUpdate").value = addcumulativeCollection;
	        		var x = document.getElementById('dataTableUpdateAdvanceCutback').rows.length;
	        		var repayment = 0;
	        		if(x > 1){
	        			for (var j = 0; j < x-1 ; j++) {
	        				if(Number(cutbackFromAmountUpdate[j].value) <= addcumulativeCollection
	        							&& Number(cutbackToAmountUpdate[j].value) > addcumulativeCollection)
	        				{
	        					repayment= Number(addAdvanceCollection)*(Number(cutbackRatioUpdate[j].value)/100);
	        				}
	        			}
	        			document.getElementById("repaymentToBankUpdate[0]").value = parseFloat(repayment).toFixed(2);
	        			document.getElementById("repaymentAmtTotalAdvanceUpdate").value = parseFloat(repayment).toFixed(2);
	        		}
	        		document.getElementById("principleAmtTotalAdvanceUpdate").value = addPrincipleAmount;
	        		document.getElementById("advanceCollectionAmtTotalUpdate").value = addAdvanceCollection;
				 }
		    	else if(i > 0 && i < compareinterest){
		    		var addAdvanceCollectionindex = advancedCollection[i].value;
        			var totalCumalativeCollection = Number(document.getElementById("CumulativeCollectionAmtTotalUpdate").value) + Number(addAdvanceCollectionindex);
        			document.getElementById("cumulativeCollectionUpdate["+i+"]").value = totalCumalativeCollection
        			document.getElementById("CumulativeCollectionAmtTotalUpdate").value = totalCumalativeCollection
        			var x = document.getElementById('dataTableUpdateAdvanceCutback').rows.length;
        			var totalrepayment= document.getElementById("repaymentAmtTotalAdvanceUpdate").value;
        			var totalprincipleamount = document.getElementById("principleAmtTotalAdvanceUpdate").value;
        			var totaladvancecollection = document.getElementById("advanceCollectionAmtTotalUpdate").value;
        			var repayment1 = 0;
        			if(x > 1){
        				for (var j = 0; j < x-1 ; j++) {
        					if(Number(cutbackFromAmountUpdate[j].value) <= totalCumalativeCollection
        							&& Number(cutbackToAmountUpdate[j].value) > totalCumalativeCollection)
        					{
        						repayment1= (Number(addAdvanceCollectionindex)*(Number(cutbackRatioUpdate[j].value)/100).toFixed(2));
        					}
        				document.getElementById("repaymentToBankUpdate["+i+"]").value = parseFloat(repayment1).toFixed(2);
        				}
        			document.getElementById("repaymentAmtTotalAdvanceUpdate").value = Number(totalrepayment)+Number(parseFloat(repayment1).toFixed(2));
        			document.getElementById("principleAmtTotalAdvanceUpdate").value = Number(totalprincipleamount)+ Number(principleAmount[i].value);
        			document.getElementById("advanceCollectionAmtTotalUpdate").value = Number(totaladvancecollection)+ Number(advancedCollection[i].value);
		    		}
		    	}
		    	else if(i > 0 && i == compareinterest){
		    		var addAdvanceCollectionindex = advancedCollection[i].value;
        			var totalCumalativeCollection = Number(document.getElementById("CumulativeCollectionAmtTotalUpdate").value) + Number(addAdvanceCollectionindex);
        			document.getElementById("cumulativeCollectionUpdate["+i+"]").value = totalCumalativeCollection
        			document.getElementById("CumulativeCollectionAmtTotalUpdate").value = totalCumalativeCollection
        			var x = document.getElementById('dataTableUpdateAdvanceCutback').rows.length;
        			var totalrepayment= document.getElementById("repaymentAmtTotalAdvanceUpdate").value;
        			var totalprincipleamount = document.getElementById("principleAmtTotalAdvanceUpdate").value;
        			var totaladvancecollection = document.getElementById("advanceCollectionAmtTotalUpdate").value;
					var repayment1 = 0;
        			if(x > 1){
					for (var j = 0; j < x-1 ; j++) {
        					if(Number(cutbackFromAmountUpdate[j].value) <= totalCumalativeCollection
        							&& Number(cutbackToAmountUpdate[j].value) > totalCumalativeCollection)
        					{
        						repayment1= (Number(addAdvanceCollectionindex)*(Number(cutbackRatioUpdate[j].value)/100).toFixed(2));
        					}
        				}
        			}
        			var repaymentTotalLastRow = Number(totalrepayment)+Number(parseFloat(repayment1).toFixed(2));
        			var loanamount =document.getElementById("advanceLoanAmount").value;
        			var difference = 0;
        			var repaymentForDifference = 0; 
        			if(loanamount == repaymentTotalLastRow)
        			{
        				document.getElementById("repaymentToBankUpdate["+i+"]").value = parseFloat(repayment1).toFixed(2);
        			}
        			else if(loanamount < repaymentTotalLastRow)
        			{
        				difference = Number(repaymentTotalLastRow) - Number(loanamount);
        				repayment1 = Number(repayment1) -  Number(difference);
        				document.getElementById("repaymentToBankUpdate["+i+"]").value = parseFloat(repayment1).toFixed(2);
        			}
        			else
        			{
        				document.getElementById("repaymentToBankUpdate["+i+"]").value = parseFloat(repayment1).toFixed(2);
        			}
        			document.getElementById("repaymentAmtTotalAdvanceUpdate").value = Number(totalrepayment)+Number(parseFloat(repayment1).toFixed(2));
        			document.getElementById("principleAmtTotalAdvanceUpdate").value = Number(totalprincipleamount)+ Number(principleAmount[i].value);
        			document.getElementById("advanceCollectionAmtTotalUpdate").value = Number(totaladvancecollection)+ Number(advancedCollection[i].value);
			
				}	
       	 	}
        }
        function cal()
        {
        	debugger;
        	$("input[name=advancedCollection]").each(function(index) {
        		var loanTenure = document.getElementById("loanTenure").value;
        		var compareinterest = Number(loanTenure)-1;
        		if(index == 0)
        		{
        			/* var table1 = document.getElementById('dataTableAdvanceCutback');
        			var rowCount = table1.rows.length; */
        			
        			var collectionAmnt = document.getElementById("collectionAmnt").value;
        			var addAdvanceCollection = document.getElementById("addAdvanceCollection["+0+"]").value;
        			var principleamount= document.getElementById("addPrincipleAmtAdvance["+0+"]").value;
        			var cumulativeCollection= Number(collectionAmnt) + Number(addAdvanceCollection);
        			document.getElementById("cumulativeCollection["+0+"]").value = cumulativeCollection
        			document.getElementById("CumulativeCollectionAmtTotal").value =document.getElementById("cumulativeCollection["+0+"]").value;
        			var x = document.getElementById('dataTableAdvanceCutback').rows.length;
        			var repayment = 0;
        			if(x > 1){
        				for (var i = 1; i < x ; i++) {
        					if(Number(document.getElementById("addcutbackFromAmount["+i+"]").value) <= cumulativeCollection
        							&& Number(document.getElementById("addcutbackToAmount["+i+"]").value) > cumulativeCollection)
        					{
        						repayment= Number(addAdvanceCollection)*(Number(document.getElementById("addcutbackRatio["+i+"]").value)/100);
        					}
        				}
        				document.getElementById("repaymentToBankAdvance["+0+"]").value = repayment;
        				document.getElementById("repaymentAmtTotalAdvance").value = repayment;
        				var t = document.getElementById("repaymentAmtTotalAdvance").value;
        			}
        			document.getElementById("principleAmtTotalAdvance").value = principleamount;
        			document.getElementById("advanceCollectionAmtTotal").value = addAdvanceCollection;
        		}
        		else if(index > 0 && index < compareinterest){
        			var addAdvanceCollectionindex = document.getElementById("addAdvanceCollection["+index+"]").value;
        			var totalCumalativeCollection = Number(document.getElementById("CumulativeCollectionAmtTotal").value) + Number(document.getElementById("addAdvanceCollection["+index+"]").value);
        			document.getElementById("cumulativeCollection["+index+"]").value = totalCumalativeCollection
        			document.getElementById("CumulativeCollectionAmtTotal").value = totalCumalativeCollection
        			var x = document.getElementById('dataTableAdvanceCutback').rows.length;
        			var totalrepayment= document.getElementById("repaymentAmtTotalAdvance").value;
        			var totalprincipleamount = document.getElementById("principleAmtTotalAdvance").value;
        			var totaladvancecollection = document.getElementById("advanceCollectionAmtTotal").value;
        			var repayment1 = 0;
        			if(x > 1){
        				for (var i = 1; i < x ; i++) {
        					if(Number(document.getElementById("addcutbackFromAmount["+i+"]").value) <= totalCumalativeCollection
        							&& Number(document.getElementById("addcutbackToAmount["+i+"]").value) > totalCumalativeCollection)
        					{
        						repayment1 = Number(addAdvanceCollectionindex)*(Number(document.getElementById("addcutbackRatio["+i+"]").value)/100);
        					}
        				}
        				document.getElementById("repaymentToBankAdvance["+index+"]").value = repayment1;
        			}
        			document.getElementById("repaymentAmtTotalAdvance").value = Number(totalrepayment)+Number(repayment1);
        			document.getElementById("principleAmtTotalAdvance").value = Number(totalprincipleamount)+ Number(document.getElementById("addPrincipleAmtAdvance["+index+"]").value);
        			document.getElementById("advanceCollectionAmtTotal").value = Number(totaladvancecollection)+ Number(document.getElementById("addAdvanceCollection["+index+"]").value);
        		}
        		
        		else if(index > 0 && index == compareinterest){
        			var addAdvanceCollectionindex = document.getElementById("addAdvanceCollection["+index+"]").value;
        			var totalCumalativeCollection = Number(document.getElementById("CumulativeCollectionAmtTotal").value) + Number(document.getElementById("addAdvanceCollection["+index+"]").value);
        			document.getElementById("cumulativeCollection["+index+"]").value = totalCumalativeCollection
        			document.getElementById("CumulativeCollectionAmtTotal").value = totalCumalativeCollection
        			var x = document.getElementById('dataTableAdvanceCutback').rows.length;
        			var totalrepayment= document.getElementById("repaymentAmtTotalAdvance").value;
        			var totalprincipleamount = document.getElementById("principleAmtTotalAdvance").value;
        			var totaladvancecollection = document.getElementById("advanceCollectionAmtTotal").value;
        			var repayment1 = 0;
        			if(x > 1){
        				for (var i = 1; i < x ; i++) {
        					if(Number(document.getElementById("addcutbackFromAmount["+i+"]").value) <= totalCumalativeCollection
        							&& Number(document.getElementById("addcutbackToAmount["+i+"]").value) > totalCumalativeCollection)
        					{
        						repayment1 = Number(addAdvanceCollectionindex)*(Number(document.getElementById("addcutbackRatio["+i+"]").value)/100);
        					}
        				}
        				//document.getElementById("repaymentToBankAdvance["+index+"]").value = repayment1;
        			}
        			var repaymentTotalLastRow = Number(totalrepayment)+Number(repayment1);
        			var loanamount =document.getElementById("advanceLoanAmount").value;
        			var difference = 0;
        			var repaymentForDifference = 0; 
        			if(loanamount == repaymentTotalLastRow)
        			{
        				document.getElementById("repaymentToBankAdvance["+index+"]").value = repayment1;
        			}
        			else if(loanamount < repaymentTotalLastRow)
        			{
        				difference = Number(repaymentTotalLastRow) - Number(loanamount);
        				repayment1 = Number(repayment1) -  Number(difference);
        				document.getElementById("repaymentToBankAdvance["+index+"]").value = repayment1;
        			}
        			else
        			{
        				document.getElementById("repaymentToBankAdvance["+index+"]").value = repayment1;
        			}
        			document.getElementById("repaymentAmtTotalAdvance").value = Number(totalrepayment)+Number(repayment1);
        			document.getElementById("principleAmtTotalAdvance").value = Number(totalprincipleamount)+ Number(document.getElementById("addPrincipleAmtAdvance["+index+"]").value);
        			document.getElementById("advanceCollectionAmtTotal").value = Number(totaladvancecollection)+ Number(document.getElementById("addAdvanceCollection["+index+"]").value);
        		}
        		
        	
        	 });
        	
       		}
    </script>
</html>