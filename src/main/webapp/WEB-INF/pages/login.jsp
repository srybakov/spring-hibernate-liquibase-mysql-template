<%@ page import="com.nnprivate.project.common.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Project - Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <section class="container">
        <div class="login">
            <h1>Login to ProjectName</h1>
            <c:if test="${not empty incorrectLogin}">
                <c:set var="loginFailedMessage" value="${incorrectLogin}"/>
                <h1 style="font-style: italic; color: red; font-size: small;"><c:out value="${loginFailedMessage}"/></h1>
            </c:if>
            <form method="POST" action="<c:url value='j_spring_security_check' />" >
                <p><input type="text" name="j_username" value="" placeholder="Email"></p>
                <p><input type="password" name="j_password" value="" placeholder="Password"></p>
                <p class="remember_me">
                    <label>
                        <input type="checkbox" name="remember_me" id="remember_me">
                        Remember me on this computer
                    </label>
                </p>
                <p class="submit"><input type="submit" name="submit" value="Login"></p>
            </form>
        </div>

        <div class="login-help">
            <p>Forgot your password? <a href="${pageContext.request.contextPath}<%=Constants.RESTORE_PASSWORD%>">Click here to reset it</a>.</p>
        </div>
    </section>
</body>
</html>

