<%@ page import="com.nnprivate.project.common.Constants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Project - Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
    <script>
        $(document).ready(function() {
            $('#restoreForm').ajaxForm(function() {});
        });
    </script>
</head>
<body>
<c:choose>
    <c:when test="${not empty sent}">
        <section class="container">
            <div class="login">
                <h1>Email was successfully sent to "${email}"</h1>
                <p><a href="${pageContext.request.contextPath}/"/>Return back</a></p>
            </div>
        </section>
    </c:when>

    <c:otherwise>
        <section class="container">
            <form id="restoreForm" action="${pageContext.request.contextPath}<%=Constants.RESTORE_PASSWORD + "/" + Constants.SEND_RESTORE_EMAIL_ACTION%>" method="post">
                <div class="login">
                    <h1>Restore password to ProjectName</h1>
                    <p><input type="text" id="email" name="email" placeholder="Enter your email here and click Restore button"></p>
                    <p class="submit"><input type="submit" name="submit" value="Restore" ></p>
                </div>
            </form>
        </section>
    </c:otherwise>
</c:choose>

</body>
</html>

