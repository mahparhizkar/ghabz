<%@ page session="false"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<layout:base>
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-rtl/dist/css/bootstrap-rtl.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/nprogress/nprogress.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/dashboard/build/css/custom.min.css" rel="stylesheet">


    <div class="right_col" role="main" style="background-color: white;">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">

                    <div class="x_content">
                        <h1>خطای ${httpErrorCode}</h1>
                        <c:if test="${httpErrorCode == 400}">
                            <h2>سرور قادر به تشخیص نحو (Syntax) درخواست نمی‌باشد.</h2>
                        </c:if>
                        <c:if test="${httpErrorCode == 401}">
                            <h2>درخواست شما غیرمجاز است.</h2>
                        </c:if>
                        <c:if test="${httpErrorCode == 410}">
                            <h2>صفحه درخواستی شما حذف شده است.</h2>
                        </c:if>
                        <c:if test="${httpErrorCode == 500}">
                            <h2>سرور با خطا مواجه شده و قادر به انجام درخواست نمی‌باشد.</h2>
                        </c:if>
                        <c:if test="${httpErrorCode == 503}">
                            <h2>سرور در حال حاضر در دسترس نمی باشد.</h2>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/jquery/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/popper.js"></script>
    <script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/tilt/tilt.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/dashboard/app/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>


</layout:base>