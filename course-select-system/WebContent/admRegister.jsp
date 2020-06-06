<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>管理员注册</title>

<script type="text/javascript"> 
  function check(form) { 
    with (form) { 
      if (admID.value == "") { 
        alert("工号不能为空"); 
        return false; 
      }   
      if (password1.value == "") { 
          alert("密码不能为空"); 
          return false; 
        } 
      if (password2.value == "") { 
          alert("确认密码不能为空"); 
          return false; 
        } 
      if ((password1.value)!=(password2.value)) { 
          alert("两次密码输入不一致"); 
          return false; 
        } 
    } 
  } 
</script> 
</head> 
<body bgcolor="#9BCD9B">	
<form action="admRegister" method="post" onsubmit="check(this)"> 
<table align="center" border="1" width="50%" cellpadding="6">  

	<tr>
		<th colspan="2" align="center" >管理员注册平台</th>
	</tr>
	<tr>
		<td align="center" >工        号：</td>   
		<td align="left" ><input type="text" name="admID"></td>
	</tr>
	<tr>
		<td align="center" >设置密码：</td>
		<td align="left" ><input type="text" name="password1"></td>
	</tr>
	<tr>
        <td align="center" >确认密码：</td>
		<td align="left" ><input type="text" name="password2"></td>
	</tr>
	<tr>
		<th colspan="2" align="center" ><input type="submit" name="submit" value="立即注册"></th>
	</tr>

</table>
</form>
</body>
