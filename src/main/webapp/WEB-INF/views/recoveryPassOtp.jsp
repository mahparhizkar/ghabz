<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fa">
    <link rel="SHORTCUT ICON" href="${pageContext.request.contextPath}/static/index/img/logoT.png">
    <meta content="index" name="googlebot">
    <meta name="author" content="Asayeshe Farda Co.">
    <meta name="copyright" content="Asayeshe Farda Co. Copyrights 2019 All Rights Reserved.">
    <meta name="generator" content="eXtremer CMS - Asayeshe Farda Co. ">
    <meta name="revisit-after" content="7 Days">
    <title>طرح تحول سلامت دهان و دندان</title>

    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/animate/animate.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/css-hamburgers/hamburgers.min.css">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dashboard/app/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dashboard/app/css/main.css">
</head>

<body>
<div class="container-login100">
    <div class="wrap-login100" style="padding-bottom: 10px">

        <form:form method="post" modelAttribute="recoveryPassOtpForm"
                   action="${pageContext.request.contextPath}/recoveryPassOtp" style="margin-top: -50px;width: 300px;">

            <span class="login100-form-title" style="margin-top: -100px">
				<a href="${pageContext.request.contextPath}/" class="site_title">
					<img src="${pageContext.request.contextPath}/static/index/img/logoT.png" style="width: 100px"></img>
				</a>
			</span>

            <span class="login100-form-title">
				تایید کد اعتبارسنجی
			</span>

            <c:if test="${msgExist}">
                <div class="alert alert-info alert-dismissible">
                        ${msg}
                </div>
            </c:if>

            <form:errors path="*" cssClass="alert alert-danger alert-dismissible" cssStyle="direction: rtl"
                         element="div"/>

            <spring:bind path="userName">
                <input class="input100" type="number" min="0" name="userName" path="userName" placeholder="کد ملی"
                       value="${recoveryPassOtpForm.userName}" hidden="true">
            </spring:bind>

            <spring:bind path="mobileNumber">
                <input class="input100" type="number" min="0" name="mobileNumber" path="mobileNumber"
                       placeholder="شماره موبایل" value="${recoveryPassOtpForm.mobileNumber}" hidden="true">
            </spring:bind>

            <spring:bind path="otp">
                <div class="sms-verification-simple">
                    <input type="text" name="otp" id="otpID" class="form-control" maxlength="6" placeholder=""
                           aria-describedby="basic-addon1">
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </div>
            </spring:bind>

            <div class="container-login100-form-btn">
                <button class="login100-form-btn" id="submitBut" style="width: 100px">تایید</button>
            </div>

            <div class="text-center p-t-12">
                <a class="txt2" id="resendOTP" herf="#">
                    ارسال مجدد کد
                </a>
            </div>

        </form:form>
    </div>
</div>


<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/tilt/tilt.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/temp.js"></script>


<script src="${pageContext.request.contextPath}/static/scripts/inputFilter.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>

<script>
    $(document).ready(function () {

        inputFilterForIntTextBox('otpID');

        $("#resendOTP").click(function (event) {
            $.ajax({
                type: "POST",
                url: "recoveryPass",
                data: $('form').serialize(),
                success: function (result) {
                },
                error: function (result) {
                }
            });
        });

        $("#submitBut").click(function (event) {
            $('#msg').empty();

            var otpID = $('#otpID').val();

            if (isNullTextField(otpID) || isNullTextField(mobileNumberId) || isNullTextField(password)) {
                $('#msg').show().addClass("alert alert-danger").append("همه فیلد ها ضروری است.<br>");
                event.preventDefault();
            }
        });
    });
</script>
</body>
</html>