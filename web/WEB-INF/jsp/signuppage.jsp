<%-- 
    Document   : signuppage
    Created on : 12-Sep-2018, 23:59:09
    Author     : DEXTER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up</title>
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/system/logo.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"/>--%>
        <script src="${pageContext.request.contextPath}/resources/js/jQueryFile.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
    </head>
    <body class="container" style="background-color: rgba(249,251,250, 0.2);">
        
        <div class="row">
            <div>
                <div>
                <h1>
                    <a href="/memelogic">
                        <img style="border-radius: 50%;" src="${pageContext.request.contextPath}/resources/img/system/logo.jpg" width="50" height="50" alt="memelogiclogo"/> Memelogic
                    </a>
                </h1>
                </div>
            </div>
        </div>
        
        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <li><a href="/memelogic">Home</a></li>
                        <li><a href="#">Meme Story</a></li>
                        <li><a href="#">Battle Of The Zexes</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="l_g"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
                  
        <%--<div class="row">
            <div style="background-color: orange; height: 100px; margin-bottom: 20px;">
                For google ad
            </div>
        </div>--%>
                        
        <div class="jumbotron">
            <h2 style="text-align: center; color: blue;">Sign up is absolutely free!!!</h2>
        </div>
                        
        <div class="row">
            <div class="col-sm-4 col-md-4 col-lg-4"></div>
            <div class="col-sm-4 col-md-4 col-lg-4">
                <form style="margin: 0 auto;" method="post" action="sp_">
                    <div class="form-group">
                        <input id="test_User" class="form-control" type="text" name="user" value='${user_val}' placeholder="Username" required="true"/><span style="float: right; color: red;" id='user_Info'>${user_otp}</span><br>
                        <input id="test_Email" class="form-control" type="email" name="email" value='${email_val}' placeholder="E-mail" required="true"/><span style="float: right; color: red;" id='email_Info'>${email_otp}</span><br>
                        <input id="test_Pswd" class="form-control" type="password" name="pswd" placeholder="Password" required="true"/><span style="float: right; color: red;" id='pswd_Info'>${pswd_otp}</span></span><br>
                        
                        <div class="radio-inline">
                            <input type="radio" name="gender" value="Male" checked>Male
                        </div>
                        <div class="radio-inline">
                            <input type="radio" name="gender" value="Female">Female
                        </div><br><br>
                        <input class="btn btn-success" type="submit" value="Submit">
                    </div>
                </form>
            </div>
        </div>
        
        <div class="row">
            <div style="color: white; background-color: rgba(0, 0, 255, 0.9); border-radius: 8px; padding: 10px; text-align: center; font-weight: bold; font-size: 16px;">
                
            </div>
        </div>
        
    </body>
</html>