
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>学生课程显示信息操作</title>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>studentID</td>
        <td>course_id</td>
        <td>sec_id</td>
        <td>semester</td>
        <td>year</td>
        <td>grade</td>
    </tr>

    <c:forEach items="${tekesList}" var="tekesItem" varStatus="st">
        <tr>
            <td>${tekesItem.ID}</td>
            <td>${tekesItem.course_id}</td>
            <td>${tekesItem.sec_id}</td>
            <td>${tekesItem.semester}</td>
            <td>${tekesItem.year}</td>
      		<td>${tekesItem.grade}</td>
        </tr>
    </c:forEach>
</table>

<div align='center'><a href="LoginInChosen.html">返回登录界面</a></div>