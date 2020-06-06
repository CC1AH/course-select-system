
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>现已开设课程信息</title>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>course_id</td>
        <td>title</td>
        <td>dept_name</td>
        <td>credits</td>
       
    </tr>

    <c:forEach items="${courses}" var="course" varStatus="st">
        <tr>
            <td>${course.course_id}</td>
            <td>${course.title}</td>
            <td>${course.dept_name}</td>
            <td>${course.credits}</td>
        </tr>
    </c:forEach>
</table>

<div align='center'><a href="adminWelcome.html">返回主界面</a></div>