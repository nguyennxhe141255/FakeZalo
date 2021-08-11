<%-- 
    Document   : Head
    Created on : Jun 30, 2021, 5:07:28 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
        <style>
            .button4 {
                background-color: white;
                color: black;
                border-radius: 0px; 
                width: 100%;
            }
            .button4:hover {background-color: #e7e7e7 ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}     
        </style>
    </head>
    <body>
        <!-- Top -->
        <div id="top" style="height: 70px;position: fixed;">
            <div class="shell" style="height: 70px">
                <!-- Header -->
                <div id="header" style="height: 70px">
                    <div class="nav-left">
                        <div><a href="/Zalo_Fake/listPost"><img class="a" src="images/logo.jpg" alt=""></a></div>

                    </div>
                    <div class="nav-mid">
                        <form action="seachLastName" method="POST">

                            <div class="form-container">
                                <div class="input-wrapper"><input type="text" name="Txtsearch" placeholder="Search""></div>
                                <div class="input-wrapper"><button><img src="images/search.png"></div>
                                        </div>

                                        </div>
                                        <div class="nav-right">
                                            <div class="profile">
                                                <c:if test="${id == null}">
                                                            <button class="button4" >Login<p style="bottom: 8px"></p></button>
                                                </c:if>
                                                <c:if test="${id != null}">
                                                <div class="avatar">
                                                    <a href="UpdateAva.jsp"><img src="images/<%=avatar%>"></a>
                                                </div>
                                                <div class="last-name">
                                                    <a style="text-decoration: none;" href="showInfor?code=<%=(String) session.getAttribute("id")%>">
                                                        <b style="color: black"><%=lastname%></b></a>
                                                </div>
                                                </c:if>
                                            </div>
                                            </form>
                                            <div class="dropdown">
                                                <button class="dropbtn">
                                                    <img src="images/mess.png"></button>
                                                <div class="dropdown-content">
                                                    <a href="#">Link 1</a>
                                                </div>
                                            </div>
                                            <div class="dropdown">
                                                <button class="dropbtn">
                                                    <img src="images/noti.png"></button>
                                                <div class="dropdown-content">
                                                    <a href="#">Link 1</a>
                                                </div>
                                            </div>
                                            <div class="dropdown">
                                                <button class="dropbtn">
                                                    <img src="images/menu.png"></button>
                                                <div class="dropdown-content">
                                                    <a href="UpdateInfor.jsp"><center>Information</center></a>
                                                    <a href="PostListUser"><center>List friends</center></a>
                                                    <form action="logout" method="GEST">
                                                        <c:if test="${id == null}">
                                                            <button class="button4" >Login<p style="bottom: 8px"></p></button>
                                                        </c:if>
                                                        <c:if test="${id != null}">
                                                        <button class="button4" ><img style="padding-top: 2px" src="images/logout.png"><p style="bottom: 8px"></p></button>
                                                        </c:if>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                            </div>
                    </div>        
    </body>
</html>
