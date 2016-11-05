<%--
  Created by IntelliJ IDEA.
  User: L'Accordeur
  Date: 2016/10/27
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible"content="IE=9; IE=8; IE=7; IE=EDGE" />
    <title>内容更新页面</title>
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
    <script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%= basePath %>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="<%=basePath%>updateCommandServlet.action" id="mainForm" method="post">
    <div class="right">
        <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容修改</div>
        <div class="rightCont">
            <div class="zixun fix">
                <table class="tab2" width="100%">
                    <tbody>
                    <tr>
                        <th><input type="checkbox" id="all" onclick="#"/></th>
                        <th>序号</th>
                        <th>指令名称</th>
                        <th>描述</th>
                        <th>操作</th>
                    </tr>
                    <c:forEach items="${commandList}" var="command" varStatus="status" >

                        <tr <c:if test="${status.index % 2 != 0}">style="background-color:#ECF6EE;"</c:if>>
                            <td><input type="checkbox" name="id" value="${command.id}"/></td>
                            <td>${status.index + 1}</td>
                            <td>${command.name}</td>
                            <td>${command.description}</td>
                            <td>
                                <a href="${basePath}updateCommandServlet.action?id=${command.id}&type=goUpdate">修改</a>&nbsp;&nbsp;&nbsp;
                                <a href="${basePath}deleteOneServlet.action?id=${command.id}">删除</a>
                            </td>
                        </tr>

                    </c:forEach>


                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>
