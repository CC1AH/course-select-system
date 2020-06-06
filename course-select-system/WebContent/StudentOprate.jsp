
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>学生信息操作</title>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>sID</td>
        <td>name</td>
        <td>dept_name</td>
        <td>tot_cred</td>
       
    </tr>

    <c:forEach items="${studentList}" var="student" varStatus="st">
        <tr>
            <td>${student.sID}</td>
            <td><a href="editStudentName?sID=${student.sID}&name=${student.name}">${student.name}</a></td>
            <td><a href="editStudentDept_name?sID=${student.sID}&dept_name=${student.dept_name}">${student.dept_name}</a></td>
            <td><a href="editStudentTot_cred?sID=${student.sID}&tot_cred=${student.tot_cred}">${student.tot_cred}</a></td>

        </tr>
    </c:forEach>
</table>

<div align='center'><a href="adminWelcome.html">返回主界面</a></div>