/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Post extends User {

    private int idPost;
    private String status, image;
    private int like,count;
    private int checkEnd;
    private ArrayList<User> listlikes;
    
    public Post(int idPost, String status, String image, int idZalo, String firstname, String lastname, String avatar, int checkEnd, int count,int like) {
        super(idZalo, firstname, lastname, avatar);
        this.idPost = idPost;
        this.status = status;
        this.image = image;
        this.like = like;
        this.checkEnd = checkEnd;
        this.count =count;
    }
    public Post(int idPost, String status, String image, int idZalo, String firstname, String lastname, String avatar, int checkEnd, int count,int like,ArrayList<User> listlikes) {
        super(idZalo, firstname, lastname, avatar);
        this.idPost = idPost;
        this.status = status;
        this.image = image;
        this.like = like;
        this.checkEnd = checkEnd;
        this.count =count;
        this.listlikes=listlikes;
    }
    
    public Post(int idPost, String status, String image, int idZalo, String firstname, String lastname, String avatar, int checkEnd) {
        super(idZalo, firstname, lastname, avatar);
        this.idPost = idPost;
        this.status = status;
        this.image = image;
        this.like = like;
        this.checkEnd = checkEnd;
    }
    
     public Post(int idPost, String status, String image, int idZalo, String firstname, String lastname, String avatar, int checkEnd, int count) {
        super(idZalo, firstname, lastname, avatar);
        this.idPost = idPost;
        this.status = status;
        this.image = image;
        this.like = like;
        this.checkEnd = checkEnd;
        this.count =count;
    }
    
    public Post(int idPost, int idZalo, String firstname, String lastname, String avatar) {
        super(idZalo, firstname, lastname, avatar);
        this.idPost = idPost;
    }

    public Post(int idPost, String status, String image, int like, int idZalo, String username, String password, String firstname, String lastname, String phone, String avatar, boolean gender) {
        super(idZalo, username, password, firstname, lastname, phone, avatar, gender);
        this.idPost = idPost;
        this.status = status;
        this.image = image;
        this.like = like;
    }

    public ArrayList<User> getListlikes() {
        return listlikes;
    }

    public void setListlikes(ArrayList<User> listlikes) {
        this.listlikes = listlikes;
    }

    public int getCheckEnd() {
        return checkEnd;
    }

    public void setCheckEnd(int checkEnd) {
        this.checkEnd = checkEnd;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
