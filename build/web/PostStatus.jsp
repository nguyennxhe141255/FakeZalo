<%-- 
    Document   : HeaderMain
    Created on : Jun 25, 2021, 9:15:21 PM
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
        <title>Header</title>

        <link href="input.css" rel="stylesheet" type="text/css"/>
        <style>
            .button3 {
                background-color: white;
                color: black;

            }
            .button3:hover {background-color: #e7e7e7;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}
        </style>
    </head>
    <body>

        <div style="padding-top: 70px;"></div>
        <div style="padding-top: 30px;padding: 30px">
            <div style="box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);border-radius: 10px;width: 42%;margin: 0 auto;padding: 5px;">
                <div style="padding: 10px">
                    <form action="addPost" method="POST">
                        <div style="display: flex;">
                            <div style="padding-right: 10px;">
                                <img style="width: 40px; height: 40px;border-radius:50%;" src="images/<%=avatar%>"> 
                            </div>

                            <div style="width: 100%;">
                                <input class="dep" style="border:0px; box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding-right: 10px;" 
                                       type="text" name="status" placeholder="<%=(session.getAttribute("thongbao")) == null ? "what's on you mind? " : session.getAttribute("thongbao")%>">

                            </div>
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
                        <div id="o" style="display: none" >
                            <form action="uploadFile" method="post" enctype="multipart/form-data">
                                <table>
                                    <td>
                                        <input type="file" value="Upload file" name="hinhanh" class="dep"/>
                                    </td>
                                    <td>
                                        <button type="submit">
                                            <img src="images/upload.png">
                                        </button>
                                        </tr</td>
                                </table>
                                <img src="" class="avatar">
                                <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
                                <script type="text/javascript">
                            $(document).ready(function () {
                                var readURL = function (input) {
                                    if (input.files && input.files[0]) {
                                        var reader = new FileReader();

                                        reader.onload = function (e) {
                                            $('.avatar').attr('src', e.target.result);
                                        }
                                        reader.readAsDataURL(input.files[0]);
                                    }
                                }
                                $(".dep").on('change', function () {
                                    readURL(this);
                                });
                            });
                                </script>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
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
    </body>
</html>