<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

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
                <a>选课</a>
              </div>
            </header>

            <!-- Page Heading -->
            <section class="main-banner">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12">
                    <div class="banner-content">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="banner-caption">
                            <div class="col-md-12">
                         <!-- 查询某一门课程名 -->
<form  action="listSomeSection" method="post">
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
                        </div>
                           
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </section>
           

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





<!--
<title>学生选课</title>

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
<div align='center'><a href="listStudentCourse?name=look">查看课表</a></div>-->