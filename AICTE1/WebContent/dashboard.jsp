<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<nav style="background-color: #8A34FA;" id="navbar" >
		<div class="container" >



			<div class="nav-wrapper ">
				<a href="#" class="brand-logo">IEIU</a>
				<ul id="nav-mobile" class="right hide-on-med-and-down">
					<li><a href="/AICTE1/Logout">Logout</a></li>
					</ul>
			</div>
		</div>
	</nav>
    <%
		if (session != null) {
			if (session.getAttribute("inst_id") != null) {
				String inst_id = (String) session.getAttribute("inst_id");
				out.print("Welcome " + inst_id );
			} else {
				response.sendRedirect("institution.html");
			}
		}
	%>
	<div class="container" style="margin: 15% ">
		<div class="row" style="margin-left: 23% ">
			<div class="col-lg-6">
				<button class="btn btn-lg" onClick="location.href='/AICTE1/Prestaff/pre_newstaff.html'"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Staff </button>
			</div>
			<div class="col-lg-6">
				<button class="btn btn-lg" onClick="location.href='/AICTE1/prestudent/pre_newstu.html'"><i class="fa fa-graduation-cap" aria-hidden="true"></i>Student</button>
			</div>
		</div>
	</div>


<!-- Compiled and minified JavaScript -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
  <!--bootstrap-->
  <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
	
</body>
</html>