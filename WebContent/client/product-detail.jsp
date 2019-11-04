<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product-detail</title>
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
	
    
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-left">
    <h1>Products</h1>      
  </div>
</div>
<br><br>
<div class="container">    


	  <div class="row">
	    <div class="col-sm-5">
	        <img class="img-responsive" src="res/product_image/${product.image}" alt="${product.name}" width="460" height="345"> 
	    </div>
	    <div class="col-sm-1">
		</div>
	    <div class="col-sm-6">
	    	<h2>${product.name}</h2>
	    	<p>${product.description}</p>
	    	<p><strong>Item Code : </strong><button type="button" style="background-color:  #ffb84d; border:none;border-radius: 5px; color:white" disabled> ${product.id}</button></p>
	    	<p><strong>Manufacturer : </strong> ${product.manufacturer}</p>
	    	<p><strong>Category : </strong><a href="#" style="color:blue;"> ${product.cate.name}</a></p>
	    	<p><strong>Availble units in stock : </strong> ${product.qty}</p>
	    	<h3>${product.price} USD</h3>
	    	<p>
				<a href="/MobileStore_v1/"><button type="button" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left"></span> Back</button></a>
	    	<!--	
	    		<c:url value="/addtocart?productId=${product.id}" var="addtoCart"/>
									<a href="${addtoCart}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a>
	    	 
			<c:url value="/addtocart?productId=${product.id}" var="addtoCart"/>
									<a href="${addtoCart}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a>
		       -->
		        <c:url value="/add-cart?idP=${product.id}" var="addtoCart1"/>
			<a class="add-to-cart" href="${addtoCart1}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a> 
	    	 

	    </div>
	  </div>
  
</div><br><br>

</body>
</html>
