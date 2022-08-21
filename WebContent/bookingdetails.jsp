<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
//prevent Caching of JSP pages
response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
//get the session and check if session is null, redirect to login page
if(session.getAttribute("currentSessionUser")==null)
response.sendRedirect("login.jsp");
%>
<%@ page import="easyBus.model.*,easyBus.dao.*,java.sql.*, java.util.*" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Homepage</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
                <div>
                    <i><img src="img/7.png" width="80" height="30"></i>
                </div>
                <div class="sidebar-brand-text mx-3">EasyBus</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="home.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Personal Details</span></a>
            </li>
            
            <!-- Divider -->
            <hr class="sidebar-divider">  
            
            <!-- Nav Item - Tables -->
            <li class="nav-item">
                <a class="nav-link" href="schedule.jsp">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Bus Schedule & Ticket Booking</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <div class="header_information">
                    	&nbsp<img src="img/2.png" alt="#"/> +60348592764 &nbsp&nbsp&nbsp
                      	<img src="img/3.png" alt="#"/> easyBus@gmail.com
                    </div>
                    
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>

                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small"><%= session.getAttribute("currentSessionUser") %></span>
                                <img class="img-profile rounded-circle"
                                    src="img/undraw_profile.svg">
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
					<div class="card">
			            <div class="card-body">
			              <!--<img src="glitter.gif" alt="glitter" width="100px" height="100px">-->
			              <div class="masthead" style="background-image: url(img/watercolorbg.jpg); border-radius : 25px; margin:auto ; height:300px; width: 1000px; border: 3px solid white;">
				              <div class="intro-text">
				                <div class="intro-lead-in">
				                   <div class="image-container"><br>
				                     <img src="img/welcome.png" style="margin-left: 280px" width="400px" height="150px" alt="welcome"><br><br>
				                   </div>
				                   <center><h1><font face="Forte" color="#FFA500">Thank you for choosing us <%= session.getAttribute("currentSessionUser") %><br>Hope you enjoy your ride</font></h1></center>
				                </div>
				              </div>
			              </div><p>
			              <div class="table-responsive">
	                      	<p><table align = "center" cellpadding="4" cellspacing="3">
	                      	<% 
							    int passID = Integer.parseInt(request.getParameter("passID"));	
								Booking b = BookingDAO.getBookingByPassId(passID);
							%>
	                                        <tr>
	                                            <th>Booking ID: </th>
	                                            <th><%= b.getBookingID() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>Passenger ID:&nbsp&nbsp&nbsp </th>
	                                            <th><%= b.getPassID() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>Bus ID: </th>
	                                            <th><%= b.getBusID() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>Bus Name:</th>
	                                            <th><%= b.getBusName() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>From: </th>
	                                            <th><%= b.getFromWhere() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>To: </th>
	                                            <th><%= b.getToWhere() %></th>
	                                        </tr>
	                                        <tr>
	                                        	<th>Time: </th>
	                                            <th><%= b.getTicketTime() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>Date: </th>
	                                            <th><%= b.getDate() %></th>
	                                        </tr>
	                                        <tr>
	                                            <th>Quantity: </th>
	                                            <th><%= b.getQuantity() %></th>
	                                        </tr>
	                                        
	                                </table>
                         </div></p>
			           </div>
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

           <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="LogoutController">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>
</html>