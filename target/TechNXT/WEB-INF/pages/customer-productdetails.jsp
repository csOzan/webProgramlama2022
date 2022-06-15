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
    <link href="resources/css/customercss.css" rel="stylesheet">
    <link href="resources/css/technxtcustomer.css" rel="stylesheet">
    <!-- Awesome Font -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">

</head>
<body class="cbody-wrapper">
     <%@ include file="customer-navbar.jsp" %>
    
    <section class="productmainwrapper">
    	 <div class="container-fluid">
    		<div class="row">
    			<div class="col-sm-5 col-xs-12">
    				<div class="productimagewrapper">
    					<div class="">
    					<img class="" src="resources/images/products/${product_id}.png">
    					</div>
    				</div>
    			</div>
    			<div class="col-sm-7 col-xs-12">
	    			<div class="productcontantwrapper">
	    			 		<div class="row">
				
				<div class="col-xs-12">
					<div class="box-productheader">
						<h4> Product Details
						</h4>
					</div>
					<div class="col-xs-12">
					<div class="box-productcontent">
					
						Product Name : ${product_name} <br />
						Product Price : Rs.${xps_price} <br />
						Quantity :<form action="customerreqAddItemToCart/${xps_id}">
					  <select name="qty" id="qty">
			      	<option value="1">1</option>
			      	<option value="2">2</option>
			      	<option value="3">3</option>
			      	<option value="4">4</option>
			      	<option value="5">5</option>
			      		
			      	</select>
					<button type="submit" class="btn btn-primary btn-"> 
			         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
			         </button>  
				 </form>
					</div>
					</div>
				</div>
				<div class="col-xs-12">
					<div class="box-productheader">
						<h4> Product Description 
						</h4>
					</div>
					<div class="col-xs-12">
					<div class="box-productcontent">
					 ${product_desc}
					</div>
					</div>
				</div>
				<div class="col-xs-12">
					<div class="box-productheader">
						<h4> Sellers
						</h4>
					</div>
					<div class="col-xs-12">
					<div class="box-productcontent">
					 <c:forEach var="vw" items="${vwpidlist}">
						<br>
							Supplier Name : ${vw.supplier.supplier_name} <br>
							Price : Rs.${vw.xps_price} <br>
							Quantity :<form action="customerreqAddItemToCart/${xps_id}">
										  <select name="qty" id="qty">
								      	<option value="1">1</option>
								      	<option value="2">2</option>
								      	<option value="3">3</option>
								      	<option value="4">4</option>
								      	<option value="5">5</option>
								      		
								      	</select>
										<button type="submit" class="btn btn-primary btn-large" > <!-- ng-click="addItemToCart()" -->
								         <span class="glyphicon glyphicon-shopping-cart"></span>Add to cart
								         </button>  
									 </form>
						</c:forEach> 
					</div>
					</div>
				</div>
				
				
				</div>
	    			</div>
    			</div>
    			
    		</div>
		</div>    
	</section>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>


</body>

</html>