<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
<head> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
<title>教师注册</title>
<script type="text/javascript"> 
  function check(form) { 
    with (form) { 
      if (stuID.value == "") { 
        alert("工号不能为空"); 
        return false; 
      }   
      if (name.value == "") { 
        alert("姓名不能为空"); 
        return false; 
      } 
      if (dept_name.value == "") { 
        alert("系名不能为空"); 
        return false; 
      } 
      if (tot_cred.value == "") { 
          alert("薪水不能为空"); 
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
<form action="teaRegister" method="post" onsubmit="check(this)"> 
<table align="center" border="1" width="50%" cellpadding="6">      

	<tr>
		<th colspan="2" align="center" >教师用户注册平台</th>
	</tr>
	<tr>
		<td align="center" >工        号：</td>   
		<td align="left" ><input type="text" name="teaID"></td>
	</tr>
	<tr>
		<td align="center" >姓        名：</td> 
		<td align="left" ><input type="text" name="name"></td>
	</tr>
	<tr>
		<td align="center" >系        名：</td>
		<td align="left" ><input type="text" name="dept_name"></td>
	</tr>
	<tr>
		<td align="center" >薪        水：</td>
		<td align="left" ><input type="text" name="salary"></td>
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
