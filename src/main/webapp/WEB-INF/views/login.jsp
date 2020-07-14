<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
        .capt {
            background-color: #e8f0fe;
            height: 100px;
            border-radius: 10px;
        }

        #mainCaptcha {
            position: relative;
            left: 60px;
            top: 5px;
        }

        #refresh {
            position: relative;
            left: 200px;
            width: 30px;
            height: 30px;
            bottom: 25px;
            background-image: url("${pageContext.request.contextPath}/static/index/img/refresh.png");
        }

        #txtInput, #Button1 {
            border-radius: 4px;
            position: relative;
            left: 40px;
            bottom: 40px;
        }

        #showtxt {
            position: fixed;
            margin-left: 50px;
        }
    </style>

</head>

<body onload="Captcha();">

<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100">

            <form class="login100-form validate-form" method="post"
                  action="${pageContext.request.contextPath}/j_spring_security_check" style="margin-top: -50px">

                <span class="login100-form-title" style="margin-top: -100px">
                    <a href="" class="site_title">
                        <img src="${pageContext.request.contextPath}/static/index/img/logoT.png">
                        </img>
                    </a>
			    </span>

                <form:errors path="*" cssClass="alert alert-danger alert-dismissible" cssStyle="direction: rtl"
                             element="div"/>

                <span class="login100-form-title">
                    ورود
                </span>

                <c:if test="${msgExist}">
                    <div Class="alert alert-success" role="alert" Style="direction: rtl">
                        ثبت نام با موفقیت انجام شد.
                    </div>
                </c:if>

                <div class="wrap-input100 validate-input" data-validate="کد ملی را وارد کنید.">
                    <input class="input100" id="userNameId" type="text" name="userName" placeholder="کد ملی">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                        <i class="fa fa-user" aria-hidden="true"></i>
                    </span>
                </div>

                <div class="wrap-input100 validate-input" data-validate="رمز عبور را وارد کنید.">
                    <input class="input100" id="password" type="password" name="password" placeholder="رمز عبور">
                    <span class="focus-input100"></span>
                    <span class="symbol-input100">
                        <i class="fa fa-lock" aria-hidden="true"></i>
                    </span>
                </div>

                <%--Captcha--%>
                <div class="capt">
                    <h2 type="text" id="mainCaptcha"></h2>
                    <p>
                        <input type="button" id="refresh" onclick="Captcha();"/>
                    </p>
                    <br/>
                    <label for="txtInput"></label><input maxlength="4" type="text" onclick="" id="txtInput"/>
                </div>

                <div class="container-login100-form-btn">
                    <button class="login100-form-btn" type="submit" id="submitBut">
                        ورود
                    </button>
                </div>

                <div class="text-center p-t-12">
                    <a class="txt2" href="${pageContext.request.contextPath}/recoveryPass">فراموشی رمز عبور</a>
                </div>

                <div class="text-center p-t-12">
                    <a class="txt2" href="${pageContext.request.contextPath}/registration">عضویت</a>
                </div>
            </form>
            <c:if test="${param.error eq 'a'}">
                <div class="alert alert-danger" style="margin-right: 10%; margin-left:0%; margin-top:10%; width:35%; float: left" >
                    <p  style="font-size:9pt; font-weight:bold">
                        نام کاربری یا رمز عبور اشتباه است
                    </p>
                </div>
            </c:if>

            <c:if test="${param.error eq 'b'}">
                <div class="alert alert-danger" style="margin-right: 10%; margin-left:0%; margin-top:10%; width:35%; float: left" >
                    <p  style="font-size:9pt; font-weight:bold">
                        حساب کاربری شما غیر فعال شده است. برای اطلاعات بیشتر با پشتیبانی تماس بگیرید
                    </p>
                </div>
            </c:if>

        </div>

    </div>

</div>

<script src="${pageContext.request.contextPath}/static/scripts/captchaValidation.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>

<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/jquery/jquery-3.2.1.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/select2/select2.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/vendor/tilt/tilt.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/dashboard/app/js/main.js"></script>


<script src="${pageContext.request.contextPath}/static/scripts/inputFilter.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>
<script src="${pageContext.request.contextPath}/static/scripts/inputFilter.js"></script>


<script>
    $(document).ready(function () {

        inputFilterForIntTextBox('userNameId');
        $("#txtInput").inputFilter(function (value) {
            return /^-?\d*$/.test(value);
        });

        $("#submitBut").click(function (event) {
            $('#msg').empty();

            /*Captcha*/
            var string1 = removeSpaces(document.getElementById('mainCaptcha').value);
            var string2 = removeSpaces(document.getElementById('txtInput').value);
            if (string1 !== string2) {
                event.preventDefault();
                alert("لطفا کد امنیتی را صحیح وارد نمایید")
            }

            var txtInput = $('#txtInput').val();

            var userNameId = $('#userNameId').val();

            var password = $('#password').val();

            if (isNullTextField(userNameId) || isNullTextField(txtInput) || isNullTextField(password)) {
                $('#msg').show().addClass("alert alert-danger").append("همه فیلد ها ضروری است.<br>");
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