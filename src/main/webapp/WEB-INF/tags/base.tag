<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ tag description="Basic Page Template" pageEncoding="UTF-8" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<html lang="fa" dir="rtl">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="description" content=""/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fa">
    <link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/static/index/img/logoT.png">
    <meta content="index" name="googlebot">
    <meta name="author" content="Asayeshe Farda Co.">
    <meta name="copyright" content="Asayeshe Farda Co. Copyrights 2019 All Rights Reserved.">
    <meta name="generator" content="eXtremer CMS - Asayeshe Farda Co. ">
    <meta name="revisit-after" content="7 Days">
    <title>طرح تحول سلامت دهان و دندان</title>

    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-rtl/dist/css/bootstrap-rtl.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/iCheck/skins/flat/green.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/build/css/custom.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/app/css/circleChart.css" rel="stylesheet">

</head>

<body class="nav-sm" id="fbt">


<div class="container body">
    <div class="main_container">

        <div class="col-md-3 left_col hidden-print">
            <div class="left_col scroll-view">
                <div class="clearfix"></div>

                <div class="profile clearfix">
                    <div class="profile_pic">
                        <img src="${pageContext.request.contextPath}/static/dashboard/build/images/img.jpg" alt="..."
                             class="img-circle profile_img">
                    </div>
                    <div class="profile_info">
                        <span>خوش آمدید</span>
                        <h2><sec:authentication property="principal.username"/></h2>
                    </div>
                </div>

                <br/>

                <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <ul class="nav side-menu">
                            <li><a href="${pageContext.request.contextPath}/dashboard"/><i class="fa fa-home"></i> خانه
                                <span></span></a>
                            </li>

                            <sec:authorize access="hasAnyRole('ROLE_Admin','ROLE_Power','ROLE_Support')">
                                <li><a href="${pageContext.request.contextPath}/userManagement"><i
                                        class="fa fa-cog"></i>مدیریت دسترسی</a></li>
                            </sec:authorize>

                        </ul>
                    </div>
                </div>


                <div class="sidebar-footer hidden-small">
                    <a data-toggle="tooltip" data-placement="top" title="تنظیمات">
                        <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="تمام صفحه" onclick="toggleFullScreen();">
                        <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="قفل" class="lock_btn">
                        <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                    </a>
                    <a data-toggle="tooltip" data-placement="top" title="خروج" href="<cc:url value="/logout" />">
                        <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                    </a>
                </div>

            </div>
        </div>

        <div class="top_nav hidden-print">
            <div class="nav_menu">
                <nav>
                    <div class="nav toggle">
                        <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                    </div>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="">
                            <a href="javascript:" class="user-profile dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/static/dashboard/build/images/img.jpg"
                                     alt="">
                                <span class=" fa fa-angle-down"></span>
                            </a>
                            <ul class="dropdown-menu dropdown-usermenu pull-right">

                                <li>
                                    <sec:authorize access="hasAnyRole('ROLE_Dentist')">
                                        <a href="${pageContext.request.contextPath}/dashboard"><i class="fa fa-sign-out pull-right"></i>پروفایل پزشکی</a>
                                        <a href="${pageContext.request.contextPath}/generalProfile"><i class="fa fa-sign-out pull-right"></i>پروفایل معمولی</a>
                                    </sec:authorize>


                                    <a href="<cc:url value="/logout" />"><i class="fa fa-sign-out pull-right"></i>خروج</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>

        <jsp:doBody/>

    </div>
    <footer class="hidden-print">
        <div class="clearfix"></div>
    </footer>
</div>

<div id="lock_screen">
    <table>
        <tr>
            <td>
                <div class="clock"></div>
                <span class="unlock">
					<span class="fa-stack fa-5x">
						<i class="fa fa-square-o fa-stack-2x fa-inverse"></i>
						<i id="icon_lock" class="fa fa-lock fa-stack-1x fa-inverse"></i>
					</span>
				</span>
            </td>
        </tr>
    </table>
</div>

<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/fastclick/lib/fastclick.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/nprogress/nprogress.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/iCheck/icheck.min.js"></script>
<%--table--%>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jszip/dist/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/pdfmake/build/vfs_fonts.js"></script>
<%--end table--%>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Chart.js/dist/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/gauge.js/dist/gauge.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/skycons/skycons.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Flot/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Flot/jquery.flot.pie.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Flot/jquery.flot.time.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Flot/jquery.flot.stack.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/Flot/jquery.flot.resize.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/flot.curvedlines/curvedLines.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/DateJS/build/production/date.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/build/js/custom.min.js"></script>
</body>
</html>