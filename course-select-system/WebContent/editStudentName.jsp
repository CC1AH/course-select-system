<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div style="margin:50px auto; width:300px">
    <form action="updateStudentItem" method="post">
    
        name:&nbsp;&nbsp;<input name="name" value="${studentItem.name}"> <br>

        <br>

        <input type="hidden" name = "sID" value="${studentItem.sID}">
        <input type="hidden" name = "dept_name" value="${studentItem.dept_name}">
         <input type="hidden" name = "tot_cred" value="${studentItem.tot_cred}">
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">
    </form>

</div>