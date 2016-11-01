<%--
  Created by IntelliJ IDEA.
  User: L'Accordeur
  Date: 2016/10/27
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>内容列表页面</title>
    <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>resources/css/feedback.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>resources/css/index.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>resources/css/banner.css" rel="stylesheet" type="text/css" />
    <script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
    <script src="<%= basePath %>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="/addCommandServlet.action?type=add" id="mainForm" method="post">
    <div class="right">
        <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容新增</div>
        <div class="rightCont">
            <div class="zixun fix">
                <table id="table"class="tab2" width="100%">
                    <tbody id="tbody">
                    <%--<tr>
                        <th></th>
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

                    </c:forEach>--%>
                    <tr style="background-color:#ECF6EE;">
                        <td>指令名称</td><td><input name="name" style="width:100px;height:25px" /></td>
                    </tr>
                    <tr style="background-color:#ECF6EE;">
                        <td>描述</td><td><input name="description" style="width:100px;height:25px" /></td>
                    </tr>
                    <tr style="background-color:#ECF6EE;">
                        <td>内容</td><td><textarea type="text" name="content" style="resize: none;height:60px;width:500px;" class="allInput" ></textarea></td>
                    </tr>

                    </tbody>
                </table>
                <%--<div>
                    <input type="button" onclick="addTextArea()" value="添加"/>
                </div>--%>
                <%--<div class="submit-btn-container">
                    <input class="btn btn-default" type="button" value="添加" onclick="addTextArea()" /></a>
                </div>
                <div class="submit-btn-container">
                    <input class="btn btn-default" type="submit" value="提交" /></a>
                </div>--%>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td height="34" align="right" valign="middle" colspan="4" >
                            <input type="button" value="添加" onclick="addTextArea()" tabindex="4" style="border-width:0;width:85px;height:40px;cursor:pointer;margin-right:30px;"  />
                        </td>
                        <td width="50%"  height="34" colspan="4" align="left" valign="middle" >
                            <input type="submit" value="提交" tabindex="4" style="border-width:0;width:85px;height:40px;cursor:pointer;margin-right:30px;"  />
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
<script>

    function addTextArea(){
        var html = '<tr style="background-color:#ECF6EE;">'+
                '<td>内容</td><td><textarea type="text" name="content" style="resize: none;height:60px;width:500px;" class="allInput"></textarea></td>'+
                '</tr>';
        document.getElementById('tbody').innerHTML += html;
    }
</script>
</html>