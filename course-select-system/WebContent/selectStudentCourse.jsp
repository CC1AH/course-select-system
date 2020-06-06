<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>学生选课</title>

<!-- 查询某一门课程名 -->
<form  action="listSomeSection" method="post">
<p align='center'>查询课程</p>
<div align='center'>请输入课程名: <input type="text" name="courseTitle">
<input type="submit" value="查询课程"></div>
</form>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>course_id</td>
        <td>sec_id</td>
        <td>semester</td>
        <td>year</td>
        <td>courseName</td>
        <td>teacherName</td>
        <td>credits</td>
        <td>departname</td>
        <td>building</td>
        <td>room_no</td>
        <td>day</td>
        <td>start_time</td>
        <td>end_time</td>
        <td>选课</td>
    </tr>
    <c:forEach items="${sectionList}" var="sectionItem" varStatus="st">
        <tr>
            <td>${sectionItem.course_id}</td>
            <td>${sectionItem.sec_id}</td>
            <td>${sectionItem.semester}</td>
            <td>${sectionItem.year}</td>
            <td>${sectionItem.courseName}</td>
            <td>${sectionItem.teacherName}</td>
            <td>${sectionItem.credits}</td>
            <td>${sectionItem.departname}</td>
            <td>${sectionItem.building}</td>
            <td>${sectionItem.room_no}</td>
            <td>${sectionItem.day}</td>
            <td>${sectionItem.start_time}</td>
            <td>${sectionItem.end_time}</td>
            <td><a href="addStudentCourse?course_id=${sectionItem.course_id}&sec_id=${sectionItem.sec_id}&semester=${sectionItem.semester}&year=${sectionItem.year}">选课</a></td>
        </tr>
    </c:forEach>
</table>

<div align='center'><a href="studentWelcome.html">返回主界面</a></div>
<div align='center'><a href="listStudentCourse?name=look">查看课表</a></div>