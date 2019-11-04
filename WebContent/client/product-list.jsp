<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product-list</title>
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
      max-width: 300px;
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
      padding: 10px;
      color: white;
      text-align: center;
      cursor: pointer;
      font-size: 15px;
    }


  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-left">
  <a href="/MobileStore_v1/client/cart.jsp"  style="text-decoration: none; color:black"><button type="button" class="btn btn-default pull-right">  
<span class="glyphicon glyphicon-shopping-cart"></span> view cart</button></a>
    <h1>Products</h1>      
    <p>All the available products in our store</p>
  </div>
</div>
<br><br>
<div class="container">    
  <div class="row">
   <c:forEach items="${productList}" var="product" >
  
    <div class="col-sm-3">
      <div class="card">
      <br>
        <p> <h3><strong>${product.name}</strong></h3></p>
		<img src="res/product_image/${product.image}" alt="${product.image}" style="width:100%; padding:10px;">       
        <p class="description"> ${fn:substring(product.description, 0, 75)}...</p>
        <p class="price">${product.price} $</p>
		<p class="quantity">${product.qty} units in stock</p>
        <p><c:url value="/product-detail?id=${product.id}" var="detail"/>
									<a href="${detail}"><button type="button" class="btn btn-primary"><span class="glyphicon glyphicon-info-sign"></span> Detail</button></a>
		    <c:url value="/add-cart?idP=${product.id}" var="addtoCart1"/>
									<a href="${addtoCart1}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a>
		    <!--    <p><c:url value="/add-cart?idP=${product.id}" var="addtoCart1"/>
									<a href="${addtoCart1}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a>
			 <c:url value="/addtocart?productId=${product.id}" var="addtoCart"/>
									<a href="${addtoCart}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a> 
		     
		       <p><c:url value="/add-cart?idP=${product.id}" var="addtoCart1"/>
			<a class="add-to-cart" href="${addtoCart1}"><button type="button" class="btn btn-warning"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</button></a>
			 -->
		</p>
									
		<br>
      </div>
    </div>

     </c:forEach>
    
  </div>
  <br>
  <br>
  
</div><br><br>
<!-- 
  <script>
	function displayLimitDescriptionProduct() {
	  var str = $('#description').html();
	  var res = str.substr(0, 24);
	  document.getElementById("description").innerHTML = res+"...";
	}
	</script>
	
	<script>
	function displayLimitDescriptionProduct() {
		var str = $('.description').html();
		  var res = str.substr(0, 24);
	  var x = document.getElementsByClassName("description");
	  var i;
	  for (i = 0; i < x.length; i++) {
	    x[i].innerHTML = res+"...";
	  }
	}
	</script>
	-->
</body>
</html>
