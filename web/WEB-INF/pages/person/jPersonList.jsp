<%--
  Created by IntelliJ IDEA.
  User: wyz_Sayonare
  Date: 2017/10/7
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>PersonList</title>

    <script  language="JavaScript">
        /**
         *
         * @discription 批量提交方法
         * */
        function  deleteMuch() {
            var values= document.getElementById("ids");
            document.forms[0].action="${pageContext.request.contextPath}/person/deleteMuch.action";
            if(values.checked==false)
            {
                alert("请选中你要删除的列表项");
            }
            else {

                document.forms[0].submit();   <!-- 手动提交  -->
            }
        }
    </script>
</head>
<body  style="align-content: center">

    <form action="${pageContext.request.contextPath}/personform.action" method="post">

        <div style="padding: 20px">人员列表</div>

        <div style="padding-left: 40px; padding-bottom: 10px" >
            <a href="/springmvc-new/person/toCreatePersonInfo.action">新增</a>   <!-- 跳转路径 -->
            <a href="#" onclick="deleteMuch()">批量删除</a>    <!-- 调用javascript-->
        </div>
        <table border="1" style="border-bottom: hidden";>
            <tr>
                <td>选择</td>
                <td>头像</td>
                <td>编号</td>
                <td>姓名</td>
                <td>年龄</td>
            </tr>
            <c:forEach items="${personList}" var="p">
            <tr>
                <td><input type="checkbox" id="ids" name="id" value="${p.id}"></td>
                <td><img src="${pageContext.request.contextPath}${p.photoPath}"></td>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.age}</td>
                <td><a href=/springmvc-new/person/toUpdatePersonInfo.action?id=${p.id}>修改</a></td>
                <td><a href=/springmvc-new/person/deleteById.action?id=${p.id}>删除</a></td>
            </tr>
            </c:forEach>

        </table>

    </form>

</body>
</html>
