<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div style="margin:50px auto; width:300px">
    <form action="updateinstructorItem" method="post">
    
        tot_cred:&nbsp;&nbsp;<input name="salary" value="${InstructorItem.salary}"> <br>

        <br>

        <input type="hidden" name = "tID" value="${InstructorItem.tID}">
        <input type="hidden" name = "name" value="${InstructorItem.name}">
        <input type="hidden" name = "dept_name" value="${InstructorItem.dept_name}">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">
    </form>

</div>