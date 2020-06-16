<%@page import="java.sql.SQLException"%> 
<%@page import="java.sql.DriverManager"%> 
<%@page import="java.sql.Connection"%> 
<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8"%> 
<!DOCTYPE html>
<html>

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">

    <title>Ramayana - Simple HTML Page</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">



    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css">
    <link rel="stylesheet" href="assets/css/templatemo-style.css">
    <link rel="stylesheet" href="assets/css/owl.css">

  </head>

<body class="is-preload">

    <!-- Wrapper -->
    <div id="wrapper">

      <!-- Main -->
        <div id="main">
          <div class="inner">

            <!-- Header -->
            <header id="header">
              <div class="logo">
                <a href="index.html">管理员注册界面</a>
              </div>
            </header>
<form action="admRegister" method="post" onsubmit="check(this)"> 
            <!-- Page Heading -->
            <section class="main-banner">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <div class="banner-content">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="banner-caption">
                            <h4>欢迎注册<br><em>教务管理系统</em> </h4><br>
                            <div class="col-md-12">
                          <fieldset>
                            <input name="admID" type="text" class="form-control" id="name" placeholder="请输入工号" required="">
                          </fieldset>
                        </div>
							  <br>
							  <div class="col-md-12">
                          <fieldset>
                            <input name="password1" type="text" class="form-control" id="email" placeholder="请设置密码" required="">
                          </fieldset>
                        </div>
							  <br>
							  <div class="col-md-12">
                          <fieldset>
                            <input name="password2" type="text" class="form-control" id="email" placeholder="确认密码" required="">
                          </fieldset>
                        </div><br>
							  <div class="col-md-12">
                          <fieldset>
                            <button type="submit" id="form-submit" class="button">立即注册</button>
                          </fieldset>
                        </div>
                           
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
  </form>         

            <!-- Simple Post -->
            
            <!-- Contact Form -->
            

          </div>
        </div>

      <!-- Sidebar -->
        <div id="sidebar">

          <div class="inner">

            <!-- Search Box -->
            <section id="search" class="alt">
              <form method="get" action="#">
                <input type="text" name="search" id="search" placeholder="查找功能" />
              </form>
            </section>
              
            <!-- Menu -->
           <nav id="menu">
              <ul>
                <li><a href="index.html">用户须知</a></li>
                <li><a href="simple_page.html">选课通知</a></li>
                <li><a href="http://www.scu.edu.cn">学校官网</a></li>
				  <li><a href="simple_page.html">问题反馈</a></li>
                
              </ul>
            </nav>

            <!-- Featured Posts -->
            <div class="featured-posts">
              <div class="heading">
                <h2>校园一览</h2>
              </div>
              <div class="owl-carousel owl-theme">
                <a href="#">
                  <div class="featured-item">
                    <img src="scu1.jpg" alt="featured one">
                    <p>更多信息敬请访问四川大学官网</p>
                  </div>
                </a>
                <a href="#">
                  <div class="featured-item">
                    <img src="scu2.jpg" alt="featured two">
                    <p>更多信息敬请访问四川大学官网</p>
                  </div>
                </a>
                <a href="#">
                  <div class="featured-item">
                    <img src="scu3.jpg" alt="featured three">
                    <p>更多信息敬请访问四川大学官网</p>
                  </div>
                </a>
              </div>
            </div>

            <!-- Footer -->
            <footer id="footer">
              <p class="copyright">Copyright &copy; 2020 四川大学
              <br>小组：第7组  
			  <br>组长：吴沛颖 组员：黄美 何明锦 梁堉 邢国浩</p>
            </footer>
            
          </div>
        </div>

    </div>

  <!-- Scripts -->
  <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/transition.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/custom.js"></script>
</body>


  </body>

</html>

<!--  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
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
</body>-->
