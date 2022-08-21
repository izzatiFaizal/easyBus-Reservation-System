<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>
.bg {
  background-image: url('img/bus5.jpeg');
  background-repeat: no-repeat;
  background-attachment: fixed;  
  background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Login</title>
<!-- login css -->
<link rel="stylesheet" href="css/login.css">
<!-- bootstrap css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- bootstrap css -->
<link rel="stylesheet" href="css/all.css">
</head>

<body class="bg">
    <div class="container">

        <!-- Outer Row -->
        <div class="row">

           <div class="col-sm-9 col-md-7 col-lg-5 mx-auto"> 

                <div class="card card-signin my-5">
                    <div class="card-body">
                        <!-- Nested Row within Card Body -->
                        
                                    <div class="text-center">
                                    	<img src="img/logo7.png" alt="#"/>
                                        <p><strong><h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1></strong></p>
                                        
                                    </div>
                                    <form action="LoginController" method="POST" class="user">
                                        <div class="form-group">
                                            <input type="text" class="form-control form-control-user"
                                                name="email" placeholder="Enter Email">
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control form-control-user"
                                                name="password" placeholder="Password">
                                        </div>
                                        <div class="form-group">
                                            <div class="custom-control custom-checkbox small">
                                                <input type="checkbox" class="custom-control-input" id="customCheck">
                                                <label class="custom-control-label" for="customCheck">Remember
                                                    Me</label>
                                            </div>
                                        </div>
                                        <input type="submit" value="Login" class="btn btn-primary btn-user btn-block">
                                    </form>
                                    <hr>
                                    <div class="text-center">
                                        <a class="small" href="register.html">Create an Account!</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
<!-- Javascript files-->
<script src="js/jquery.slim.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>

</body>
</html>