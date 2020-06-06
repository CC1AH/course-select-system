<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>录入成绩</title>

<!-- 根据课程号搜索学生列表 -->
<form action="scoreList" method="post">
<br><br><br>
	<div align='center'>
		课程号: <input type="text" name="course_id"> 
		<input type="submit" value="显示学生列表">
	</div>
</form>
<br><br><br>

<table align='center' border='1' cellspacing='0'>
	<tr>
		<td>student_ID</td>
		<td>student_name</td>
		<td>course_id</td>
		<td>course_name</td>
		<td>sec_id</td>
		<td>semester</td>
		<td>year</td>
		<td>grade</td>
		<td>编辑成绩</td>

	</tr>
		
	<c:forEach items="${gradeList}" var="takesItem" varStatus="st">
		
		<tr>
			<td>${takesItem.ID}</td>
			<td>${takesItem.stuName}</td>
			<td>${takesItem.course_id}</td>
			<td>${takesItem.courseName}</td>
			<td>${takesItem.sec_id}</td>
			<td>${takesItem.semester}</td>
			<td>${takesItem.year}</td>
			<td>${takesItem.grade}</td>
			
			<!-- 编辑成绩模块 -->
			<td>
				<form action="scoreRegistration" id="form"  method="post" > 
		 			<input type="text" name="stuID" value="${takesItem.ID}" style="display: none">  <!-- 只用作为参数传递，故不显示 -->
		 			<input required autofocus type="text" name="grade" placeholder="输入新成绩"  > 
		 			<input type="submit"  value="确定修改"> 
			 	</form> 
			</td>
			
		</tr>
	</c:forEach>
</table>

<div align='center'>
	<br>
	<br>
	<a href="teacherWelcome.html">返回主界面</a>
</div>