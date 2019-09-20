<%@ page import="biz.UserBiz" %>
<%@ page import="java.util.List" %>
<%@ page import="bean.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: xuan
  Date: 2019/9/20
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" width="80%" align="center">
        <tr>
            <th>序号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
            <th>住址</th>
            <th>操作</th>
        </tr>
        <%
            UserBiz ub = new UserBiz();
            List<UserInfo> list = ub.findAllUser();
            int index = 1;
            for (UserInfo ui:list) {
                %>
                    <tr>
                        <td><%=index%></td>
                        <td><%=ui.getUserName()%></td>
                        <td><%=ui.getUserAge()%></td>
                        <td><%=ui.getUserSex()%></td>
                        <td><%=ui.getUserAddress()%></td>
                        <td>操作 修改</td>
                    </tr>
        <%
                index++;
            }
        %>
    </table>
</body>
</html>
