
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>教师信息操作</title>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>tID</td>
        <td>name</td>
        <td>dept_name</td>
        <td>salary</td>
       
    </tr>

    <c:forEach items="${instructorList}" var="instructor" varStatus="st">
        <tr>
            <td>${instructor.tID}</td>
            <td><a href="editInstructorName?tID=${instructor.tID}&name=${instructor.name}">${instructor.name}</a></td>
            <td><a href="editInstructorDept_name?tID=${instructor.tID}&dept_name=${instructor.dept_name}">${instructor.dept_name}</a></td>
            <td><a href="editInstructorSalary?tID=${instructor.tID}&salary=${instructor.salary}">${instructor.salary}</a></td>
		
        </tr>
    </c:forEach>
</table>

<div align='center'><a href="adminWelcome.html">返回主界面</a></div>