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

    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dashboard/app/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/dashboard/app/css/main.css">

    <!--===============================================================================================-->

    <style>

    </style>


</head>
<body>

<div class="container-login100">
    <div class="wrap-login100" style="padding-bottom: 10px">

        <c:if test="${msgExist}">
            ${msg}
        </c:if>

        <form:form method="post" modelAttribute="verificationForm"
                   action="${pageContext.request.contextPath}/verification" style="margin-top: -50px;width: 300px;">

            <span class="login100-form-title" style="margin-top: -100px">
				<a href="${pageContext.request.contextPath}/" class="site_title">
					<img src="${pageContext.request.contextPath}/static/index/img/logoT.png" style="width: 100px">
					</img>
				</a>
			</span>

            <span class="login100-form-title">
				تایید کد اعتبارسنجی
			</span>


            <spring:bind path="userName">
                <input class="input100" type="number" min="0" name="userName" path="userName" placeholder="کد ملی"
                       value="${verificationForm.userName}" hidden="true">
            </spring:bind>

            <spring:bind path="mobileNumber">
                <input class="input100" type="number" min="0" name="mobileNumber" path="mobileNumber"
                       placeholder="شماره موبایل" value="${verificationForm.mobileNumber}" hidden="true">
            </spring:bind>

            <spring:bind path="password">
                <input class="input100" type="password" name="password" path="password" placeholder="رمز عبور"
                       value="${verificationForm.password}" hidden="true">
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

            <div><span id="time" style="margin: 124px">02:00</span></div>

            <div class="container-login100-form-btn">
                <button class="login100-form-btn" style="width: 100px">
                    تایید
                </button>
            </div>

            <div id="resendOPTDiv" class="text-center p-t-12">

            </div>
        </form:form>
    </div>
</div>

<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/tilt/tilt.jquery.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/static/dashboard/app/js/main.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/verificationCode.js"></script>

<script src="${pageContext.request.contextPath}/static/scripts/inputFilter.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>

<script>

    /*$(function()
    {
        setTimeout(function(){
            $("#resendOTP").hide();

        }, 3000);


    });*/

    $(document).ready(function () {
        inputFilterForIntTextBox('otpID');

        startTimer();

        //on click the resendOTP even if it's dynamically generated
        $(document).on("click","#resendOTP",function (event) {
            $.ajax({
                type: "POST",
                url: "registration",
                data: $('form').serialize(),
                success: function (result) {
                    $("#resendOPTDiv").html('') ;
                    startTimer();
                },
                error: function (result) {
                }
            });
        });
    });

    function startTimer() {
        //set timer to two minutes
        var duration = 60 * 2;
        var timer = setInterval(function () {
            minutes = parseInt(duration / 60, 10);
            seconds = parseInt(duration % 60, 10);

            minutes = minutes < 10 ? "0" + minutes : minutes;
            seconds = seconds < 10 ? "0" + seconds : seconds;


            $("#time").text(minutes + ':' + seconds);
            duration--;
            if (duration < 0) {
                //freeze the timer
                clearInterval(timer);
                //generate the resendOPTDiv dynamically
                var opt = '<a class="txt2" id="resendOTP" href="#">      ارسال مجدد کد    </a>';
                $("#resendOPTDiv").html(opt);
            }
        }, 1000);
    }

</script>
</body>
</html>