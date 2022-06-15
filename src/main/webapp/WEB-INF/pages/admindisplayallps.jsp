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
 	 <!--  Data Table Search and Sort Css Plugin -->
    <link href="resources/css/dataTables.bootstrap.min.css" rel="stylesheet">
	
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
                                    <h5>Products-Suppliers List </h5> 
                        </div>
                        <div class="ibox-content">
                                   <div>
                                      <div class="table-responsive">
									    <table class="table table-bordered table-hover" id="tablesortsearch">
									      <thead>
									        <tr>
						          <th>#</th>
						          <th>XPS Id</th>
						          <th>Product Id</th>
						          <th>Product Image</th>
						          <th>Supplier Id</th>
						          <th>Supplier Image</th>
						          <th>XPS Price </th>
						          <th>XPS Stock </th>
						          <th>Is Available</th>
						          <th>Options</th>
						        </tr>
						      </thead>
						      <% int i = 1; %> 
						      <tbody>
						       <c:forEach var="xps" items="${xpslist}">
									<tr>
									<th scope="row"><%= i %> <% i++; %></th>
									<td>${xps.xps_id}</td>
									<td>${xps.product.product_id}</td>
									<td><img src="resources/images/products/${xps.product.product_id}.png" height="60px" width="80px" class="img-responsive"></td>
									<td>${xps.supplier.supplier_id}</td>
									<td><img src="resources/images/suppliers/${xps.supplier.supplier_id}.png" height="60px" width="80px" class="img-responsive"></td>
									<td>${xps.xps_price}</td>
									<td>${xps.xps_stock}</td>
									<td>${xps.xps_isenabled}</td>
									<td><a href="adminreqtoeditxps?xps_id=${xps.xps_id}" class="btn btn-primary"><i class="fa fa-pencil" aria-hidden="true"></i></a> <a href="adminreqtodeletexps?xps_id=${xps.xps_id}" class="btn btn-primary"><i class="fa fa-trash" aria-hidden="true"></i></a>
									</td>
									</tr>
								</c:forEach>
						       </tbody>
									    </table>
									  </div>
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
    
   <!--  Data Table Search and Sort Plugin Javascripts -->
	<script src="resources/js/jquery.dataTables.min.js"></script>
    <script src="resources/js/dataTables.bootstrap.min.js"></script>
    
     <!-- Side Nav Menu Toggle Script -->
    <script src="resources/js/tgjs.js"></script>
    
    <!--  Data Table Search and Sort Plugin Javascript -->
   <script>
   $('#tablesortsearch').DataTable();
   </script>
  </body>
</html>