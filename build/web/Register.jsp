<%-- 
    Document   : Register
    Created on : Jun 16, 2021, 10:54:26 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Register</title>

        <script src="./main.js"></script>
        <link href="input.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="top" style="height: 70px;position: fixed;">
            <div id="header" style="height: 70px;float: left">
                <img class="a" src="images/logo.jpg" alt="">
            </div>
        </div>
        
        <div class="container" style="padding-top: 77px">
            <div class="form-content-register" style="height: 500px;">
                <div class="form-header">
                    <h1>register</h1>
                </div>
                <form action="registerController" method="POST" class="form-tinh">
                    <div class="input-wrapper">
                        <input class="dep" type="text" name="username" placeholder="username" value="<%=(request.getAttribute("username")) == null ? "" : request.getAttribute("username")%>">
                    </div>
                    <div class="input-wrapper">
                        <input class="dep" type="password" name="password" placeholder="password" value="<%=(request.getAttribute("password")) == null ? "" : request.getAttribute("password")%>">
                    </div>
                    <div class="input-wrapper">
                        <input class="dep" type="password" name="password1" placeholder="re-password" value="<%=(request.getAttribute("password1")) == null ? "" : request.getAttribute("password1")%>">
                    </div>  

                    <div class="input-wrapper">
                        <input class="dep" type="text" name="firstname" placeholder="your Last-name" value="<%=(request.getAttribute("firstname")) == null ? "" : request.getAttribute("firstname")%>">
                    </div>
                    <div class="input-wrapper">
                        <input class="dep" type="text" name="lastname" placeholder="your First-name" value="<%=(request.getAttribute("lastname")) == null ? "" : request.getAttribute("lastname")%>">
                    </div>
                    <div class="input-wrapper">
                        <input class="dep" type="text" name="phone" placeholder="your phone number" value="<%=(request.getAttribute("phone")) == null ? "" : request.getAttribute("phone")%>">
                    </div>
                    <b style="padding-left: 170px"><em><input  ${male} type="radio" name="radio" required value="true">male</em></b></td>
                    <b><em><input style="padding-left: 20px"  ${female} type="radio" name="radio" required value="false">female</em></b></td>
                    <center>
                        <div>
                            <button  type="submit">Register</button>
                        </div>
                </form>
                <div style="color: red">
                    <br><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%>
                    <br>
                </div>
                <div>
                    <a href="Login.jsp">Login, if you have account</a>
                </div>
                </center>
            </div>
        </div>
    </body>
</html>
