
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>开设课程详细信息</title>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>course_id</td>
        <td>sec_id</td>
        <td>semester</td>
        <td>year</td>
        <td>building</td>
        <td>room_no</td>
        
    </tr>

    <c:forEach items="${sections}" var="section" varStatus="st">
        <tr>
            <td>${section.course_id}</td>
            <td>${section.sec_id}</td>
            <td>${section.semester}</td>
            <td>${section.year}</td>
            <td>${section.building}</td>
            <td>${section.room_no}</td>
        </tr>
    </c:forEach>
</table>

<div align='center'><a href="adminWelcome.html">返回主界面</a></div>