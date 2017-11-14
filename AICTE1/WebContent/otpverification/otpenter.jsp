<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="otp.SendOTPAutoVerification"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><%
boolean verify;
String mobileNumber = request.getParameter("contact");
String oneTimePassword = request.getParameter("otp");
String countryCode ="91";
SendOTPAutoVerification otp=new SendOTPAutoVerification();
verify = otp.verifyOTP(countryCode, mobileNumber, oneTimePassword);
otp.verifyOTP(mobileNumber,countryCode,oneTimePassword);
response.sendRedirect("/AICTE1/dashboard1.jsp");
%>
</body>
</html>