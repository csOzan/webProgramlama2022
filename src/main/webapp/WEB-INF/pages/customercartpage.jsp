<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>TechNXT | Laptops, Mouse, Keyboard and Other Accessories</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
     	 <!--  Data Table Search and Sort Css Plugin -->
    <link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
    
    <link href="resources/css/customercss.css" rel="stylesheet">
        <link href="resources/css/technxtcustomer.css" rel="stylesheet">
    <!-- Awesome Font -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">

</head>
<body class="cbody-wrapper">
<div id="page-content-wrapper">

	<!-- Page Contant Wrapper -->
	<%@include file="customer-navbar.jsp" %>
	
		<div class="container-fluid">
    		<div class="row">
    			<div class="col-md-12 col-xs-12">
	    			<div class="cuspageheader">
	    				<h4> My Cart (${cartsize})</h4>
	    					
	    			</div>
	    			<div class="cuspageproductscontainer">
	    				<div class="">
	    				<c:forEach var="cartitem" items="${cartitems}">
	    					<div class="row">
	    						<div class="col-xs-2 col-md-2 col-lg-3">
	    							<img src="resources/images/products/${cartitem.xmap_ps.product.product_id}.png" height="120px" width="150px" />
	    						</div>
	    						<div class="col-xs-10 col-md-10 col-lg-9">
	    						<div class="row">
	    							<div class="col-xs-12">
	    								<h6>${cartitem.xmap_ps.product.product_name}</h6>
	    							</div>
	    							<div class="col-xs-12">
	    								Seller : ${cartitem.xmap_ps.supplier.supplier_name}
	    							</div>
	    							<div class="col-xs-4">
	    								Quantity
	    							</div>
	    							<div class="col-xs-4">
	    								Price 
	    							</div>
	    							<div class="col-xs-4">
	    								Total Price
	    							</div>
	    							<div class="col-xs-4">
	    								${cartitem.cus_cartquantity}
	    							</div>
	    							<div class="col-xs-4">
	    								Rs. ${cartitem.xmap_ps.xps_price} 
	    							</div>
	    							<div class="col-xs-4">
	    								Rs. ${cartitem.cus_cartitemwisetotal}
	    							</div>
	    							<div class="col-xs-6">
	    								<a href="#" class="btn btn-info btn-default">Remove from cart</a>
	    							</div>
	    						</div>
	    							
	    							 
	    						</div>
	    					</div>
	    				</c:forEach>
	    				</div>
	    				<div class="" style="margin-top:20px">
	    					<div class="row">
	    						<div class="col-xs-2 col-md-2 col-lg-3">
	    						
	    						</div>
	    						 <div class="col-xs-10 col-md-10 col-lg-9">
	    						 	<div class="col-xs-4">
	    						 	<a href="#" class="btn btn-danger btn-default ">Clear Cart</a>
	    						 	</div>
	    						 	<div class="col-xs-4">
	    						 	Grand Total : Rs.${grandtotal}
	    						 	</div>
	    						 	<div class="col-xs-4">
	    						 	<a href="#" class="btn btn-success btn-default ">Check Out</a>
	    						 	</div>
	    						 	
	    						 </div>
	    						
	    					</div>
	    				</div>
	    			</div>
    			</div>
			</div>
		</div>
 </div>


<br><br>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>
</body>
</html>