<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>教师课表信息</title>


<table align='center' border='1' cellspacing='0'>
<br><br>
    <tr>
        <td>teacherID</td>
        <td>course_id</td>
        <td>sec_id</td>
        <td>semester</td>
        <td>year</td>

    </tr>
    
   <c:forEach items="${teachesList}" var="teachesItem" varStatus="st">
         <tr>
            <td>${teachesItem.ID}</td>
            <td>${teachesItem.course_id}</td>
            <td>${teachesItem.sec_id}</td>
            <td>${teachesItem.semester}</td>
            <td>${teachesItem.year}</td>
            
        </tr>
    </c:forEach>
</table>


<br><br><br>
<div align='center'><a href="adminWelcome.html">返回主界面</a></div>