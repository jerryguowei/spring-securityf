<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <title>Login Page</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
 <script  src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script  src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
  <body>
    <div class="container">
          <div id="loginbox"  style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
            <div class="panel panel-info">
             <div class="panel-heading">
             <div class="panel-title">Sign In</div>
             </div>
             <div style="padding-top:30px" class="panel-body">
             <c:if test="${param.error!=null}">
                <div id="login-alert" class="alert alert-danger col-sm-12">Password and username invalid!</div>
             </c:if>
             <c:if test="${param.logout!=null}">
             <div id="logout-alert" class="alert alert-success col-sm-12">You have been logout</div>
             </c:if>
             <form:form class="form-horizontal"  action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
            	<div style="margin-bottom: 25px" class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span> 
							<input type="text" name="username" placeholder="username" class="form-control">
			    </div>
			    <div style="padding-top:10px" class="input-group">
			      <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
			      <input type="password" name="password" placeholder="password" class="form-control">
			    </div>
			    <div style="margin-top:15px" class="form-group">
                     <div class="col-sm-12 controls">
                     <button type="submit"  class="btn btn-success">Login </button>
                    </div>
                </div>
             </form:form>
             </div>
            </div>
          </div>
    </div> 
  </body>

</html>