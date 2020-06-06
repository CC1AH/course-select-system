<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>修改密码</title>

<script type="text/javascript"> 
  function check(form) { 
    with (form) { 
      if (teaID.value == "") { 
        alert("账号不能为空"); 
        return false; 
      }   
      if (oldPassword.value == "") { 
          alert("旧密码不能为空"); 
          return false; 
        } 
      if (newPassword1.value == "") { 
          alert("新密码不能为空"); 
          return false; 
        } 
      if (newPassword2.value == "") { 
          alert("确认密码不能为空"); 
          return false; 
        } 
      if (!newPassword1.equals(newPassword2)) { 
          alert("两次密码不一致"); 
          return false; 
        } 
    } 
  } 
</script> 
</head> 
<body bgcolor="#9BCD9B">	
<form action="teaChange" method="post" onsubmit="check(this)"> 
<table align="center" border="1" width="50%" cellpadding="6">  

	<tr>
		<th colspan="2" align="center" >修改密码界面</th>
	</tr>
	<tr>
		<td align="center" >账        号：</td>   
		<td align="left" ><input type="text" name="teaID"></td>
	</tr>
	<tr>
        <td align="center" >旧    密    码：</td>
		<td align="left" ><input type="text" name="oldPassword"></td>
	</tr>
	<tr>
        <td align="center" >新    密    码：</td>
		<td align="left" ><input type="text" name="newPassword1"></td>
	</tr>
	<tr>
        <td align="center" >确认新密码：</td>
		<td align="left" ><input type="text" name="newPassword2"></td>
	</tr>
	<tr>
		<th colspan="2" align="center" ><input type="submit" name="submit" value="确认修改"></th>
	</tr>
</table>
</form>
</body>
