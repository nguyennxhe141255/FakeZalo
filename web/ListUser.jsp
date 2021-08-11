<%-- 
    Document   : ListUser
    Created on : Jul 2, 2021, 11:10:00 AM
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
            div.show{
                margin: 0 auto; 
                width: 40%;
                padding: 20px;
                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
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
        <%@include file="Head.jsp"%>
        <div style="padding-top: 70px;"></div>
        <center><b style="color: red"><%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%><br></b></center>
        
        <c:if test="${id !=null}">   
        <form action="postList" method="POST">
            <c:forEach items="${list}" var="item">
                <div style="padding-top: 20px;">

                </div>

                <div class="show">
                    <div style="display: flex;">
                        <div>
                            <img style="width: 90px; height: 90px;border-radius:50%;" src="images/${item.getAvatar()}"> 
                        </div>
                        <div>
                            <div><a style="text-decoration: none;" href="showInfor?code=${item.getIdZalo()}">
                                    <b style="font-size: 20px;padding-left: 10px; color: black;">${item.getFirstname()} ${item.getLastname()}
                                        <c:if test="${item.getIdZalo()==id}">
                                            (me)
                                        </c:if>
                                        <c:if test="${item.getIdZalo()!=id}">
                                            
                                        </c:if>
                                    </b></a></div>
                            <div style="padding-left: 10px;">
                                phone : ${item.getPhone()}
                            </div>
                            <div style="padding-left: 10px;">
                                <c:if test="${item.isGender()==true}">
                                    gioi tinh: male  
                                </c:if>
                                <c:if test="${item.isGender()!=true}">
                                    gioi tinh: female 
                                </c:if>

                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </form>
        </c:if> 
    </body>
</html>
