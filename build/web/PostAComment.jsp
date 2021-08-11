<%-- 
    Document   : newjsp
    Created on : Jul 7, 2021, 10:46:07 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="input.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="ok" method="POST">
        <div style="padding-top: 10px;display: flex">
            <div style="padding-right: 10px;"><img style="width: 30px;height: 30px;border-radius:50%;" src="images/<%=avatar%>"></div>
                <div style="padding-right: 5px;width: 100%;">
                    <input class="dep" style="border: 0px;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.5);width: 100%;" 
                           type="text" name="comment" placeholder="comment here <%=lastname%>" value="<%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%>">
                </div>
                <div>
                    <button style="display: flex;" type="submit">
                        <p style="padding-top: 3px;padding-left: 10px;color: black;">Post</p><img src="images/post.png">
                    </button>
                </div>  
                
            </div>
            <div>
                <%=(request.getAttribute("message")) == null ? "" : request.getAttribute("message")%>
                </div>
                <div style="width: 0%;height: 0%">
                    <input class="dep" style="border: 0px;width: 0%;height: 0%" 
                           type="text" name="code" value="<%=code%>" >
                </div>
            </form>
    </body>
</html>
