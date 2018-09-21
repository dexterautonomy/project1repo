<%-- 
    Document   : homepage
    Created on : 18-Sep-2017, 23:38:07
    Author     : DEXTER
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MemeLogic</title>
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/system/logo.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"/>--%>
        <script src="${pageContext.request.contextPath}/resources/js/jQueryFile.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
    </head>
    <body class="container" style="background-color: rgba(249,251,250, 0.2);">
        <div class="row">
            <div class="col-sm-6 col-md-5 col-lg-6">
                <div>
                <h1>
                    <a href="/memelogic">
                        <img style="border-radius: 50%;" src="${pageContext.request.contextPath}/resources/img/system/logo.jpg" width="50" height="50" alt="memelogiclogo"/> Memelogic
                    </a>
                </h1>
                </div>
            </div>
            <div class="col-sm-6 col-md-7 col-lg-6" style="display: ${_x};">
                <div style="padding: 15px;">
                    <form class="form-inline" method="post" action="l_">
                        <div class="form-group"> 
                            <input id="login_User" type="text" name="user_login" class="form-control" required="true" placeholder="Username" value="${login_user_val}">
                        </div>
                        <div class="form-group">
                            <input type="password" name="pswd_login" class="form-control" required="true" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-info">Login</button><br>
                        <div id="login_user_Info" style="color: red;">${ban_err}${login_err}</div>
                        <a href="#" style="text-align: center;">Forgot username/password?</a>
                    </form>
                </div>
            </div>
        </div>
        
        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <%--<li style="display: ${disp2};"><a href="#">${user}</a></li>--%>
                        <li class="${home_active1}"><a href="/memelogic">Home</a></li>
                        <li><a href="#">Meme Story</a></li>
                        <li><a href="#">Battle Of The Zexes</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="p_"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li class="${home_active2}"><a href="l_g"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
                 
        <div class="row">
            <div style="background-color: cyan; height: 80px; margin-bottom: 20px; border-radius: 8px;">
                For google ad
            </div>
        </div>
            
        
        <div class="row" style="margin-bottom: 5px;">
            
            <div class="col-sm-8 col-md-9 col-lg-9">
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/img/general/leopard.jpg" alt="Lights" style="width:100%"/>
                        </a>
                        <div style="overflow: auto;">
                            <div style="float: left;">
                                <p>@ <a href="#">Name</a></p>
                            </div>
                            <div style="float: right;">
                                <p>Sept. 9th 2018</p>
                            </div>
                        </div>
                        <div style="text-align: center;">
                            <button class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-thumbs-up"></span> 1122
                            </button>
                            <button class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-eye-open"></span> 1172
                            </button>
                            <a href='#' class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-star"></span> chineduezeigbo [ <span class="glyphicon glyphicon-thumbs-up"></span> 500 ]
                            </a>
                        </div>
                    </div>
                </div>
            
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/img/general/leopard.jpg" alt="Lights" style="width:100%"/>
                        </a>
                        <div style="overflow: auto;">
                            <div style="float: left;">
                                <p>@ <a href="#">Name</a></p>
                            </div>
                            <div style="float: right;">
                                <p>Sept. 9th 2018</p>
                            </div>
                        </div>
                        <div style="text-align: center;">
                            <button class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-thumbs-up"></span> 1122
                            </button>
                            <button class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-eye-open"></span> 1172
                            </button>
                            <a href='#' class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-star"></span> chineduezeigbo [ <span class="glyphicon glyphicon-thumbs-up"></span> 500 ]
                            </a>
                        </div>
                    </div>
                </div>
            
                <div class="col-md-4">
                    <div class="thumbnail">
                        <a href="#">
                            <img src="${pageContext.request.contextPath}/resources/img/general/leopard.jpg" alt="Lights" style="width:100%"/>
                        </a>
                        <div style="overflow: auto;">
                            <div style="float: left;">
                                <p>@ <a href="#">Name</a></p>
                            </div>
                            <div style="float: right;">
                                <p>Sept. 9th 2018</p>
                            </div>
                        </div>
                        <div style="text-align: center;">
                            <button class="btn btn-success btn-sm">
                                <span class="glyphicon glyphicon-thumbs-up"></span> 1122
                            </button>
                            <button class="btn btn-info btn-sm">
                                <span class="glyphicon glyphicon-eye-open"></span> 1172
                            </button>
                            <a href='#' class="btn btn-warning btn-sm">
                                <span class="glyphicon glyphicon-star"></span> chineduezeigbo [ <span class="glyphicon glyphicon-thumbs-up"></span> 500 ]
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            
            
            <div class="col-sm-4 col-md-3 col-lg-3">
                <div style="background-color: pink; height: 90px; margin-bottom: 10px;">
                    For sponsored post
                </div>
                
                <div style="background-color: blue; height: 170px; margin-bottom: 10px;">
                    For normal advert
                </div>
                
                <div style="background-color: orange; height: 170px; margin-bottom: 10px;">
                    For normal advert
                </div>
                
                <div style="background-color: palegreen; height: 170px; margin-bottom: 10px;">
                    For normal advert
                </div>
            </div>
            
        
        </div>
        
        
        
        <div class="row">
            <div style="color: white; background-color: rgba(0, 0, 255, 0.9); height: 100px;">
                
            </div>
        </div>
    </body>
</html>