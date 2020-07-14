<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

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


    <style>
        .close {
            float: right;
            font-size: 1rem;
            font-weight: 700;
            line-height: 0.5;
            color: #000;
            text-shadow: 0 1px 0 #fff;
            opacity: .5;
        }

        .alert-dismissible .close {
            top: -70px !important;
            right: -30px !important;
        }
    </style>
</head>
<body>

<div class="container-login100">
    <div class="wrap-login100" style="padding-bottom: 10px">

        <form:form method="POST" modelAttribute="registrationForm" class="login100-form validate-form" style="margin-top: -60px">


            <span class="login100-form-title" style="margin-top: -100px">
				<a href="${pageContext.request.contextPath}/" class="site_title">
					<img src="${pageContext.request.contextPath}/static/index/img/logoT.png">
					</img>
				</a>
			</span>

            <span class="login100-form-title">
				ایجاد حساب کاربری
			</span>

            <form:errors path="*" cssClass="alert alert-danger alert-dismissible" cssStyle="direction: rtl"
                         element="div"/>


            <div id="msg" style="display: none;direction: rtl;"></div>

            <spring:bind path="userName">
                <div class="wrap-input100 validate-input" data-validate="Enter your national ID">
                    <input class="input100" type="text" id="userNameId" minlength="10" maxlength="10" name="userName"
                           path="userName" placeholder="کد ملی">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-user" aria-hidden="true"></i>
					</span>
                </div>
            </spring:bind>

            <spring:bind path="mobileNumber">
                <div class="wrap-input100 validate-input" data-validate="Enter your mobile number">
                    <input class="input100" type="text" id="mobileNumberId" minlength="11" maxlength="11"
                           name="mobileNumber" path="mobileNumber" placeholder="شماره موبایل:09121112233">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                        <i class="fa fa-mobile-phone" aria-hidden="true"></i>
                    </span>
                </div>
            </spring:bind>

            <spring:bind path="password">
                <div class="wrap-input100 validate-input" data-validate="Enter a password">
                    <input class="input100" type="password" id="password" maxlength="32" name="password" path="password"
                           placeholder="رمز عبور">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
						<i class="fa fa-lock" aria-hidden="true"></i>
					</span>
                </div>
            </spring:bind>

            <div class="container-login100-form-btn">
                <button class="login100-form-btn" type="submit" id="submitBut">
                    عضویت
                </button>
            </div>

            <div class="text-center p-t-10">
                <a class="txt2" href="${pageContext.request.contextPath}/login">
                    ورود کاربر
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

<script src="${pageContext.request.contextPath}/static/scripts/inputFilter.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>

<script>
    $(document).ready(function () {

        inputFilterForIntTextBox('mobileNumberId');
        inputFilterForIntTextBox('userNameId');

        $("#submitBut").click(function (event) {
            $('#msg').empty();

            var userNameId = $('#userNameId').val();
            var mobileNumberId = $('#mobileNumberId').val();
            var password = $('#password').val();

            var res = checkReg(mobileNumberId, "^[0][9][0-9][0-9]{8,8}$");

            if (isNullTextField(userNameId) || isNullTextField(mobileNumberId) || isNullTextField(password)) {
                $('#msg').show().addClass("alert alert-danger").append("همه فیلد ها ضروری است.<br>");
                event.preventDefault();
            }

            if (checkSizeTextField(mobileNumberId, 11, 11) || !res) {
                $('#msg').show().addClass("alert alert-danger").append("فرمت مورد قبول موبایل 11 رقم و شروع 09 است.<br>");
                event.preventDefault();
            }

            var nc = isValidIranianNationalCode($('#userNameId').val());
            if (nc == false) {
                $('#msg').show().addClass("alert alert-danger").append("کد ملی نامعتبر است.<br>");
                event.preventDefault();
            }
        });
    });
</script>
</body>
</html>