<%-- 
    Document   : updateAva
    Created on : Jun 27, 2021, 1:08:47 PM
    Author     : Admin
--%>

<%-- 
    Document   : newjsp
    Created on : Jul 15, 2021, 10:10:38 PM
    Author     : Admin
--%>

<%@page import="Model.User"%>
<%@page import="DAO.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="input.css" rel="stylesheet" type="text/css"/>
        <style>
            #first_element {
                position: relative;
                top: 10px;
                height: 200px;
                width: 100%;
                border: solid 3px white;
                font-size: 24px;
                text-align: center;
            }

            #second_element {
                position: relative;
                bottom: 70px;
                height: 120px;

                width: 120px;
                border-radius:50%;
                font-size: 24px;
                text-align: center;
            }
            .button4x {
                background-color: white;
                color: black;
                border-radius: 0px; 
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.09), 0 6px 20px 0 rgba(0, 0, 0, 0.09)
            }
            .button4x:hover {background-color: #e7e7e7 ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}
        </style>
    </head>
    <body>
        <%
            String id = "";
            String firstname = "";
            String lastname = "";
            String phone = "";
            String gender = "";
            String avatar = "";
            String background = "";
            if (session.getAttribute("id") != null) {
                id = (String) session.getAttribute("id");

                int idZalo = Integer.parseInt(id);
                DAO d = new DAO();
                User u = d.getInfor(idZalo);
                firstname = u.getFirstname();
                lastname = u.getLastname();
                phone = u.getPhone();
                if (u.isGender() == true) {
                    gender = "male";
                } else {
                    gender = "female";
                }
                avatar = u.getAvatar();
                background = u.getBackground();
            } else {
                request.setAttribute("message", "you need to login first,<a href='Login.jsp'>click here</a> to back login");
            }
        %>
        <%@include file="Head.jsp" %>
        <div class="nav-right" style="padding-left: 32%;padding-top:70px">
            <div style="border-right: 1px solid black"><a href="UpdateInfor.jsp">Information</a></div>
            <div style="border-right: 1px solid black;padding-left: 10px"><a href="UpdatePass.jsp">Password</a></div>
            <div style="border-right: 1px solid black;padding-left: 10px"><a href="UpdateAva.jsp">BackGround</a></div>
            <div style="padding-left: 10px"><a href="UpdateAvaN.jsp">Avatar</a></div>
        </div>
        <div style="margin: 0 auto; width: 40%;
             padding: 20px" >                        
            <form action="uploadFile2?action=3" method="post" enctype="multipart/form-data">
            <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding: 30px; border-radius: 10px">
                <div class="form-header">
                    <h1 style="font-size: 20px;">Update Avatar</h1>
                </div>
                <div class="input-wrapper">
                    <input class="dep" type="file" name="avatar" placeholder="link avatar" value="<%=avatar%>">
                </div>
                <div>
                    <body>
                        <div id='first_element'>
                            <img class="back" style="width: 100%;height: 200px;" src="images/<%=background%>">
                        </div>
                    <center>
                        <div id='second_element'>
                            <img class="avatar" style="width: 120px; height: 120px;border-radius:50%;" src="images/<%=avatar%>">
                            <div>
                                <b style="font-size: 16px;"></b>
                            </div>
                        </div>
                        <div>

                        </div>
                    </center>
                </div>        
                <div style="margin: 0 auto; color: red">
                    <br>
                </div>
                <br><br>
                <center>
                    
                    <%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%><br><br>
                    <div style="padding-left: 40.5%;display: flex;">
                        <button  class="button4x" type="submit" name="submit" value="update">update</button>
                    </div>
                </center>
            </div>
        </div>
        </form>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                var readURL = function (input) {
                    if (input.files && input.files[0]) {
                        var reader = new FileReader();

                        reader.onload = function (e) {
                            $('.back').attr('src', e.target.result);
                        }
                        reader.readAsDataURL(input.files[0]);
                    }
                }
                $(".dep").on('change', function () {
                    readURL(this);
                });
            });
        </script>
    </body>
</html>
