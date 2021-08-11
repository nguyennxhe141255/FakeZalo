<%-- 
    Document   : AAA
    Created on : Jul 8, 2021, 10:58:55 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.User"%>
<%@page import="DAO.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload file in servlet - itphutran.com</title>

        <link href="input.css" rel="stylesheet" type="text/css"/>
        <style>
            .button4 {
                background-color: white;
                color: black;

            }
            .button4:hover {background-color: #e7e7e7;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                padding: 12px 16px;
                z-index: 1;
            }

            .dropdown:hover .dropdown-content {
                display: block;
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
        <%@include  file="Head.jsp" %>


        <div style="padding-top: 77px"></div>
        <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 10px;width: 50%;margin: 0 auto;padding: 5px;">
            <form action="editPost" method="POST">
                <div style="display: flex">
                    <div style="width: 100%;">
                        <input class="dep" style="border:0px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding-right: 10px;" 
                               type="text" name="status" value="<%=(session.getAttribute("status")) == null ? "" : session.getAttribute("status")%>">
                    </div>
                    <div style="padding: 3px"></div>
                    <div><input  style=" border:0px;width: 0px;height: 0px" 
                                 type="text" name="idPost" value="<%=(session.getAttribute("idPost")) == null ? "" : session.getAttribute("idPost")%>"></div>
                         <input  style="border:0px;width: 0px;height: 0px " 
                               type="text" name="buchinh" value="<%=session.getAttribute("newimage") == null ? "null" : session.getAttribute("newimage")%>">
                    <div>
                        <div style="padding-left: 30px;">
                            <button style="display: flex;" type="submit">
                                <p style="padding-top: 3px;padding-left: 20px;color: black;">Post</p><img src="images/post.png">
                            </button>
                        </div>
                    </div>
                </div>
            </form>   

            <div style="border-bottom: black 1px solid;padding: 5px;"></div>
            <div style="padding: 5px;display: flex;">

                <button onclick="myFunction()" class="button3"><img src="images/hinhanh.png"></button>
                <div id="o" style="display: none">
                    <form action="uploadFile2?action=1" method="post" enctype="multipart/form-data">
                        <table>

                            <td>
                                <input class="dep" style="border:0px;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding-right: 10px; " 
                                       <input type="file" value="checklai" name="hinhanh"/>
                            </td>
                            <td>
                                <button class="button4" type="submit" name="aaa" value="aaa">
                                    <img src="images/upload.png">
                                </button>
                                </tr</td>
                        </table>
                    </form>
                </div>
                <script>
                    function myFunction() {
                        var x = document.getElementById("o");
                        if (x.style.display === "block") {
                            x.style.display = "none";
                        } else {
                            x.style.display = "block";
                        }
                    }
                </script>
            </div>
            <%
                if (request.getAttribute("hinhanh") == null) {
                    out.print("");
                } else if ((request.getAttribute("hinhanh")).equals("")) {
                    out.print("");
                } else {
                    out.print("<img style='height: 100%;width: 100%;' src='images/" + request.getAttribute("hinhanh") + "'>");
                }
            %>
            <%
                if (session.getAttribute("newimage") == null) {
                    
                } else {
                    String newimg = (String) session.getAttribute("newimage");
                    if (newimg.equals("")) {
                       
                    } else {
                        out.print("<img style='height: 100%;width: 100%;' src='images/" + newimg + "'>");
                    }
                }
            %>
        </div>
    </body>
</html>
