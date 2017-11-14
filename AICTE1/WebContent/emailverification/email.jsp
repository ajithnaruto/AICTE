<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page import="java.io.*,java.util.*,javax.mail.*"%>
<%@ page import="javax.mail.internet.*,javax.activation.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@include file="connection.jsp"  %>
<%
   String result;
  
   String to = request.getParameter("email");
   
   
   
   Properties props = new Properties();  
   props.put("mail.smtp.host", "smtp.gmail.com");  
   props.put("mail.smtp.socketFactory.port", "465");  
   props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
   props.put("mail.smtp.auth", "true");  
   props.put("mail.smtp.port", "465");  
    
   Session s = Session.getInstance(props, new javax.mail.Authenticator() { 
      
    protected PasswordAuthentication getPasswordAuthentication() {  
    return new PasswordAuthentication("anonymousbeings01@gmail.com","annauniversity");//change accordingly  
    }  
   });  
    
   //compose message  
   try { 
	   String uniqueid=UUID.randomUUID().toString();
	   Random r=new Random();
	   int ar=r.nextInt(900000)+100000;
    MimeMessage message = new MimeMessage(s);  
    message.setFrom(new InternetAddress("anonymousbeings01@gmail.com"));//change accordingly  
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
    message.setSubject("Verification");  
    message.setText("http://localhost:8081/AICTE1/emailverification/verifyEmail.jsp?token="+uniqueid);


      
    //send message  
    Transport.send(message);  
    Class.forName(driver);
   Connection con=DriverManager.getConnection(url,user,password);
   Statement stmt=con.createStatement();
   String sql="insert into ver values('"+to+"','"+uniqueid+"','"+ar+"','0')";
    int a=stmt.executeUpdate(sql);
    if(a>0){
    	%>
    	<script>alert("Success check your mail!!!");</script>
    	<% //response.sendRedirect("index1.jsp");
    	RequestDispatcher rs=request.getRequestDispatcher("emailindex.jsp");
    	rs.include(request, response);
    }
    session.invalidate();
    
   } catch (Exception e) {
	  
	   out.println(e);
	   
	   
   }
%>
<html>
<head>
<title>Send Email using JSP</title>
</head>
<body>
<!--  
<p align="center">
<% 
   //out.println("Result: " + result + "\n");
%>
</p>
-->
</body>
</html>