package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.User;
import DAO.DAO;

public final class newjsp_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Head.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"input.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            #first_element {\n");
      out.write("                position: relative;\n");
      out.write("                top: 10px;\n");
      out.write("                height: 200px;\n");
      out.write("                width: 100%;\n");
      out.write("                border: solid 3px white;\n");
      out.write("                font-size: 24px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #second_element {\n");
      out.write("                position: relative;\n");
      out.write("                bottom: 70px;\n");
      out.write("                height: 120px;\n");
      out.write("\n");
      out.write("                width: 120px;\n");
      out.write("                border-radius:50%;\n");
      out.write("                font-size: 24px;\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .button4x {\n");
      out.write("                background-color: white;\n");
      out.write("                color: black;\n");
      out.write("                border-radius: 0px; \n");
      out.write("                box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.09), 0 6px 20px 0 rgba(0, 0, 0, 0.09)\n");
      out.write("            }\n");
      out.write("            .button4x:hover {background-color: #e7e7e7 ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <style>\n");
      out.write("            .button4 {\n");
      out.write("                background-color: white;\n");
      out.write("                color: black;\n");
      out.write("                border-radius: 0px; \n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .button4:hover {background-color: #e7e7e7 ;box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)}     \n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Top -->\n");
      out.write("        <div id=\"top\" style=\"height: 70px;position: fixed;\">\n");
      out.write("            <div class=\"shell\" style=\"height: 70px\">\n");
      out.write("                <!-- Header -->\n");
      out.write("                <div id=\"header\" style=\"height: 70px\">\n");
      out.write("                    <div class=\"nav-left\">\n");
      out.write("                        <div><a href=\"/Zalo_Fake/listPost\"><img class=\"a\" src=\"images/logo.jpg\" alt=\"\"></a></div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"nav-mid\">\n");
      out.write("                        <form action=\"seachLastName\" method=\"POST\">\n");
      out.write("\n");
      out.write("                            <div class=\"form-container\">\n");
      out.write("                                <div class=\"input-wrapper\"><input type=\"text\" name=\"Txtsearch\" placeholder=\"Search\"\"></div>\n");
      out.write("                                <div class=\"input-wrapper\"><button><img src=\"images/search.png\"></div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"nav-right\">\n");
      out.write("                                            <div class=\"profile\">\n");
      out.write("                                                ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                ");
      //  c:if
      org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
      _jspx_th_c_if_1.setPageContext(_jspx_page_context);
      _jspx_th_c_if_1.setParent(null);
      _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
      if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                <div class=\"avatar\">\n");
          out.write("                                                    <a href=\"UpdateAva.jsp\"><img src=\"");
          out.print(avatar);
          out.write("\"></a>\n");
          out.write("                                                </div>\n");
          out.write("                                                <div class=\"last-name\">\n");
          out.write("                                                    <a style=\"text-decoration: none;\" href=\"showInfor?code=");
          out.print((String) session.getAttribute("id"));
          out.write("\">\n");
          out.write("                                                        <b style=\"color: black\">");
          out.print(lastname);
          out.write("</b></a>\n");
          out.write("                                                </div>\n");
          out.write("                                                ");
          int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
        return;
      }
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            </form>\n");
      out.write("                                            <div class=\"dropdown\">\n");
      out.write("                                                <button class=\"dropbtn\">\n");
      out.write("                                                    <img src=\"images/mess.png\"></button>\n");
      out.write("                                                <div class=\"dropdown-content\">\n");
      out.write("                                                    <a href=\"#\">Link 1</a>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"dropdown\">\n");
      out.write("                                                <button class=\"dropbtn\">\n");
      out.write("                                                    <img src=\"images/noti.png\"></button>\n");
      out.write("                                                <div class=\"dropdown-content\">\n");
      out.write("                                                    <a href=\"#\">Link 1</a>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"dropdown\">\n");
      out.write("                                                <button class=\"dropbtn\">\n");
      out.write("                                                    <img src=\"images/menu.png\"></button>\n");
      out.write("                                                <div class=\"dropdown-content\">\n");
      out.write("                                                    <a href=\"UpdateInfor.jsp\"><center>Information</center></a>\n");
      out.write("                                                    <a href=\"PostListUser\"><center>List friends</center></a>\n");
      out.write("                                                    <form action=\"logout\" method=\"GEST\">\n");
      out.write("                                                        ");
      if (_jspx_meth_c_if_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                        ");
      if (_jspx_meth_c_if_3(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                    </form>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                    </div>        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("        <div class=\"nav-right\" style=\"padding-left: 32%;padding-top:70px\">\n");
      out.write("            <div style=\"border-right: 1px solid black\"><a href=\"UpdateInfor.jsp\">Information</a></div>\n");
      out.write("            <div style=\"border-right: 1px solid black;padding-left: 10px\"><a href=\"UpdatePass.jsp\">Password</a></div>\n");
      out.write("            <div style=\"padding-left: 10px\"><a href=\"UpdateAva.jsp\">Images</a></div>\n");
      out.write("        </div>\n");
      out.write("        <div style=\"margin: 0 auto; width: 40%;\n");
      out.write("             padding: 20px\" >                        \n");
      out.write("            <form action=\"uploadFile2?action=2\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("            <div style=\"box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);padding: 30px; border-radius: 10px\">\n");
      out.write("                <div class=\"form-header\">\n");
      out.write("                    <h1 style=\"font-size: 20px;\">Update Avatar</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"input-wrapper\">\n");
      out.write("                    <input class=\"dep\" type=\"file\" name=\"avatar\" placeholder=\"link avatar\">\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <body>\n");
      out.write("                        <div id='first_element'>\n");
      out.write("                            <img style=\"width: 100%;height: 200px;\" src=\"images/anh-bia-facebook-dep-co-gai-doi-mu.jpg\">\n");
      out.write("                        </div>\n");
      out.write("                    <center>\n");
      out.write("                        <div id='second_element'>\n");
      out.write("                            <img class=\"avatar\" style=\"width: 120px; height: 120px;border-radius:50%;\" src=\"");
      out.print(avatar);
      out.write("\">\n");
      out.write("                            <div>\n");
      out.write("                                <b style=\"font-size: 16px;\"></b>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </center>\n");
      out.write("                </div>        \n");
      out.write("                <div style=\"margin: 0 auto; color: red\">\n");
      out.write("                    <br>\n");
      out.write("                </div>\n");
      out.write("                <br><br>\n");
      out.write("                <center>\n");
      out.write("                    ");
      out.print((request.getAttribute("message")) == null ? "" : request.getAttribute("message"));
      out.write("\n");
      out.write("                    ");
      out.print((request.getAttribute("message")) == null ? "" : request.getAttribute("message"));
      out.write("<br><br>\n");
      out.write("                    <div style=\"padding-left: 40.5%;display: flex;\">\n");
      out.write("                        <button  class=\"button4x\" type=\"submit\" name=\"submit\" value=\"update\">update</button>\n");
      out.write("                    </div>\n");
      out.write("                </center>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        </form>\n");
      out.write("        <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                var readURL = function (input) {\n");
      out.write("                    if (input.files && input.files[0]) {\n");
      out.write("                        var reader = new FileReader();\n");
      out.write("\n");
      out.write("                        reader.onload = function (e) {\n");
      out.write("                            $('.avatar').attr('src', e.target.result);\n");
      out.write("                        }\n");
      out.write("                        reader.readAsDataURL(input.files[0]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                $(\".dep\").on('change', function () {\n");
      out.write("                    readURL(this);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <button class=\"button4\" >Login<p style=\"bottom: 8px\"></p></button>\n");
        out.write("                                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent(null);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                            <button class=\"button4\" >Login<p style=\"bottom: 8px\"></p></button>\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent(null);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${id != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                        <button class=\"button4\" ><img style=\"padding-top: 2px\" src=\"images/logout.png\"><p style=\"bottom: 8px\"></p></button>\n");
        out.write("                                                        ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
