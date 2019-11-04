<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <style>
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
	
    .card {
      box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
      max-width: 350px;
      margin: auto;
      text-align: center;
      font-family: arial;
    }

    .price {
      color: grey;
      font-size: 19px;
    }
    .quantity {
      color: grey;
      font-size: 19px;
    }

    .card button {
      border: none;
      outline: 0;
 	  padding: 10px 140px 10px 140px;
      color: white;
      text-align: center;
      cursor: pointer;
      font-size: 15px;
    }

    .card button:hover {
      opacity: 0.9;
      background-color:  #008040;
      
    }
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-left">
    <h1>Mobile Store</h1> 
  </div>
</div>
<br><br>
<div class="container">    
  <div class="row">
  
    <div class="col-sm-12">
      <div class="card">
        <div class="panel panel-default">
        <div class="panel-heading">Please sign in</div>
        <div class="panel-body">
		<c:url value="/login" var="loginUrl"/>
        	<form action="${loginUrl}" method="POST">
			    <div class="form-group">
			      <input type="text" required class="form-control" name="username" id="username" placeholder="User Name">
			    </div>
			    <div class="form-group">
			      <input type="password" required class="form-control" name="password" id="password" placeholder="Password">
			    </div>
			    <button type="submit" class="btn btn-success">Login</button>
			</form>
        </div>
      </div>
      </div>
    </div>
   
  </div>
</div><br><br>



</body>
</html>
