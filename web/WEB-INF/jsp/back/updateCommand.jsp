<%@ page import="com.guoyang.bean.Command" %>
<%@ page import="java.util.List" %>
<%@ page import="com.guoyang.bean.CommandContent" %><%--
  Created by IntelliJ IDEA.
  User: L'Accordeur
  Date: 2016/10/14
  Time: 20:33
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
  <title>内容更新页面</title>
  <link href="<%=basePath%>resources/css/all.css" rel="stylesheet" type="text/css" />
  <script src="<%= basePath %>resources/js/common/jquery-1.8.0.min.js"></script>
  <script src="<%= basePath %>resources/js/back/list.js"></script>
</head>
<body style="background: #e1e9eb;">
<form action="<%=basePath%>updateCommandServlet.action?type=goCommit" id="mainForm" method="post">
  <div class="right">
    <%
      Command commandResponse = (Command) request.getAttribute("commandList");
      List<CommandContent> commandContents = (List<CommandContent>) request.getAttribute("commandContents");
    %>
    <div class="current">当前位置：<a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a> &gt; 内容修改</div>
    <div class="rightCont">
      <div class="zixun fix">
        <table class="tab2" width="100%">
          <tbody>
          <tr>
            <th>ID</th>
            <th>指令名称</th>
            <th>描述</th>
            <th>内容</th>
          </tr>
          <%--<c:forEach items="${commandList}" var="command" varStatus="status" >--%>
          <%--<c:if test="${status.index % 2 != 0}">--%>
            <tr style="background-color:#ECF6EE;">
                <input type="hidden" name="commandID" class="allInput" value="<%=commandResponse.getId()%>"/>
              <td>
                <%=commandResponse.getId()%>
              </td>
              <td>
                <input type="text" name="commandName" class="allInput" value="<%=commandResponse.getName()%>"/>
              </td>
              <td>
                <input type="text" name="commandDescription" class="allInput" value="<%=commandResponse.getDescription()%>"/>
              </td>
              <td>
                <c:forEach items="${commandContents}" var="content"  >
                  <input type="hidden" name="commandCOntentID" value="${content.id}">
                  <textarea type="text" name="commandContent" style="resize: none;height:60px;width:500px;" class="allInput" >${content.content}</textarea><br/><br/>
                  <%--<input type="text" name="commandContent" class="allInput" value="${content.content}"/><br/>--%>
                </c:forEach>
              </td>
            </tr>



          <%--</c:forEach>--%>


          </tbody>
        </table>
        <br/>
        <input type="submit" value="提交更新" class="allInput"/>
      </div>
    </div>
  </div>
</form>
</body>
</html>

