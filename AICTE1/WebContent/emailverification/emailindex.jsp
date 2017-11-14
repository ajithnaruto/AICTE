<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="jumbotron">
		<div class="container text-center">
			<div class="container">
				<!-- Trigger the modal with a button -->
				<button type="button" class="btn btn-info btn-lg color" style="padding:25px 90px" data-toggle="modal" data-target="#login-modal">Get Password</button>


<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none">
					<div class="modal-dialog">
						<div class="container">
							<div class="row">
								<div class="col-md-6 col-md-offset-3">
									<div class="panel panel-login">
										<div class="panel-heading">
											<div class="row">
												<div class="col-xs-6">
													<a href="#" class="active" id="login-form-link">Login</a>
												</div>
												<div class="col-xs-6">
													<a href="#" id="register-form-link">Register</a>
												</div>
											</div>
											<hr>
										</div>
										<div class="panel-body">
											<div class="row">
												<div class="col-lg-12">
													<form id="login-form" action="institution.html" method="post"
														role="form" style="display: block;">
														<input type="hidden" name="csrfPreventionSalt"
															value="wELLytcL3MvIr4QW0jHC" /> 
														<div class="form-group">
															<input type="email" name="uname" id="uname"
																tabindex="1" class="form-control" placeholder="Mail"
																value="">
														</div>
														<div class="form-group">
															<input type="password" name="passwd" id="passwd"
																tabindex="2" class="form-control" placeholder="Password">
														</div>
														<div class="form-group">
															<div class="row">
																<div class="col-sm-6 col-sm-offset-3">
																	<input type="submit" name="login"
																		id="login-submit" tabindex="4"
																		class="form-control btn btn-login color"
																		value="Log In">
																</div>
															</div>
														</div>

													</form>
													<form id="register-form" action="Login.jsp" method="post"
														role="form" style="display: none;">
														<input type="hidden" name="csrfPreventionSalt"
															value="wELLytcL3MvIr4QW0jHC" /> 
														<div class="form-group">
															<input type="email" name="uname" id="uname" tabindex="1"
																required class="form-control"
																placeholder="Email Address" value="">
														</div>

														<div class="form-group">
															<div class="row">
																<div class="col-sm-6 col-sm-offset-3">
																	<input type="submit" name="register"
																		id="register-submit" tabindex="4"
																		class="form-control btn btn-register color"
																		value="Register">
																</div>
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

					</div>


				</div>

			</div>
		</div>
	</div>
	<br>

</body>
</html>