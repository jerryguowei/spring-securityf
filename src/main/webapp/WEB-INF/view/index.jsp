<%@ taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <title>Home Page</title>
 <meta charset="utf-8">
 <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
 <script  src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
 <script  src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
  <body>
  <h2>Spring Security Home Page</h2>
  User:  <security:authentication property="principal.username"/>
  Roles:  <security:authentication property="principal.authorities"/>
   <form:form action="${pageContext.request.contextPath}/logout" method="POST">
   <input  type="submit" class="btn btn-success" value="Logout" />
<%--    <input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
 --%>  </form:form>
  <hr/>
  <security:authorize access="hasRole('MANAGER')">
  Manager visit: <a href="${pageContext.request.contextPath}/leaders">Manager Link</a>
  </security:authorize>
   </body> 
  </html>
