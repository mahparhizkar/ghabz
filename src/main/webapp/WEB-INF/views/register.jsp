<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags" %>

<%@ page pageEncoding="UTF-8" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<layout:base>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/JalaliJSCalendar-1.4/skins/aqua/theme.css">

    <style>
        .calender-icon {
            position: absolute !important;
            margin-top: -5px !important;
            margin-right: -5px !important;
        }
        .input-group .form-control {
            position: initial !important;
        }
    </style>

    <div class="right_col" role="main">
        <div class="row">
            <div class="col-md-12 col-sm-6 col-xs-6">
                <div class="x_panel">
                    <div class="x_title">
                        <h2>پروفایل</h2>
                        <ul class="nav navbar-right panel_toolbox">
                            <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="x_content">
                        <form:form method="POST" modelAttribute="userRegister" action="${pageContext.request.contextPath}/register" class="form-horizontal form-label-left"
                                   enctype="multipart/form-data">
                            <div id="msg" style="display: none;direction: rtl;"></div>
                            <h4>اطلاعات شخصی</h4>
                            <spring:bind path="naturalPerson.name">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">نام
                                            <span class="required">*</span>
                                        </label>
                                        <input class="form-control" type="text" min="0" name="naturalPerson.name"
                                               maxlength="50" id="name" value="${userRegister.naturalPerson.name}" required="required">
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.family">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">نام خانوادگی
                                            <span class="required">*</span>
                                        </label>
                                        <input class="form-control" type="text" min="0" name="naturalPerson.family" id="family"
                                               value="${userRegister.naturalPerson.family}" required="required">
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.nationalId">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">کد ملی
                                            <span class="required"></span>
                                        </label>
                                        <input class="form-control" type="text" min="0" name="naturalPerson.nationalId" value="${userRegister.naturalPerson.nationalId}" readonly>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.fatherName">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon"> نام پدر
                                            <span class="required">*</span>
                                        </label>
                                        <input class="form-control" type="text" min="0" name="naturalPerson.fatherName"
                                               maxlength="50" id="fatherName" value="${userRegister.naturalPerson.fatherName}" required="required">
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.birthDateShamsi">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">تاریخ تولد
                                            <span class="required">*</span>
                                        </label>
                                        <input class="form-control" type="text" min="0" id="date_input" name="naturalPerson.birthDateShamsi"
                                               value="${userRegister.medicalInfo.naturalPerson.persianBirthDate} "
                                            <%--pattern="^\d{4}[\-\/\s]?((((0[13578])|(1[02]))[\-\/\s]?(([0-2][0-9])|(3[01])))|(((0[469])|(11))[\-\/\s]?(([0-2][0-9])|(30)))|(02[\-\/\s]?[0-2][0-9]))$"--%>
                                               required="required" readonly>
                                        <span class="input-group-addon"><i class="fa fa-calendar calender-icon" id="date_btn" aria-hidden="true"></i></span>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.phoneNumber">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">تلفن ثابت
                                            <span class="required">*</span>
                                        </label>
                                        <input required="required" class="form-control" type="text" id="phoneNumber" min="0"
                                               name="naturalPerson.phoneNumber" value="${userRegister.naturalPerson.phoneNumber}">
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.gender">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">جنسیت
                                            <span class="required">*</span>
                                        </label>
                                        <select id="gender" name="naturalPerson.gender" path="naturalPerson.gender"
                                                class="form-control">
                                            <c:forEach items="${gender}" var="g">
                                                <c:choose>
                                                    <c:when test="${userRegister.naturalPerson.gender == g.value}"><option value="${g.value}" selected="selected">${g.text}</option></c:when>
                                                    <c:otherwise><option value="${g.value}">${g.text}</option></c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.maritalStatus">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">وضعیت تاهل
                                            <span class="required">*</span>
                                        </label>
                                        <select id="maritalStatus" name="naturalPerson.maritalStatus" path="naturalPerson.maritalStatus"
                                                class="form-control">
                                            <c:forEach items="${maritalStatus}" var="m">
                                                <c:choose>
                                                    <c:when test="${userRegister.naturalPerson.maritalStatus == m.value}"><option value="${m.value}" selected="selected">${m.text}</option></c:when>
                                                    <c:otherwise><option value="${m.value}">${m.text}</option></c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="naturalPerson.mobileNumber">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">موبایل
                                            <span class="required">*</span>
                                        </label>
                                        <input required="required" class="form-control" type="text" id="mobileNumber" min="0"
                                               name="naturalPerson.mobileNumber" value="${userRegister.naturalPerson.mobileNumber}" readonly>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="address.stateId">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">استان محل سکونت</label>
                                        <select id="state" name="address.stateId" class="form-control"
                                                path="address.stateId" size="1"
                                                onchange="makeSubmenu(this.value)">
                                            <c:choose>
                                                <c:when test="${s == '000'}">
                                                    <option value="" disabled selected>انتخاب استان</option>
                                                    <c:forEach items="${states}" var="state">
                                                        <c:choose>
                                                            <c:when test="${s == state.id}"><option value="${state.id}" selected="selected">${state.name}</option></c:when>
                                                            <c:otherwise><option value="${state.id}">${state.name}</option></c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="" disabled>انتخاب استان</option>
                                                    <c:forEach items="${states}" var="state">
                                                        <c:choose>
                                                            <c:when test="${s == state.id}"><option value="${state.id}" selected="selected">${state.name}</option></c:when>
                                                            <c:otherwise><option value="${state.id}">${state.name}</option></c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="address.cityId">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon"><span class="required"></span>شهر محل سکونت</label>
                                        <select id="city" name="address.cityId" class="form-control" path="address.cityId" size="1">
                                            <c:choose>
                                                <c:when test="${c == '000'}">
                                                            <option value="" disabled selected>انتخاب شهر</option>
                                                            <c:forEach items="${allCities}" var="city">
                                                                <c:if test="${c == city.id}">
                                                                    <option value="${city.id}" selected="selected">${city.name}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="" disabled>انتخاب شهر</option>
                                                    <c:forEach items="${allCities}" var="city">
                                                        <c:if test="${c == city.id}">
                                                            <option value="${city.id}" selected="selected">${city.name}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="address.fullAddress">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">آدرس</label>
                                        <input class="form-control" rows="4" style="border: 1.2px solid #ccc; border-radius: 2px !important;" type="text" min="0" id="fullAddress"
                                               name="address.fullAddress" value="${userRegister.address.fullAddress}"></input>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="address.id">
                                <input name="address.id" value="${userRegister.address.id}" hidden="true"/>
                            </spring:bind>

                            <spring:bind path="medicalInfo.id">
                                <input name="medicalInfo.id" value="${userRegister.medicalInfo.id}" hidden="true"/>
                            </spring:bind>

                            <spring:bind path="naturalPerson.id">
                                <input name="naturalPerson.id" value="${userRegister.naturalPerson.id}" hidden="true"/>
                            </spring:bind>


                            <div class="col-md-12 col-sm-12 col-xs-12 form-group">
                                <div class="col-md-3 col-sm-12 col-xs-12 form-group">
                                    <h4>سابقه پزشکی</h4>
                                </div>
                                <div class="col-md-9 col-sm-12 col-xs-12 form-group"></div>
                            </div>

                            <spring:bind path="medicalInfo.bloodGroup">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">گروه خونی
                                            <span class="required">*</span>
                                        </label>
                                        <select id="bloodGroup" name="medicalInfo.bloodGroup" path="medicalInfo.bloodGroup"
                                                class="form-control">
                                            <c:forEach items="${bloodGroups}" var="bloodGroup">
                                                <c:choose>
                                                    <c:when test="${userRegister.medicalInfo.bloodGroup == bloodGroup.text}"><option value="${bloodGroup.text}" selected="selected">${bloodGroup.value}</option></c:when>
                                                    <c:otherwise><option value="${bloodGroup.text}">${bloodGroup.value}</option></c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="medicalInfo.surgeryHistory">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">سابقه جراحی
                                            <span class="required">*</span>
                                        </label>
                                        <select id="surgeryHistory" name="medicalInfo.surgeryHistory" path="medicalInfo.surgeryHistory"
                                                class="form-control">
                                            <c:forEach items="${trueFalseEnum}" var="tfm">
                                                <c:choose>
                                                    <c:when test="${userRegister.medicalInfo.surgeryHistory == tfm.value}"><option value="${tfm.value}" selected="selected">${tfm.text}</option></c:when>
                                                    <c:otherwise><option value="${tfm.value}">${tfm.text}</option></c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="medicalInfo.surgeryType">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">نوع جراحی
                                            <span class="required"></span>
                                        </label>
                                        <input class="form-control" type="text" min="0" name="medicalInfo.surgeryType" value="${userRegister.medicalInfo.surgeryType}">
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="medicalInfo.previousSickness">
                                <div class="col-md-4 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">بیماری قبلی
                                            <span class="required">*</span>
                                        </label>
                                        <select id="previousSickness" name="medicalInfo.previousSickness" path="medicalInfo.previousSickness"
                                                class="form-control">
                                            <c:forEach items="${trueFalseEnum}" var="tfm">
                                                <c:choose>
                                                    <c:when test="${userRegister.medicalInfo.previousSickness == tfm.value}"><option value="${tfm.value}" selected="selected">${tfm.text}</option></c:when>
                                                    <c:otherwise><option value="${tfm.value}">${tfm.text}</option></c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                            </spring:bind>

                            <spring:bind path="medicalInfo.description">
                                <div class="col-md-8 col-sm-12 col-xs-12 form-group">
                                    <div class="input-group input-group-sm">
                                        <label class="input-group-addon">توضیحات</label>
                                        <input class="form-control" type="text" min="0" name="medicalInfo.description"
                                               maxlength="100" id="description" value="${userRegister.medicalInfo.description}">
                                    </div>
                                </div>
                            </spring:bind>

                            <div class="col-md-12 col-sm-12 col-xs-12 text-left">
                                <button class="btn btn-success" type="submit">ذخیره</button>
                                <a href="${pageContext.request.contextPath}/dashboard/" class="btn btn-default">بازگشت</a>
                            </div>

                            <spring:bind path="naturalPerson.message">
                                <input name="naturalPerson.message" path="naturalPerson.message" id="message" value="${userRegister.naturalPerson.message}" hidden="true">
                            </spring:bind>
                        </form:form>

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
    <script src="${pageContext.request.contextPath}/static/scripts/nationalCodeCheck.js"></script>
    <script src="${pageContext.request.contextPath}/static/scripts/utils.js"></script>

    <script src="${pageContext.request.contextPath}/static/JalaliJSCalendar-1.4/jalali.js"></script>
    <script src="${pageContext.request.contextPath}/static/JalaliJSCalendar-1.4/calendar.js"></script>
    <script src="${pageContext.request.contextPath}/static/JalaliJSCalendar-1.4/calendar-setup.js"></script>
    <script src="${pageContext.request.contextPath}/static/JalaliJSCalendar-1.4/lang/calendar-fa.js"></script>

    <script>
        Calendar.setup({
            inputField: 'date_input',
            button: 'date_btn',
            ifFormat: '%Y/%m/%d',
            dateType: 'jalali'
        });
    </script>

    <script>
        $(document).ready(function () {
            $('#msg').empty();
            var message = $('#message').val();
            if(message == "01"){
                $('#msg').show().addClass("alert alert-success").append("اطلاعات شما با موفقیت ذخیره شد.<br>");
            }
        });
    </script>

    <script>
        function alphaOnly(event) {
            var key = event.keyCode;
            return ((key >= 65 && key <= 90) || key === 8);
        }

        var citiesByState = ${cities};
        function makeSubmenu(value) {
            if (value.length == 0) document.getElementById("city").innerHTML = "<option></option>";
            else {
                var citiesOptions = "";

                var count = 1;
                var i;
                for (i in citiesByState) {
                    if (citiesByState.hasOwnProperty(i)) {
                        var txt = citiesByState[i];
                        var obj = JSON.parse(txt);
                        if (obj.fkState == value) {
                            citiesOptions += "<option value='" + obj.id + "'>" + obj.name + "</option>";
                        }
                        count++;
                    }
                }
                document.getElementById("city").innerHTML = citiesOptions;
            }
        }
    </script>


</layout:base>