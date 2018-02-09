
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
<title>Spring MVC Tax Calculations</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/static/resources/css/screen.css"/>" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<div id="container" style="padding-left: 180px;">

		<div id="content" align="center">
			<h1>Welcome Psiber Tax Solutions</h1>
			<form:form action="calculate" method="post" modelAttribute="taxData">

				<table>
					<tbody>

						<tr>
							<th align="left">Please Select Tax Year:</th>
							<td class="taxData"><select name="yearEnd">
									<option value="2018">2018 (Mar 2017 - Feb 2018)</option>
									<option value="2017">2017 (Mar 2016 - Feb 2017)</option>
							</select></td>
						</tr>

						<tr>
							<th align="left">Please select your Age group:</th>
							<td class="taxData"><select name="age">
									<option value="65">Under 65</option>
									<option value="75">65 - 75</option>
									<option value="80">Over 75</option>
							</select></td>
						</tr>
						<tr>

							<th align="left">Please Select Tax Period :</th>
							<td class="taxData"><select name="earnPeriod">
									<option value="monthly" selected>Monthly</option>
									<option value="yearly">Yearly</option>
							</select></td>


						</tr>
						<tr>
							<th align="left">Please Enter your Gross Income:</th>
							<td><input type="text" name="grossIncome"
								onkeyup="this.value=this.value.replace(/[^1234567890.]/g, '');" /></td>
						</tr>

					</tbody>
				</table>
				<table>
					<tr>
						<td><input type="submit" value="Submit"
							class="taxData btn-success" /></td>


					</tr>
				</table>

			</form:form>

			<h2>Calculated Taxations</h2>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>Total CTC</th>
						<th>Total TAX</th>
						<th>Monthly Tax</th>
						<th>NetSalary</th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>${calculatedTaxResponse.yearlyGross}</td>
						<td>${calculatedTaxResponse.tax}</td>
						<td>${calculatedTaxResponse.monthlyTax}</td>
						<td>${calculatedTaxResponse.netSalary}</td>

					</tr>
				</tbody>
			</table>

		</div>


	</div>

	<div id="footer">
		<p>
			This is a mini Tax Calculation Application by Shivars.<br />
		</p>
	</div>
</body>
</html>
