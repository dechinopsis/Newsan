<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<title>NewSan Login</title>
<style>
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #eee;
}

.form-signin {
	max-width: 330px;
	padding: 15px;
	margin: 0 auto;
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin .checkbox {
	font-weight: normal;
}

.form-signin .form-control {
	position: relative;
	height: auto;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>
</head>
<body> 
	<div class="container">
		<div class="alert alert-danger" role="alert" id="errorMessage" style="display:none;"></div>
		<form class="form-signin">
			<center><h2 class="form-signin-heading">Newsan Login</h2></center>
			<label class="sr-only">Usuario</label> <input id="inputUser"
				class="form-control" placeholder="User" required autofocus /> <label
				for="inputPassword" class="sr-only">Password</label> <input
				type="password" id="inputPassword" class="form-control"
				placeholder="Password" required />
			<button class="btn btn-lg btn-primary btn-block" id="loginBtn">Iniciar
				Sesión</button>
		</form>
	</div>
</body>
<script>
	$(document).ready(function() {
		$('#loginBtn').click(function(event) {
			var user = $('#inputUser').val();
			var password = $('#inputPassword').val();
			var json = {
					"cUser" : user,
					"cPassword" : password
					};
			$('#errorMessage').fadeOut();
			$.ajax({
	            url: "/NewSan/rest/login/requestLogin",
	            data: JSON.stringify(json),
	            dataType: 'json',
	            type: "POST",
	            contentType: 'application/json',
	            beforeSend: function(){
	            	$('#loginBtn').attr('disabled','true');
	            	$('#loginBtn').html('Iniciando...');
	            },
	            success: function(result) {
	            	$('#loginBtn').removeAttr('disabled');
	            	$('#loginBtn').html('Iniciar Sesión');
	            	window.console.log('Results: '+JSON.stringify(result));
	            	if(!result.lStatus){
	            		$('#errorMessage').html("<b>Login Failed: </b>"+result.cMessage);
	            		$('#errorMessage').slideDown();
	            	}else{
	            		window.location = "/NewSan/app/";
	            	}
	            },
	            error:function(data,status,er) { 
	            	window.console.log("error: "+JSON.stringify(data)+" status: "+status+" er:"+er);
	            }
	        });
			event.preventDefault();
		});
	});
</script>
</html>