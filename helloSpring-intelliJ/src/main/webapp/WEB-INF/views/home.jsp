<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p><a href="${pageContext.request.contextPath}/offers">Show Current offers</a> </p>
  <p><a href="${pageContext.request.contextPath}/createOffer">add a new offer</a> </p>

  <c:if test="${pageContext.request.userPrincipal.name != null}">

      <c:url var="logoutUrl" value="/logout"/>

      <form class="form-inline" action="${logoutUrl}" method="post">
          <input type="submit" value="Log out" />
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      </form>

  </c:if>

  </body>
</html>
