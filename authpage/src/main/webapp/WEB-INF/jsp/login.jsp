<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login page</title>
</head>
<body>
<form name='loginForm' action='${action}' method='get'>
    <table>
        <tr>
            <td>userName:</td>
            <td><input type='text' name='userName' value='${aclion}'></td>
        </tr>
        <tr>
            <td>password:</td>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
        </tr>
    </table>
</form>
</body>
</html>