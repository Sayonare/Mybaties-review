<%--
  Created by IntelliJ IDEA.
  User: wyz_Sayonare
  Date: 2017/10/7
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PersonCreate</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/person/updatePersonList.action" method="post">
        <div style="padding: 20px">
            新增人员列表
        </div>

        <table>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="name" value=""></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value=""></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="btnOK" value="保存"></td>
            </tr>
        </table>
    </form>

</body>
</html>
