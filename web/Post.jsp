<%-- 
    Document   : Post
    Created on : Jul 6, 2021, 11:06:18 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Post"%>
<%@page import="Model.User"%>
<%@page import="DAO.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>

        <style>
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
            /* Style The Dropdown Button */
            .dropbtn {
                background-color: white;
                color: white;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }

            /* The container <div> - needed to position the dropdown content */
            .dropdown {

                display: inline-block;
            }

            /* Dropdown Content (Hidden by Default) */
            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1000;
            }

            /* Links inside the dropdown */
            .dropdown-content a {
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
            }

            /* Change color of dropdown links on hover */
            .dropdown-content a:hover {background-color: #f1f1f1}

            /* Show the dropdown menu on hover */
            .dropdown:hover .dropdown-content {
                display: block;
            }

            /* Change the background color of the dropdown button when the dropdown content is shown */
            .dropdown:hover .dropbtn {
                background-color: 	#ADD8E6;
            }
            .button2 {
                background-color: white; 
                color: black; 
                border: 2px solid #008CBA;
            }

            .button2:hover {
                background-color: #008CBA;
                color: white;
            }
            .hinhanh{
                height: 100%;
                width: 100%;
                box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);object-fit: cover;
                object-position: center;
                border-radius: 10px;
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
                out.println("you need login first,<a href='Login.jsp'>click here</a> to back login");
            }

        %>
        <%            String avatarPost = "";
            String firstNamePost = "";
            String lastNamePost = "";
            String status = "";
            String image = "";
            int count = 0;
            int code = 0;
            int likes=0;
            if (request.getAttribute("idPost") != null) {
                code = Integer.parseInt((String) request.getAttribute("idPost"));

                DAO d = new DAO();
                Post post = d.showPostByIdPost(code);
                avatarPost = post.getAvatar();
                firstNamePost = post.getFirstname();
                lastNamePost = post.getLastname();
                status = post.getStatus();
                image = post.getImage();
                count = d.countCMTById(code);
                likes = d.countLikeByIdPost(code);
            }
        %>
        <%@include file="Head.jsp" %>
        <div style="padding-top: 90px;">

        </div>
        <div style="margin: 0 auto; width: 40%;padding: 20px ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;"> 
            <div style="display: flex;">
                <div><img style="width: 30px; height: 30px;border-radius:50%;" src="images/<%=avatarPost%>"></div>
                <div><b style="font-size: 16px;padding-left: 10px;"> <%=firstNamePost%> <%=lastNamePost%></b></div>
            </div>
            <div style="padding: 10px;"><%=status%>
            </div>
            <div>
                <%
                    if (image.equals("") == false) {
                        out.print("<img class='hinhanh' src='images/" + image + "'>");
                    }else{
                        out.print("");
                    }
                %>
            </div>
            <div style="display: flex; height: 40px;border-bottom: 1px black solid;">
                <div class="dropdown" style="width: 30px;height: 30px; float: left;">
                    <button class="dropbtn">
                        <img style="height: 20px;" src="https://img.icons8.com/fluent-systems-filled/48/000000/facebook-like.png"/>
                    </button>
                    <div class="dropdown-content">
                        <c:forEach items="${listU}" var="u">
                        <a href="showInfor?code=${u.getIdZalo()}">${u.getFirstname()} ${u.getLastname()}</a>
                        </c:forEach>
                    </div>
                </div>
                <div><p style="padding: 11px;font-size: 13px;"><%=likes%> Like</p></div>
                <div style="padding-left: 70%;">
                    <p style="padding: 11px;font-size: 13px;"><%=count%> comments</p>
                </div>
            </div>

            <c:forEach items="${listCMT}" var="item">
                <div style="padding-top: 20px"></div>
                <div style="display: flex;"> 
                    <div style="padding-top: 10px"><img style="width: 30px; height: 30px;border-radius:50%;" src="images/${item.getAvatar()}"></div>
                    <div style="padding-left: 10px;"></div>
                    <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 5px;width: 100%;">
                        <div style="display: flex;">
                            <div style="padding-top: 5px"><a style="text-decoration: none;" href="showInfor?code=${item.getIdZalo()}"><b style="font-size: 13px;padding-left: 10px; color: black;padding-top: 5px">
                                        ${item.getFirstname()} ${item.getLastname()}</b></a></div>
                            <div style="float: right;text-align: right;padding-left: 70%" >
                                <c:if test="${item.getIdZalo()==id}">

                                    <div class="dropdown" >
                                        <div style="width: 50px;height: 30px">
                                            <button class="buttonx" ><img style="" src="images/outline_reorder_black_24dp.png"></button>
                                        </div>
                                        <div class="dropdown-contentx">
                                            <form action="updateAnDeleteCMT?code=${item.idCMT}" method="POST">
                                                <div>
                                                    <button class="buttoncheck" name="action" value="update"><img src="images/edit.png" alt="update this Post"></button>
                                                </div>
                                                <div style="padding-top: 5px">
                                                    <button class="buttoncheck" name="action" value="delete"><img src="images/delete.png" alt="delete this Post"></button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </c:if> 
                            </div>
                        </div>
                        <div style="padding: 6px;">${item.getComment()}
                        </div>
                    </div>
                </div>
            </c:forEach>

            <div style="padding-top: 20px">
                <%@include file="PostAComment.jsp" %>
            </div>  
        </div>
    </body>
</html>
