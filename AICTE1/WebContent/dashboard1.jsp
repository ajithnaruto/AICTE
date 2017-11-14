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
			if (session.getAttribute("uidai") != null) {
				String uidai = (String) session.getAttribute("uidai");
				out.print("Welcome " + uidai );
			} 
		}
	%>
	<div class="container" style="margin: 15% ">
		<div class="row" style="margin-left: 23% ">
			
			<div class="col-lg-6"><label><b>Select your area of specialisation</label>
				<form class="form-control" method="post" action="/AICTE1/trendupdate">
				UIDAI:<input type="text" name="uidai">
				<select  class="form-control" name="field">
       
  <option value = "AI">Artificial Intelligence</option>
  <option value = "CPY">Cryptogrpahy</option>
  <option value = "ML">Machine Learning</option>
  <button class="btn btn-default" onClick="location.href='discrepancy.html'">Discrepancy</button>
  
</select><br> <input type="submit" value="submit!" class="btn btn-default ">   </form>
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