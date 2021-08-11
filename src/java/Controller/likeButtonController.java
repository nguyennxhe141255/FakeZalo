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
@WebServlet(name = "w", urlPatterns = {"/w"})
public class likeButtonController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        DAO d = new DAO();
        HttpSession session = request.getSession();
        if (session.getAttribute("id") != null) {
            String idZ = (String) session.getAttribute("id");
            int idZalo = Integer.parseInt(idZ);
            String idP = request.getParameter("idPostx");
            int idPost = Integer.parseInt(idP);
            if (d.checkLike(idPost, idZalo) == true) {
                d.disLike(idPost, idZalo);
                if (d.countLikeByIdPost(idPost) <= 1) {
                    out.print(d.countLikeByIdPost(idPost) + " Like");
                } else {
                    out.print(d.countLikeByIdPost(idPost) + " Likes");
                }

            } else {
                d.Like(idPost, idZalo);
                if (d.countLikeByIdPost(idPost) <= 1) {
                    out.print(d.countLikeByIdPost(idPost) + " Like");
                } else {
                    out.print(d.countLikeByIdPost(idPost) + " Likes");
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
