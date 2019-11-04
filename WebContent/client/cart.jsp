<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Cart</title>
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
	
    .table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
  </style>
</head>
<body>

<div class="jumbotron">
  <div class="container text-left">
    <h1>Cart</h1> 
    <p>All the selected products in your cart</p>     
  </div>
</div>
<br><br>
<div class="container">    

		<div class="container">
		<button type="button" class="btn btn-danger"><span class="glyphicon glyphicon-remove-sign"></span> Clear Cart</button>
		<button type="button" class="btn btn-success pull-right"><span class="glyphicon glyphicon-shopping-cart"></span> Checkout</button>
				
			<table id="cart" class="table table-hover table-condensed">
		    				
		    				<thead>
								<tr>
								
									<th style="width:50%">Product</th>
									<th style="width:8%">Quantity</th>									
									<th style="width:10%">Unit Price</th>
									<th style="width:22%" class="text-center">Price</th>
									<th style="width:10%">Action</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${order.items}" var="item">
								<tr>
									<td data-th="Product">
										<div class="row">
											<!--  <div class="col-sm-2 hidden-xs"><img src="res/product_image/${product.image}" alt="${item.product.name}" class="img-responsive"/></div>-->
											<div class="col-sm-10">
												<h4 class="nomargin">${item.product.name}</h4>
											</div>
										</div>
									</td>
								
									<td data-th="Quantity">
										${item.qty}									
									</td>
									<td data-th="Price">${item.price}</td>
									<td data-th="Subtotal" class="text-center">${(item.price*item.qty)}</td>
									<td class="actions" data-th="">
									<a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath }/remove-cart-item?id=${item.product.id }"
					onclick="return confirm('Are you sure?')"><span class="glyphicon glyphicon-remove-circle"></span> Remove</a>
									
									</td>
								</tr>
								</c:forEach>
							</tbody>
							<tfoot>
								<tr class="visible-xs">
									<td class="text-center"><strong>Grand Total 1.99</strong></td>
								</tr>
								<tr>
							
								
									<td><a href="/MobileStore_v1/" class="btn btn-success"><span class="glyphicon glyphicon-circle-arrow-left"></span> Continue Shopping</a></td>
									<td colspan="2" class="hidden-xs"></td>
									<td class="hidden-xs text-center"><strong>Grand Total ${order.getTotal()}</strong></td>
								
								</tr>
							</tfoot>
						</table>
		</div>

    
</div><br><br>
<!-- <div class="col-sm-5">
	        <img class="img-responsive" src="res/product_image/huawei-p30-pro-1.png" alt="huawei-p30-pro-1.png" width="460" height="345"> 
	    </div>-->

</body>
</html>
