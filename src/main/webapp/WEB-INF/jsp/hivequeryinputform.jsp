<%--
  Created by IntelliJ IDEA.
  User: RDESAI2
  Date: 10/17/13
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hive query input form</title>
</head>
<body>

<form action="hive-query-launcher" method="POST">
    <table>

        <tr>
            <td>Hive Query: <input type="text" maxlength="5000" id="hiveQuery" name="hiveQuery"></td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</form>

</body>
</html>