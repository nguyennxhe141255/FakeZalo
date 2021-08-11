/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
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
@WebServlet(name = "updatePass", urlPatterns = {"/updatePass"})
public class updatePass extends HttpServlet {

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
            HttpSession session = request.getSession();
            if(session.getAttribute("id")==null){
                out.print("You need to login first");
                return;
            }else{
                int idZalo = Integer.parseInt((String) session.getAttribute("id"));
                DAO d = new DAO();
                String password = request.getParameter("oldpass");
                String password1 = request.getParameter("newpass");
                String password2 = request.getParameter("newpass1");
                request.setAttribute("old", password);
                request.setAttribute("new", password1);
                request.setAttribute("new2", password2);
                if(d.checkValiPass(idZalo, password)){
                request.setAttribute("message", "wrong old password");
                request.getRequestDispatcher("UpdatePass.jsp").forward(request, response);
                }else if(password1.equals(password2)==false){
                request.setAttribute("message", "two new password is not the same");
                request.getRequestDispatcher("UpdatePass.jsp").forward(request, response);   
                }else{
                d.updatePass(idZalo, password1);
                request.setAttribute("message", "update successfull");
                request.getRequestDispatcher("UpdatePass.jsp").forward(request, response); 
                }
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
