<%-- 
    Document   : header
    Created on : Jun 27, 2021, 10:23:31 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            .b{

                width: 30px;
                height: 30px;
                border-radius: 50%;
                border: 0px;

            }

            .b1{

                width: 30px;
                height: 30px;
                border-radius: 50%;
                border: 0px;

            }

        </style>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    </head>
    <body>
        <%
            String id = "";
            String firstname = "";
            String lastname = "";
            String phone = "";
            String gender = "";
            String avatar = "";
            String erro = "";
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
            } else {
                request.setAttribute("message", "you need to login first,<a href='Login.jsp'>click here</a> to back login");
            }

        %>
        <%@include file="Head.jsp" %>

        <c:if test="${id !=null}">
            <%@include file="PostStatus.jsp"%>
        </c:if>
        <div style="padding-top: 70px"></div>
    <center><b style="color: red"><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%><br></b></center>
            <c:forEach items="${listPost}" var="item">
                
        <input name="idpost" value="${item.idPost}"style="border: 0px;width: 0px;height: 0px">
        <div style="margin: 0 auto; width: 40%;padding: 20px ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;"> 
            <div style="display: flex;">
                <div><img style="width: 30px; height: 30px;border-radius:50%;" src="images/${item.avatar}"></div>
                <div><a style="text-decoration: none;" href="showInfor?code=${item.idZalo}"><b style="font-size: 20px;padding-left: 10px; color: black;">
                            ${item.firstname} ${item.lastname}</b></a></div>
            </div>
            <div style="padding: 10px;">${item.getStatus()}
            </div>
            <c:if test="${item.getImage()==''}">

            </c:if>
            <c:if test="${item.getImage()!=''}">
                <img style="height: 100%;width: 100%;box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);object-fit: cover;object-position: center;border-radius: 10px;" src="images/${item.getImage()}">
            </c:if>

            <div style="display: flex; height: 40px;border-bottom: 1px black solid;">
                <div style="display: flex">
                    <c:if test="${item.checkEnd == 1}">
                        <div style="padding: 4px">
                            <input  class="b1" style="background: url('images/like2.png') no-repeat;display: block;" type="button" onclick="myFunction1(this,${item.idPost},${item.getLike()})" id="${item.idPost}" >
                        </div>
                    </c:if>
                    <c:if test="${item.checkEnd != 1}">
                        <div style="padding: 4px">
                            <input  class="b" style="display: inline-block; background: url('images/like1.png') no-repeat" type="button" onclick="myFunction1(this,${item.idPost},${item.getLike()})" id="${item.idPost}" >
                        </div>
                    </c:if>
                    <div style="padding-top: 8px;">
                        <c:if test="${item.getLike()<=1}">
                        <b id="i${item.idPost}" style="padding: 11px;font-size: 13px;;">${item.getLike()} Like</b>
                        </c:if>
                        <c:if test="${item.getLike()> 1}">
                        <b id="i${item.idPost}" style="padding: 11px;font-size: 13px;;">${item.getLike()} Likes</b>
                        </c:if>
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
        <div style="padding: 30px">
        </div>
    </c:forEach>
</body>
</html>
