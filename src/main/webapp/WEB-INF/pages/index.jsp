<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
    <head>
        <title>TestTitle</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    </head>

    <form method="POST" action="<c:url value='j_spring_security_check' />" >
        <table style="margin-left: 42%">
            <tr>
                <td><label for="j_username">Email</label></td>
                <td><input type="text" name="j_username" id="j_username" /></td>
            </tr>
            <tr>
                <td><label for="j_password">Password</label></td>
                <td><input type="password" name="j_password" id="j_password" /></td>
            </tr>
            <tr>
                <td><input type="submit" value="Войти"/></td>
            </tr>
        </table>
    </form>
</html>
