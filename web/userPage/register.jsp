<%--
  Created by IntelliJ IDEA.
  User: stiles
  Date: 15/12/22
  Time: 下午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>游客注册</title>
    <jsp:include page="../headOut.jsp"/>
    <jsp:include page="./headUser.jsp"/>
</head>
<body>
<s:fielderror cssStyle="color:red"/>
<form action="userReg.action" method="post">
    <table border="1" class="table table-hover">
        <tr>
            <td>手机号:</td>
            <td><input type="text" name="user.phone" /></td>
        </tr>

        <tr>
            <td>密码:</td>
            <td><input type="password" name="user.password" /></td>
        </tr>
        <tr>
            <td>昵称:</td>
            <td><input type="text" name="user.nickname"/></td>
        </tr>
        <tr>
            <td>真实姓名:</td>
            <td><input type="text" name="user.name"/></td>
        </tr>
        <tr>
            <td>身份证号:</td>
            <td><input type="text" name="user.IDCard"/></td>
        </tr>
        <tr class="text-center">
            <td colspan="2">
                <input type="button" value="登录" class="btn btn-primary"/>
            </td>
        </tr>
        <tr class="text-center">
            <td colspan="2">
                <input type="reset" value="重置" class="btn btn-warning"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
