<%--
  Created by IntelliJ IDEA.
  User: wyz_Sayonare
  Date: 2017/10/8
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>PersonUpdate</title>

</head>
<body>
    <!-- 其中，modelAttribute 属性用于接收设置在model中的对象,必须设置，否则会报500错误 -->
    <sf:form enctype="multipart/form-data"
             action="${pageContext.request.contextPath}/person/updatePersonList.action"
             modelAttribute="p"
             method="post">


        <!-- 添加隐藏域,隐藏id -->
        <sf:hidden path="id"/>

        <div style="padding: 20px">
            修改人员信息
        </div>

        <div>
            错误信息：<fond    color="red"><sf:errors path="*"/></fond>
        </div>
        <table>
            <tr>
                <td>姓名</td>
                <td><sf:input path="name"/><sf:errors path="name"/> </td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><sf:input path="age"/></td>
            </tr>
            <tr>
                <td>图片</td>
                <td><input type="file" name="photo"  value=""></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" name="btnOK"   value="保存"/></td>
            </tr>
        </table>

    </sf:form>

</body>
</html>
