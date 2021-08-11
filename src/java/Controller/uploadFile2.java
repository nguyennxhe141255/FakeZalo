/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.uploadFile.renameFile;
import DAO.DAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Admin
 */
@WebServlet(name = "uploadFile2", urlPatterns = {"/uploadFile2"})
public class uploadFile2 extends HttpServlet {

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
            String action = request.getParameter("action");
            HttpSession session = request.getSession();
            String idZ = (String) session.getAttribute("id");
             int idZalo = Integer.parseInt(idZ);
            if (action.equals("1")) {
                DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
                try {
                    List<FileItem> fileItems = upload.parseRequest(request);
                    for (FileItem fileItem : fileItems) {
                        if (!fileItem.isFormField()) {
                            // xử lý file
                            String nameimg1 = fileItem.getName();

                            String nameimg = "";
                            if (nameimg1.endsWith("jpg") || nameimg1.endsWith("gif") || nameimg1.endsWith("png")) {
                                nameimg = renameFile(nameimg1);
                            }
                            if (!nameimg.equals("")) {
                                String dirUrl = request.getServletContext()
                                        .getRealPath("") + File.separator + "images";
                                File dir = new File(dirUrl);
                                if (!dir.exists()) {
                                    dir.mkdir();
                                }
                                String fileImg = dirUrl + File.separator + nameimg;
                                File file = new File(fileImg);
                                try {
                                    fileItem.write(file);
                                    
                                    session.setAttribute("newimage", nameimg);
                                    request.getRequestDispatcher("UpdatePost.jsp").forward(request, response);
                                } catch (Exception e) {
                                    request.getRequestDispatcher("UpdatePost.jsp").forward(request, response);
                                }
                            } else {
                                
                                session.setAttribute("newimage", "");
                                request.getRequestDispatcher("UpdatePost.jsp").forward(request, response);
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            } else if (action.equals("2")) {
                
                DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
                try {
                    String radio = request.getParameter("radio");
                    
                    List<FileItem> fileItems = upload.parseRequest(request);
                    for (FileItem fileItem : fileItems) {
                        if (!fileItem.isFormField()) {
                            // xử lý file
                            String nameimg1 = fileItem.getName();

                            String nameimg = "";
                            if (nameimg1.endsWith("jpg") || nameimg1.endsWith("gif") || nameimg1.endsWith("png")) {
                                nameimg = renameFile(nameimg1);
                            }
                            if (!nameimg.equals("")) {
                                String dirUrl = request.getServletContext()
                                        .getRealPath("") + File.separator + "images";
                                File dir = new File(dirUrl);
                                if (!dir.exists()) {
                                    dir.mkdir();
                                }
                                String fileImg = dirUrl + File.separator + nameimg;
                                File file = new File(fileImg);
                                try {
                                    fileItem.write(file);
                                    DAO d = new DAO();
                                    d.updateAvatar(idZalo, nameimg);
                                    if(radio != null){
                                        d.addPost("Update new Avatar", nameimg, idZalo);
                                    }
                                    request.setAttribute("message", "upload thanh cong "+radio);
                                    request.getRequestDispatcher("UpdateAvaN.jsp").forward(request, response);
                                } catch (Exception e) {
                                    String check = request.getParameter("radio");
                                    DAO d = new DAO();
                                    
                                    request.setAttribute("message", "upload that bai");
                                    request.getRequestDispatcher("UpdateAvaN.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("message", "upload that bai");
                                request.getRequestDispatcher("UpdateAvaN.jsp").forward(request, response);
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
            else if (action.equals("3")) {
                DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
                try {
                    List<FileItem> fileItems = upload.parseRequest(request);
                    for (FileItem fileItem : fileItems) {
                        if (!fileItem.isFormField()) {
                            // xử lý file
                            String nameimg1 = fileItem.getName();

                            String nameimg = "";
                            if (nameimg1.endsWith("jpg") || nameimg1.endsWith("gif") || nameimg1.endsWith("png")) {
                                nameimg = renameFile(nameimg1);
                            }
                            if (!nameimg.equals("")) {
                                String dirUrl = request.getServletContext()
                                        .getRealPath("") + File.separator + "images";
                                File dir = new File(dirUrl);
                                if (!dir.exists()) {
                                    dir.mkdir();
                                }
                                String fileImg = dirUrl + File.separator + nameimg;
                                File file = new File(fileImg);
                                try {
                                    fileItem.write(file);
                                    DAO d = new DAO();
                                    d.updateBack(idZalo, nameimg);
                                    request.setAttribute("message", "upload thanh cong");
                                    request.getRequestDispatcher("UpdateAva.jsp").forward(request, response);
                                } catch (Exception e) {
                                    request.setAttribute("message", "upload that bai");
                                    request.getRequestDispatcher("UpdateAva.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("message", "upload that bai");
                                request.getRequestDispatcher("UpdateAvaN.jsp").forward(request, response);
                            }
                        }
                    }
                } catch (FileUploadException e) {
                    e.printStackTrace();
                }
            }
            
        }
    }

    public static String renameFile(String fileName) {
        return FilenameUtils.getBaseName(fileName) + "-" + System.nanoTime() + "." + FilenameUtils.getExtension(fileName);
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
