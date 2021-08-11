/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Admin
 */
public class Comment extends Post{
    int idCMT;
    String comment;

   

    public Comment(int idCMT, int idPost, String comment, int idZalo, String firstname, String lastname, String avatar) {
        super(idPost, idZalo, firstname, lastname,  avatar);
        this.idCMT = idCMT;
        this.comment = comment;
    }

    public int getIdCMT() {
        return idCMT;
    }

    public void setIdCMT(int idCMT) {
        this.idCMT = idCMT;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
