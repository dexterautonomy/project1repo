<%-- 
    Document   : otpconfpage
    Created on : 16-Sep-2018, 00:26:09
    Author     : DEXTER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm OTP</title>
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/system/logo.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"/>--%>
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
                        <li style="display: ${disp2};"><a href="#">${user}</a></li>
                        <li><a href="/memelogic">Home</a></li>
                        <li><a href="#">Meme Story</a></li>
                        <li><a href="#">Battle of the sexes</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                    </ul>
                </div>
            </nav>
        </div>
                  
                        
                        
        <div class="jumbotron">
            <h2 style="text-align: center; color: blue;">Please enter OTP sent to the e-mail you provided</h2>
        </div>
                        
        <div class="row">
            <div class="col-sm-4 col-md-4 col-lg-4"></div>
            <div class="col-sm-4 col-md-4 col-lg-4">
                <form style="margin: 0 auto;" method="post" action="s_">
                    <div class="form-group">
                        <input class="form-control" type="text" name="otp" placeholder="Enter OTP" required="true"/>${otp}<br>
                        <input class="btn btn-success" type="submit" value="Submit">
                    </div>
                </form>
            </div>
        </div>
        
        <div class="row">
            <div style="background-color: orange; color: red; border-radius: 8px; padding: 10px; text-align: center; font-weight: bold; font-size: 16px;">
                <p>${err_otp}</p>
            </div>
        </div>
        
    </body>
</html>