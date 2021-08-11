<%-- 
    Document   : newjsp
    Created on : Jul 2, 2021, 12:50:32 PM
    Author     : Admin
--%>

<%@page import="Model.User"%>
<%@page import="DAO.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                font-size: 24px;
                text-align: center;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            }

            #second_element {
                position: relative;
                bottom: 80px;
                height: 120px;
                border: 2px solid white;
                width: 120px;
                border-radius:50%;
                font-size: 24px;
                text-align: center;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);

            }
            .buttonx {
                background-color: white;
                color: black;
                border-radius: 50%;
                width: 30px;
                height: 30px;
                padding-left:4px;
                padding-top: 4px;
            }
            .buttonx:hover {background-color: #e7e7e7;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.3)}
            .buttoncheck {
                background-color: white;
                color: black;
                border-radius: 0px;
                width: 100%;
                height: 30px;
                padding-left:10px;
                padding-top: 4px;

            }
            .buttoncheck:hover {background-color: #e7e7e7;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.3)}

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-contentx {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                width: 70px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding-top: 10px;
                z-index: 1000;
                border-radius: 10px;
            }

            .dropdown:hover .dropdown-contentx {
                display: block;
            }

            .b{
                display: inline-block;
                width: 30px;
                height: 30px;
                border-radius: 50%;
                border: 0px;
                background: url('images/like1.png') no-repeat
            }
            .b1{
                display: block;
                width: 30px;
                height: 30px;
                border-radius: 50%;
                border: 0px;
                background: url('images/like2.png') no-repeat
            }


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
        <%
            String avatarCode = "";
            String backgroudCode = "";
            String firstnameCode = "";
            String lastnameCode = "";
            if (request.getAttribute("code") != null) {
                String code = (String) request.getAttribute("code");
                int i = Integer.parseInt(code);
                DAO d = new DAO();
                User user = d.getInfor(i);
                avatarCode = user.getAvatar();
                backgroudCode = user.getBackground();
                firstnameCode = user.getFirstname();
                lastnameCode = user.getLastname();
            }
        %>
        <div style="padding-top: 60px">

        </div>
        <div style="margin: 0 auto; width: 60%;padding: 20px ;border-radius: 10px ">
            <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding: 30px">
                <div>
                    <body>
                        <div id='first_element'>
                            <img style="width: 100%;height: 200px;" src="images/<%=backgroudCode%>">
                        </div>

                        <div id='second_element' style="left: 45%">
                            <img style="width: 120px; height: 120px;border-radius:50%;" src="images/<%=avatarCode%>">
                            
                        </div>
                            
                            <div style="width: 100%;position: relative; text-align: center;bottom: 70px;">
                                <b style="font-size: 15px;"><%=firstnameCode%> <%=lastnameCode%></b>
                            </div>
                </div>         
            </div>
        </div>
        <div style="padding-top: 70px"></div>
        <c:forEach items="${listPost}" var="item">
            
            <div style="margin: 0 auto; width: 40%;padding: 20px ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;"> 
                <div style="display: flex;">
                    <div><img style="width: 30px; height: 30px;border-radius:50%;" src="images/${item.avatar}"></div>
                    <div style=""><b style="font-size: 15px; padding-left: 5px">${item.firstname} ${item.lastname}</b></div>
                    <div style="position: relative; text-align: right;padding-left: 63%"></div>
                    <c:if test="${code==id}">
                        <div class="dropdown" style="position: relative; text-align: right;">
                            <div style="width: 50px;height: 30px;">
                                <button class="buttonx" ><img style="" src="images/outline_reorder_black_24dp.png"></button>
                            </div>
                            <div class="dropdown-contentx">

                                <form action="updateAnDelete?code=${item.idPost}" method="POST">
                                    <div>
                                        <button  class="buttoncheck" name="action" value="update"><img src="images/edit.png" alt="update this Post"></button>
                                    </div>
                                    <div style="padding-top: 5px">
                                        <button    class="buttoncheck" name="action" value="delete"><img src="images/delete.png" alt="delete this Post"></button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </c:if>
                </div>      


                <div style="padding: 10px;">${item.getStatus()}
                </div>
                <c:if test="${item.getImage()==''}">

                </c:if>
                <c:if test="${item.getImage()!=''}">
                    <img style="height: 80%;width: 100%;" src="images/${item.getImage()}">
                </c:if> 
                <div style="display: flex; height: 40px;border-bottom: 1px black solid;">
                    <div style="display: flex">
                        <c:if test="${item.checkEnd == 1}">
                            <div style="padding: 4px">
                                <input  class="b1" type="button" onclick="myFunction1(this,${item.idPost},${item.getLike()})" id="${item.idPost}" >
                            </div>
                        </c:if>
                        <c:if test="${item.checkEnd != 1}">
                            <div style="padding: 4px">
                                <input  class="b" type="button" onclick="myFunction1(this,${item.idPost},${item.getLike()})" id="${item.idPost}" >
                            </div>
                        </c:if>
                        <div style="padding-top: 8px;">
                            <b id="i${item.idPost}" style="padding: 11px;font-size: 13px;;">${item.getLike()} Like</b>
                        </div>
                    </div>
                    <script>
                        function myFunction1(btn, idp, idz) {
                            var x = document.getElementById(idp);
                            if (x.style.display == "block") {
                                x.style.display = "inline-block";
                                x.style.background = "url('images/like1.png') no-repeat";
                            } else {
                                x.style.display = "block";
                                x.style.background = "url('images/like2.png') no-repeat";
                            }
                            $.ajax({
                                url: "/Zalo_Fake/w",
                                type: "POST",
                                data: {
                                    idPostx: idp
                                },
                                success: function (response) {
                                    var text = document.getElementById("i" + idp);
                                    text.innerHTML = response;
                                },
                            })
                        }
                    </script>
                    <div style="padding-left: 70%;">
                        <c:if test="${item.getCount() ==0}">
                            <a style="text-decoration: none;" href="showPost?code=${item.idPost}">
                                <p style="padding: 11px;font-size: 13px;">${item.getCount()} comment</p></a>
                            </c:if>
                            <c:if test="${item.getCount() == 1}">
                            <a style="text-decoration: none;" href="showPost?code=${item.idPost}">
                                <p style="padding: 11px;font-size: 13px;">${item.getCount()} comment</p></a>
                            </c:if>
                            <c:if test="${item.getCount() >= 2}">
                            <a style="text-decoration: none;" href="showPost?code=${item.idPost}">
                                <p style="padding: 11px;font-size: 13px;">${item.getCount()} comments</p></a>
                            </c:if>
                    </div>
                </div>
            </div>
            <div style="padding: 30px"></div>
        </c:forEach>
    </body>
</html>
