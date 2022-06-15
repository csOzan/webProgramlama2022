<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title></title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Awesome Font -->
    <link href="resources/css/font-awesome.min.css" rel="stylesheet">
	
    <!-- Side Nav Style -->
    <link href="resources/css/sidenav.css" rel="stylesheet">
    
    <!-- Custom Style -->
    <link href="resources/css/tgstyles.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
	<!--   Complete Page -->
    <div id="wrapper">
    	<%@ include file="admin-sidenav.jsp" %>
    	<!-- Page Contant Wrapper -->
    	<div id="page-content-wrapper">
    	
    	<%@ include file="admin-topnav.jsp" %>
    	<!-- Page Header -->
    			<div class="container-fluid">
    				<div class="row">
    					<h1 class="page-header">Product-Supplier</h1>
    				</div>
    				<div class="row">
    				<div class="col-lg-12">
    				<div class="ibox">
                    	<div class="ibox-title">
                                    <h5> Add Product-Supplier </h5> 
                        </div>
                        <div class="ibox-content">
                                   <div>
    					<form:form commandName="xpsobj" action="adminaddxpstodb" >
    					<div class="form-group row">
						Product Name
						<div class="col-lg-10">
							<select name="productid" class="form-control">
							<c:forEach var="productlist" items="${productslist}">
							<option value="${productlist.product_id}"> ${productlist.product_name}</option>
							</c:forEach>
							</select>
						</div>
						</div>
							<div class="form-group row">
							Supplier Name
							<div class="col-lg-10">
								<select name="supplierid" class="form-control">
								<c:forEach var="supplierlist" items="${supplierslist}">
								<option value="${supplierlist.supplier_id}"> ${supplierlist.supplier_name}</option>
								</c:forEach>
								</select>
							</div>
							</div>
							 <div class="form-group row">
				    					 	<form:label path="xps_price" class="col-lg-2">XPS Price</form:label>
				    					 	<div class="col-lg-10">
				    					 		<form:input path="xps_price" placeholder="XPS price" class="form-control" />
				    					 	</div>
				    					 </div>
							<div class="form-group row">
				    					 	<form:label path="xps_stock" class="col-lg-2">XPS Stock</form:label>
				    					 	<div class="col-lg-10">
				    					 		<form:input path="xps_stock" placeholder="XPS stock" class="form-control" />
				    					 	</div>
				    					 </div>
							
							<div class="form-group row">
				    					 	<form:label path="" class="col-lg-2">Is Available :</form:label>
				    					 	<div class="col-lg-10">
				    					 		<div class="radio">
				    					 			<form:label path="xps_isenabled" class="">
				    					 				 <form:radiobutton path="xps_isenabled" value="true" id="" name="" />
				    					 				 	 True
				    					 			</form:label>
				    					 		</div>
				    					 		<div class="radio">
				    					 			<form:label path="xps_isenabled" class="">
				    					 				 <form:radiobutton path="xps_isenabled"  value="false" id="" name="" />
				    					 				 	 False
				    					 			</form:label>
				    					 		</div>
				    					 	</div>
				    					 </div>
				    					 	<form:button class="btn btn-sm btn-primary">
				    					 		<strong>Add PS</strong>
				    					 	</form:button>
						
				    					</form:form>
                                    </div>
                                    
                                   
                       	</div>
                    </div> 
    				</div>
    				</div>
    			</div>
    			<!-- End of Page Content wrapper -->
    			<%@ include file="admin-footernav.jsp" %>
   			</div>
   		<!-- End of wrapper -->
	</div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>

    <!-- Side Nav Menu Toggle Script -->
    <script src="resources/js/tgjs.js"></script>

  </body>
</html>
