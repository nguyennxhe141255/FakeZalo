/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "registerController", urlPatterns = {"/registerController"})
public class registerController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            request.setAttribute("username", request.getParameter("username"));
            request.setAttribute("password", request.getParameter("password"));
            request.setAttribute("password1", request.getParameter("password1"));
            request.setAttribute("firstname", request.getParameter("firstname"));
            request.setAttribute("lastname", request.getParameter("lastname"));
            request.setAttribute("phone", request.getParameter("phone"));

            //check empty
            if (request.getParameter("username") == null || request.getParameter("username").isEmpty()) {
                request.setAttribute("message", "username was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (request.getParameter("password") == null || request.getParameter("password").isEmpty()) {
                request.setAttribute("message", "password was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (request.getParameter("password1") == null || request.getParameter("password1").isEmpty()) {
                request.setAttribute("message", "re-password was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (request.getParameter("firstname") == null || request.getParameter("firstname").isEmpty()) {
                request.setAttribute("message", "firstname was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (request.getParameter("lastname") == null || request.getParameter("lastname").isEmpty()) {
                request.setAttribute("message", "lastname was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            if (request.getParameter("phone") == null || request.getParameter("phone").isEmpty()) {
                request.setAttribute("message", "phone was empty!");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            }
            DAO d = new DAO();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String password1 = request.getParameter("password1");
            String firstname = request.getParameter("firstname");
            String lastname = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            String stgender = request.getParameter("radio");
            boolean gender = false;
            if (stgender.equals("true")) {
                gender = true;
            }

            if (!d.checkValiUsername(username)) {
                request.setAttribute("message", "This Username has been used");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else if (password.equals(password1) == false) {
                request.setAttribute("message", "password and re-password are not the same");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } //            //check pass 
            //            if(!d.checkpass(password)){
            //                request.setAttribute("message","password have at least 8 characters and have both uppercase and lowercase");
            //                request.getRequestDispatcher("Register.jsp").forward(request, response);
            //            }
            else if (!phone.matches("^\\d{10}\\d*$")) {
                request.setAttribute("message", "phone number need 10 digits");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else if (!d.checkValiPhone(phone)) {
                request.setAttribute("message", "This Phone number has been used");
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } else {
                d.addAnUser(username, password, firstname, lastname, phone, gender);
                HttpSession session = request.getSession();
                String id = "" + d.getId(username, password);
                session.setAttribute("id", id);
                request.getRequestDispatcher("/listPost").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
