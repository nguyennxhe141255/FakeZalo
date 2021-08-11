<%-- 
    Document   : Login
    Created on : Jun 16, 2021, 10:53:54 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        
        <script src="./main.js"></script>
        <link href="style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="top" style="height: 70px;position: fixed;">
            <div id="header" style="height: 70px;text-align: left">
                <img class="a" src="images/logo.jpg" alt="">
            </div>
        </div>
        <div class="container" style="padding-top: 79px;background: url('images/mau-powerpoint-chao-mung-dep-nhat.jpg') ;">
            <div class="form-content-login">
                <div class="form-header">
                    <h1>login</h1>
                </div>
                <form action="LoginController" method="POST" class="form-tinh" >
                    <div class="input-wrapper">
                        <input  type="text" name="username" placeholder="username" >
                    </div>
                    <div class="input-wrapper">
                        <input  type="password" name="password" placeholder="password" >
                    </div> 
                    <center>
                        <div >
                            <button  type="submit">Login</button>
                        </div>

                </form> 
                <div style="color: red;">
                    <br><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%>
                    <br>
                    <a href="Register.jsp">Register</a>
                </div>
                </center> 
            </div>
        </div>
    </body>
</html>
