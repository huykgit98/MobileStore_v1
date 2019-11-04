<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Product-add</title>
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
  <c:url value="/logout" var="logout"/>
		<a href="${logout}" style="text-decoration: none; color:white">
  			<button type="button" class="btn btn-danger pull-right">logout</button>
  		</a>
    <h1>Products</h1>      
    <p>Add products</p>
  </div>
</div>
<br><br>
<div class="container">
	<h4>Add new product</h4>
	<hr style="  border: 1px solid;">
    <div class="row">
    <div class="col-sm-1">
	</div>
    <div class="col-sm-5">
    <!--
	<c:url value="/admin/product-add" var="insertProduct"/>   
	<form class="form-inline" method="POST" action="${insertProduct}">
        <hr/>
        <div class="container">
            <div class="row">
                <p style="color: red;" class="col-xs-12">${errorString}</p>
            </div>
            <div class="row">
                <label class="col-xs-3">Product Name</label>
                <input type="text" class="col-xs-9" name="name">
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Unit Price</label>
                <input type="text" class="col-xs-9" name="price">
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Units in stock</label>
                <input type="number" class="col-xs-9" name="stock" placeholder="0">
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Category</label>
                <select name="category" class="form-control">
					<c:forEach items="${listCategories}" var="category">
					<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
                
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Description</label>
                <textarea class="col-xs-9" rows="2" name="desc"></textarea>
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Manufacturer</label>
                <input type="text" class="col-xs-9" name="manufacturer">
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Condition</label>
                <div class="col-xs-9">
                    <label class="radio-inline"><input type="radio" name="condition" value="New">New</label>
                    <label class="radio-inline"><input type="radio" name="condition" value="Old">Old</label>
                    <label class="radio-inline"><input type="radio" name="condition" value="Refurbished">Refurbished</label>
                </div>
            </div>
            <br/>
            <div class="row">
                <label class="col-xs-3">Product Image File</label>
                <input type="file" accept="image/*" name="img" class="col-xs-9" id="file">
                
            </div>
            <br/>
            <div class="col-xs-3">
                <button type="submit" class="btn btn-primary">Add product</button>
            </div>
        </div>
    </form>-->
	 
	
	 	<c:url value="/admin/product-add" var="insertProduct"/>   
	 	<form class="form-horizontal" action="${insertProduct}" method="post">
	 	<div class="row">
                <p style="color: red;" class="col-xs-12">${errorString}</p>
            </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="product_name">Product Name:</label>
	      <div class="col-sm-8">
	        <input type="text" class="form-control" id="product_name" required name="productName">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="unit_price">Unit Price:</label>
	      <div class="col-sm-8">
	        <input type="text" class="form-control" id="unit_price" required name="price" value="0">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="units_in_stock">Units In Stock:</label>
	      <div class="col-sm-8">
	        <input type="number" class="form-control" id="units_in_stock" required name="units_in_stock" value="0">
	      </div>
	    </div>
	    <div class="form-group">
		 <label class="control-label col-sm-4" for="description">Description:</label>
	      <div class="col-sm-8">
                <textarea class="col-xs-9" required rows="2" name="description"></textarea>
	      
	      </div>
	      </div>
		
		
		
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="manufacturer">Manufacturer:</label>
	      <div class="col-sm-8">
	        <input type="text" class="form-control" required id="manufacturer" name="manufacturer" value="">
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="category">Category:</label>
	      <div class="col-sm-8">
			<select name="category" class="form-control">
					<c:forEach items="${listCategories}" var="category">
					<option value="${category.id}">${category.name}</option>
					</c:forEach>
				</select>
	      </div>
	    </div>
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="condition">Condition:</label>
	      <div class="col-sm-8">
			<label class="radio-inline"><input type="radio" name="condition" checked value="New">New</label>
			<label class="radio-inline"><input type="radio" name="condition" value="Old">Old</label>
			<label class="radio-inline"><input type="radio" name="condition" value="Refurbished">Refurbished</label>	      
			</div>
	    </div>
	    
	    <div class="form-group">
	      <label class="control-label col-sm-4" for="product_image_file">Product Image File:</label>
	      <div class="col-sm-8">
                <input type="file" accept="image/*" required name="image" class="col-xs-9" id="file">
			<!--  	<input type="file" name="file" size="60" />-->
    			
	      </div>
	    </div>
	    <div class="form-group">        
	      <div class="col-sm-offset-4 col-sm-8">
	        <button type="submit" class="btn btn-primary">Add Product</button>
	      </div>
	    </div>
	  </form>
	    
	</div>	
	<div class="col-sm-6">
	</div>
	
	</div>
</div>

<br><br>



</body>
</html>