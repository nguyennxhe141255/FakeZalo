/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAO;
import java.io.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100
)

public class Upload extends HttpServlet {

    private static final long SerialVersionUID = 1L;
    private static final String UPLOAD_DIR = "images";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String radio = request.getParameter("radio");
        request.setAttribute("message", "upload thanh cong " + radio);
        DAO d = new DAO();
        HttpSession session = request.getSession();
        String idZ = (String) session.getAttribute("id");
        int idZalo = Integer.parseInt(idZ);
        d.updateAvatar(idZalo, uploadFile(request));
        if (radio.equals("yes")) {
            d.addPost("Update new Avatar", uploadFile(request), idZalo);
        }
        request.getRequestDispatcher("UpdateAvaN.jsp").forward(request, response);
    }

    private String uploadFile(HttpServletRequest request) throws IOException, ServletException {
        String fileName = "";
        try {
            Part filePart = request.getPart("avatar");
            fileName = (String) getFileName(filePart);
            String applicationPath = request.getServletContext().getRealPath("");
            String basePath = applicationPath + File.separator + UPLOAD_DIR + File.separator;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            System.out.println(basePath);
            try {
                File outputFilePath = new File(basePath + fileName);
                inputStream = filePart.getInputStream();
                outputStream = new FileOutputStream(outputFilePath);
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
            } catch (Exception e) {
                e.printStackTrace();
                fileName = "";
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            }

        } catch (Exception e) {
            fileName = "";
        }

        return fileName;
    }

    private String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        System.out.println("*****partHeader :" + partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return renameFile(content.substring(content.indexOf('=') + 1).trim().replace("\"", ""));
            }
        }

        return null;
    }

    public String renameFile(String fileName) {
        String[] arrImg = fileName.split("\\.");
        String duoiFileImg = arrImg[arrImg.length - 1];
        String nameFile = "";
        for (int i = 0; i < (arrImg.length - 1); i++) {
            if (i == 0) {
                nameFile = arrImg[i];
            } else {
                nameFile += "-" + arrImg[i];
            }
        }
        nameFile = nameFile + "-" + System.nanoTime() + "." + duoiFileImg;
        return nameFile;
    }

}
