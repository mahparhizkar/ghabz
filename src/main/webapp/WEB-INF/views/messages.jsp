<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>

<layout:base>
    <style>
        .pay{
            font-size: 30px;
            font-weight: 600;
            color: #34495e;
        }
    </style>

    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-offset-4 col-md-12 col-sm-12 col-xs-12" style="margin-top: 200px">
                <h4 class="pay">صفحه پیام ها</h4>
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