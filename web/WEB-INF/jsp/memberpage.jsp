<%-- 
    Document   : memberpage
    Created on : 16-Sep-2018, 21:20:03
    Author     : DEXTER
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account</title>
        <link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/img/system/logo.jpg"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mystyle.css"/>--%>
        <script src="${pageContext.request.contextPath}/resources/js/jQueryFile.js"></script>
        <script src="${pageContext.request.contextPath}/resources/js/myscript.js"></script>
    </head>
    
    <body class="container">
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
        </div>
        
        <div class="row">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <ul class="nav navbar-nav">
                        <%--<li style="display: ${disp2};"><a href="#">${user}</a></li>--%>
                        <li class="${home_active1}"><a href="">Home</a></li>
                        <li><a href="#">Profile</a></li>
                        <li><a href="#">Meme Story</a></li>
                        <li><a href="#">Battle Of The Zexes</a></li>
                        <li><a href="#">Ad</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
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
                <div class="col-sm-4 col-md-4 col-lg-4">
                    <div class="row">
                        <a href="#">
                            <img class="img-rounded" src="${pageContext.request.contextPath}/resources/img/general/leopard.jpg" alt="Lights" style="width:100%"/>
                        </a>
                    </div>
                    
                    <div class="row">
                        <div style="background-color: pink; height: 280px; margin-top: 20px; margin-bottom: 20px;">
                            More tabs<br>
                            Statistics<br>
                            Color code etc
                        </div>
                    </div>
                </div>
                        
                <div class="col-sm-8 col-md-8 col-lg-8">
                    <div style="height: 600px; margin-bottom: 20px;">
                        <div style="text-align: center;">
                            <h3>What does this picture portray?</h3>
                            <div class="well">
                                Upload a pic and see reactions
                            </div>
                            <form class="form-inline" method="post" action="post_meme">
                                <div class="form-group">
                                    <input type="file" class="form-control" name="file_img" maxlength="1024" required="true"/>
                                </div>
                                
                                <div class="form-group">
                                    <input type="submit" class="btn btn-success" value="Upload"/>
                                </div>
                            </form>
                        </div>
                        
                        <div style="text-align: center; display: none;">
                            My meme story
                            <form>
                                <div class="form-group">
                                    <textarea style="text-align: justify;" class="form-control" name="meme_story" cols="50" rows="10" required="true" 
                                    placeholder="Uploaded images will appear in a tag like so <_image.jpg_>. You can write contents before and/or after the tag to make up your meme story. Do not tamper with the tag else the uploaded image(s) of the tampered tag(s) will not appear."></textarea>
                                </div>
                                
                                <div class="form-group form-inline">
                                    <input type="file" class="form-control" name="file_img" required="true"/>
                                    <button name="meme_btn_upd" type="button" class="btn btn-warning">Upload</button>
                                </div>
                                
                                <div class="form-group">
                                    <input type="submit" class="btn btn-success" value="Finish"/>
                                </div>
                            </form>
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