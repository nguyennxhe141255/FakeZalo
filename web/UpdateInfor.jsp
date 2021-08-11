<%-- 
    Document   : UpdateInfor
    Created on : Jun 22, 2021, 7:40:53 PM
    Author     : Admin
--%>

<%@page import="DAO.DAO"%>
<%@page import="Model.User"%>
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
            <div style="border-right: 1px solid black;padding-left: 10px"><a href="UpdateAva.jsp">BackGround</a></div>
            <div style="padding-left: 10px"><a href="UpdateAvaN.jsp">Avatar</a></div>
        </div>
        <div style="margin: 0 auto; width: 40%;padding: 20px" >
            <div style=" box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); padding-bottom: 20px; border-radius: 10px">
                <div class="form-header">
                    <h1 style="font-size: 20px;">Update Information</h1>
                </div>
                <form action="updateInforController" method="POST">

                    <table>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">Firstname :</b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="firstname"  value="<%=firstname%>">
                                </div><br></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">Lastname :</b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="lastname"  value="<%=lastname%>">
                                </div><br></td>
                        </tr>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">Phone :</b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="phone"  value="<%=phone%>">
                                </div><br></td>

                        </tr>
                        <tr>
                            <td><b style="font-size: 15px;padding: 20px;">gender :</b></td>
                            <td><div class="input-wrapper">
                                    <input class="dep" type="text" name="gender" readonly value="<%=gender%>">
                                </div><br></td>
                        </tr>
                    </table>
                    <div style="padding-left:40%; width: 100px; height: 120px; padding-top: 10px;">

                        <img style="width: 130px; height: 150px; border: 1px solid black" src="images/<%=avatar%>" >
                    </div>

                    <br><br><br><br>
                    <center>
                        <%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%><br>
                    </center>
                    <div style="padding-left:40%">


                        <button  type="submit">update</button>
                    </div> 

                </form>
            </div>
        </div>
    </body>
</html>
