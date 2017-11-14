<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
  .modal-body {
    overflow-y: hidden;
    height: 100%;
    max-height:190px;
  }
a{

margin-top:10px;
}

</style>


   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br><br><br><br><br><br><br><br>
  <center> <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#mymodal">Click here to login or signup</button></center>

<div id="mymodal" role="dialog" class="modal fade">
<div class="modal-dialog modal-sm">
<div class="modal-content">


<div class="container">


<ul class="nav nav-pills" >


<li class="active"><a data-toggle="tab" href="#login">Login</a></li>


<li><a href="#register" data-toggle="tab">Register</a></li>



</ul>

</div>
<hr>
<div class="modal-body ">
<div class="tab-content">

<div id="login" class="tab-pane fade in active">

<div class="col-lg-12">
<form role="form" action="/AICTE1/institution.html" method="post" >
<div class="row">
<div class="form-group">

<input type="email" name="email" class="form-control form-horizontal" placeholder="Username" required="required">
</div>
<div class="form-group">
<input type="password" name="email" class="form-control" placeholder="Password" required="required">
</div>
<div class="form-group col-sm-6 col-sm-offset-4" >
<button class="btn btn-danger" type="submit" >Login</button>
</div>
</div>
</form>
</div>
</div>

<div id="register" class="tab-pane fade">
<div  class="col-lg-12">
<form role="form" method="post" action="email.jsp">
<div class="row">
<div class="form-group">

<input type="email" name="email" class="form-control" placeholder="Username" required="required">
</div>
<div class="form-group col-sm-5 col-sm-offset-4" >
<button class="btn btn-danger" type="submit" >Register</button>
</div>
</div>
</form>
</div>
</div>

</div>

</div>
</div>

</div>
</div>

</body>
</html>