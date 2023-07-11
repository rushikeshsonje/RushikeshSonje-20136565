<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%! 
		int principal;
		int totalMonths;
		int interestRate;
		double emi;
	%>
	
	<%
	principal = Integer.parseInt(request.getParameter("amt"));
	totalMonths = Integer.parseInt(request.getParameter("months"));
	interestRate = Integer.parseInt(request.getParameter("interest"));
    
	emi = (principal * interestRate * Math.pow((1 + interestRate), totalMonths)) 
			/ (Math.pow((1 + interestRate), totalMonths) - 1);
	%>
	
	<h1>The Calculated emi is : <%= emi %></h1>
</body>
</html>