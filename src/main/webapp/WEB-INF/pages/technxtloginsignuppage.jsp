<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

</head>
<body class="cbody-wrapper">

       <%@ include file="technxt-navbar.jsp" %>
    
    <!-- Loginpage Banner Start  -->
    <div class="container-fluid loginpage-banner">
    	<img src="resources\images\carousel\placeholder-3840x1260.png" alt="Mouse" class="img-responsive">
     </div>
     <!-- Loginpage Banner End  -->
	
	<c:if test="${message==1}">
    <div class="container-fluid row">
    <br><br>
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
     <div class="alert alert-danger alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    ${message2}
    </div>
  </div>
  </div>
  </c:if>  
 
  
    <c:if test="${message==0}">
    <div class="container-fluid row">
    <br><br>
    <div class="col-sm-3"></div>
    <div class="col-sm-6">
     <div class="alert alert-danger alert-dismissable fade in">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
    <strong>Error!</strong>       Login failed...Try again..
    </div>
  </div>
  </div>
  </c:if>
	
	
	 <c:if test="${errormsg==1}">   
 <br>
 Error - Login failed...
 </c:if>
 
 
	<div class="page-wrapper">
	<div class="container-fluid">
	<div class="row">
	<div class="col-md-6">
		<div class="login-wrapper">
		<h6 class="loginpage-title">
				Registerd Customers
				</h6>
			<%--  <form:form commandName="customerobject" method="POST" action="customerloginvalidate">
			<div class="l-box">
				
					 <p>If you have an account with us, Please log in.</p>
                     	<form:input path="customerdetails.cus_loginid" placeholder="User Id" />
                        <form:password path="customerdetails.cus_password" placeholder="Password" />
                        <p><small><a href="#">Forgot our password?</a></small></p>
                         <form:button class="btn btn-default btn-custom" >login</form:button>
				
			</div>
			</form:form> --%>
			
			<form name="loginform" action="<c:url value="/j_spring_security_check"></c:url>" method="POST">
				<div class="l-box">
					<input type="text" name="j_username" placeholder="User Id"/>
					<input type="password" name="j_password" placeholder="Password" />
					<p><small><a href="#">Forgot our password?</a></small></p>
					<input type="submit" class="btn btn-default btn-custom" value="Login" />
				</div>	
			</form>
		</div>
	</div>
	<div class="col-md-6">
		<div class="signup-wrapper">
		 <c:if test="${userid!=null}">   
 <br>
Your user id : ${userid}
 </c:if>
			<h6 class="loginpage-title">
				New Customers
				</h6>
			 <form:form commandName="customerobject" method="POST" action="addcustomerregistertodb">
			<div class="l-box">
				
					 <p>If you don't have an account with us, Please Signup.</p>
                     	<form:input path="cus_name" placeholder="Full Name" />
                     	<form:input path="cus_emailid" placeholder="Email Id" />
                     	<form:password path="customerdetails.cus_password" placeholder="Password" />
                     	<form:input path="cus_mobileno" placeholder="Mobile Number" />
                        
						<!--  <p><small><a href="#">Forgot our password?</a></small></p> -->
                         <form:button class="btn btn-default btn-custom" type="submit">signup</form:button>
				
			</div>
			</form:form> 
		</div>
	</div>
	</div>
	</div>
	</div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="resources/js/bootstrap.min.js"></script>


</body>
</html>