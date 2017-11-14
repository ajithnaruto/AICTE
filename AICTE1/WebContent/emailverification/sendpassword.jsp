<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@include file="connection.jsp"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
   String email=(String)session.getAttribute("email");
   
   Properties props = new Properties();  
   props.put("mail.smtp.host", "smtp.gmail.com");  
   props.put("mail.smtp.socketFactory.port", "465"); 
   props.put("mail.smtp.socketFactory.class",
             "javax.net.ssl.SSLSocketFactory");  
   props.put("mail.smtp.auth", "true");  
   props.put("mail.smtp.port", "465");  
    
   Session s = Session.getInstance(props, new javax.mail.Authenticator() { 
      
    protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication("anonymousbeings01@gmail.com","annauniversity");//change accordingly  
    }  
   });  
    
   
   try { 
	   
	   Class.forName(driver);
	   Connection con=DriverManager.getConnection(url,user,password);
	   Statement stmt=con.createStatement();
	   String sql="select * from ver where email='"+email+"'";
	   System.out.println("SQL : "+sql);
	   ResultSet rs=stmt.executeQuery(sql);
	   while (rs.next()){
		   
		   String pwd=rs.getString("password");
		   session.setAttribute("pwd", pwd);
	   }

    MimeMessage message = new MimeMessage(s);  
    message.setFrom(new InternetAddress("anonymousbeings01@gmail.com"));//change accordingly  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(email));  
    message.setSubject("Verification");
    String pwd=(String)session.getAttribute("pwd");
    message.setText("password="+pwd);  
      
    //send message  
    Transport.send(message);  
     //session.invalidate();
     %>
 	<script>alert("A verification email has been sent to your Email-id.");</script>
 	<% 
 	RequestDispatcher rd=request.getRequestDispatcher("/emailverification/emailverindex.jsp");
	rd.include(request, response);
    
   } catch (MessagingException e) {
	  
	   out.println(e);
	   
	   
   }
%>
<body>

</body>
</html>