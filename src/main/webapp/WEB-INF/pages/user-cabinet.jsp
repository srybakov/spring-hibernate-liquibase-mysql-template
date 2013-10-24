<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Project - UserCabinet</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css">
</head>
<body>
    <section class="container">
        <h4>There are your current credentials</h4>
        <label>Email: ${email}</label></br>
        <label>Created: ${created}</label></br>
    </section>
</body>
</html>

