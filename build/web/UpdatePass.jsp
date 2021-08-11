<%-- 
    Document   : UpdatePass
    Created on : Jun 26, 2021, 9:40:02 AM
    Author     : Admin
--%>

<%@page import="Model.User"%>
<%@page import="DAO.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>updateinfor</title>
        <link href="style.css" rel="stylesheet" type="text/css"/>
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
            <div style="border-right: 1px solid black;padding-left: 10px"><a href="UpdateAva.jsp">Background</a></div>
            <div style="padding-left: 10px"><a href="UpdateAvaN.jsp">Avatar</a></div>
        </div>
        <div style="margin: 0 auto; width: 40%;padding: 20px" >
            <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); padding-bottom: 20px">
                <div class="form-header">
                    <h1 style="font-size: 20px;">Update Information</h1>
                </div>
                <form action="updatePass" method="POST">
                    <table>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">Old-Password: </b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="oldpass" value="<%=(request.getAttribute("old")) == null ? "" : request.getAttribute("old")%>">
                                </div><br></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">New-Password: </b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="newpass" value="<%=(request.getAttribute("new")) == null ? "" : request.getAttribute("new")%>">
                                </div><br></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">ReNew-Password: </b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="newpass1" value="<%=(request.getAttribute("new2")) == null ? "" : request.getAttribute("new2")%>">
                                </div><br></td>
                        </tr>

                    </table>
                    <center>
                        <div style="margin: 0 auto; color: red">
                            <%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%><br>
                        </div>
                    </center>
                    <div style="padding-left:40%">
                        <br><br><br><br><br>
                        <button  type="submit">update</button>
                    </div> 
                </form>
            </div>
        </div>
    </body>
</html>
