<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				  <a>学生信息操纵</a>
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
                            <h4><em>编辑学生总学分</em> </h4><br>
                            <div class="col-md-12">
                          <fieldset>
                             <form action="updateStudentItem" method="post">
    
        tot_cred:&nbsp;&nbsp;<input name="tot_cred" value="${studentItem.tot_cred}"> <br>

        <br>

        <input type="hidden" name = "sID" value="${studentItem.sID}">
        <input type="hidden" name = "name" value="${studentItem.name}">
        <input type="hidden" name = "dept_name" value="${studentItem.dept_name}">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交">
    </form>
                          </fieldset>
                        </div>
							  
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