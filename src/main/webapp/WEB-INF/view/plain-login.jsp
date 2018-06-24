<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
<h1>My Login Page</h1>
<div>
   <form:form  action="${pageContext.request.contextPath}/authenticateTheUser"  method="POST" >
   <c:if test="${param.error!=null}">
     <i>Sorry, You entered invalid username/password</i>
   </c:if>
    <div><label>User Name:</label> <input type="text" name="username"/></div>
    <div><label>Password:</label><input type="text" name="password" /></div>
     <input type="submit" value="Login" />    
   </form:form>
</div>
</body>


</html>