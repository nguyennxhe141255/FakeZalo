/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Comment;
import Model.Post;
import Model.User;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.function.Consumer;

/**
 *
 * @author Admin
 */
public class DAO {

    Connection cnn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement stm;

    //check User dang nhap
    public boolean getUser(String username, String pass) {
        String sql = "Select * from Users where username='" + username + "' and password='" + pass + "'";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                return true;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                cnn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return false;
    }

    //check trung user
    public boolean checkValiUsername(String username) {
        String sql = "Select * from Users where username='" + username + "'";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;

    }

    //check phone
    public boolean checkValiPhone(String Phone) {
        String sql = "Select * from Users where phone='" + Phone + "'";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;

    }

    //add user
    public void addAnUser(String username, String password, String firstname, String lastname, String phone, boolean gender) {
        String sql = "INSERT INTO [dbo].[Users]([username],[password],[firstname],[lastname],[phone],[avatar],[gender],[background]) VALUES('" + username + "','" + password + "','" + lastname + "','" + firstname + "','" + phone + "','avatar.jpg','" + gender + "','anh-bia-facebook-dep-co-gai-doi-mu.jpg')";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi dang ki " + e.getMessage());
        }
    }

    // ham check pass nhưng luc dau khong can cho vao 
    public boolean checkpass(String password) {
        if (password.length() < 8) {
            return false;
        }

        //Checks each character to see if it is acceptable.
        int countNum = 0, countLow = 0, countUp = 0;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if ('a' <= c && c <= 'z') {
                countLow++;
            }
            if ('A' <= c && c <= 'Z') {
                countUp++;
            }
            if ('0' <= c && c <= '9') {
                countNum++;
            }
        }
        if (countLow != 0 && countNum != 0 && countUp != 0) {
            return true;
        } else {
            return false;
        }
    }

    // lay idZalo khi dang nhap de thao tac
    public int getId(String username, String pass) {
        String sql = "Select [IDzalo] from Users where username='" + username + "' and password='" + pass + "'";
        int id = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                id = rs.getInt(1);
                return id;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                ps.close();
            } catch (Exception e) {
                /* Ignored */ }
            try {
                cnn.close();
            } catch (Exception e) {
                /* Ignored */ }
        }
        return id;
    }

    //show infor
    public User getInfor(int id) {
        String sql = "Select * from Users where IDzalo='" + id + "'";
        User u = null;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                int idzalo = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String avatar = rs.getString(7);
                boolean gender = rs.getBoolean(8);
                String background = rs.getString(9);
                u = new User(idzalo, username, password, firstname, lastname, phone, gender, avatar, background);
                return u;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return u;

    }

    // update infor
    public void updateinfor(String firstname, String lastname, String phone, int id) {
        String sql = "UPDATE [dbo].[Users] SET [firstname] =N'" + firstname + "',[lastname] =N'" + lastname + "',[phone] ='" + phone + "'  WHERE IDZalo='" + id + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi update infor" + e.getMessage());
        }
    }

    //check old pass dung chua
    public boolean checkValiPass(int id, String pass) {
        String sql = "Select * from Users where IDZalo='" + id + "' and password='" + pass + "'";
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                return false;
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    // upddate pass moi
    public void updatePass(int id, String password) {
        String sql = "UPDATE [dbo].[Users] SET password ='" + password + "'  WHERE IDZalo='" + id + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi update pass" + e.getMessage());
        }
    }

    // update avatar vs background
    public void updateImages(int id, String avatar, String background) {
        String sql = "UPDATE [dbo].[Users] SET avatar ='" + avatar + "',[background]='" + background + "'  WHERE IDZalo='" + id + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi update images" + e.getMessage());
        }
    }

    public void updateAvatar(int id, String avatar) {
        String sql = "UPDATE [dbo].[Users] SET avatar =N'" + avatar + "'  WHERE IDZalo='" + id + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi update images" + e.getMessage());
        }
    }

    public void updateBack(int id, String back) {
        String sql = "UPDATE [dbo].[Users] SET [background] =N'" + back + "'  WHERE IDZalo='" + id + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
        } catch (Exception e) {
            System.out.println("loi update images" + e.getMessage());
        }
    }

    // lay list user
    public ArrayList<User> ListUser() {
        String sql = "Select * from Users";
        ArrayList<User> list = new ArrayList<User>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                int idzalo = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String avatar = rs.getString(7);
                boolean gender = rs.getBoolean(8);
                String background = rs.getString(9);
                User u = new User(idzalo, username, password, firstname, lastname, phone, gender, avatar, background);
                list.add(u);
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println("loi roi");
        }
        return list;

    }

    public ArrayList<User> ListUserSearchByName(String n) {
        String sql = "Select * from Users where CONCAT(CONCAT(firstname , ' '),lastname) like N'%" + n + "%'";
        ArrayList<User> list = new ArrayList<User>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            // Iterate through the data in the result set and add it to list.
            while (rs.next()) {
                int idzalo = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String firstname = rs.getString(4);
                String lastname = rs.getString(5);
                String phone = rs.getString(6);
                String avatar = rs.getString(7);
                boolean gender = rs.getBoolean(8);
                String background = rs.getString(9);
                User u = new User(idzalo, username, password, firstname, lastname, phone, gender, avatar, background);
                list.add(u);
            }
        } // Handle any errors that may have occurred.
        catch (Exception e) {
            System.out.println("loi roi");
        }
        return list;

    }

    public void addPost(String status, String image, int idZalo) {
        String sql = "INSERT INTO [dbo].[Post]([status],[image],[idZalo]) VALUES ( N'" + status + "',N'" + image + "','" + idZalo + "')";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("add post bi loi: " + e.getMessage());
        }
    }

    public int countCMTById(int idPost) {
        String sql = "select count(idCMT) from [dbo].[CMT] where idPost ='" + idPost + "'";
        int count = 0;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("loi select post " + e.getMessage());
        }
        return count;
    }

    public void addComment(int idPost, int idZalo, String comment) {
        String sql = "INSERT INTO [dbo].[CMT]([idPost],[idZalo],[comment]) VALUES ('" + idPost + "','" + idZalo + "',N'" + comment + "')";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("add post bi loi: " + e.getMessage());
        }
    }

    public void deleteAPostById(int idPost) {
        String sql = "DELETE FROM [dbo].[Post] WHERE idPost='" + idPost + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("delete post bi loi: " + e.getMessage());
        }
    }

    public ArrayList<Comment> listComment(int idPostx) {
        String sql = "Select * from [dbo].[CMT] c,[dbo].[Post] p,[dbo].[Users] u  where c.idPost = p.idPost and u.IDzalo = c.idZalo and c.idPost='" + idPostx + "'";
        ArrayList<Comment> list = new ArrayList<Comment>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idCMT = rs.getInt(1);
                int idPost = rs.getInt(2);
                int idZalo = rs.getInt(3);
                String comment = rs.getString(4);
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String avatar = rs.getString("avatar");

                Comment c = new Comment(idCMT, idPost, comment, idZalo, firstname, lastname, avatar);
                list.add(c);
            }
        } catch (Exception e) {
            System.out.println("loi select CMT " + e.getMessage());
        }
        return list;
    }

    public void updatePostFull(int idPost, String status, String image) {
        String sql = "UPDATE [dbo].[Post] SET [status] = N'" + status + "', [image] = N'" + image + "' WHERE idPost='" + idPost + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("update bi loi xxxxx " + e.getMessage());
        }
    }

    public void updatePostS(int idPost, String status) {

        String sql = "UPDATE [dbo].[Post] SET [status] = N'" + status + "' WHERE idPost='" + idPost + "'";
        try {
            cnn = new DBContext().getConnection();
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
        }
    }

    public void deleteComment(int idcheck, int check) {
        String sql = "";
        if (check == 1) {
            sql = "DELETE FROM [dbo].[CMT] WHERE idCMT ='" + idcheck + "'";
        } else {
            sql = "DELETE FROM [dbo].[CMT] WHERE idPost ='" + idcheck + "'";
        }
        try {
            cnn = new DBContext().getConnection();
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("delete commnet that bai " + e.getMessage());
        }
    }

    public int getIdpost(int idcomment) {
        String sql = "select idPost FROM [dbo].[CMT] WHERE idCMT ='" + idcomment + "'";
        int id = -1;
        try {

            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
            while (rs.next()) {
                id = rs.getInt(1);
                return id;
            }
        } catch (Exception e) {
            System.out.println("khong tim ra " + e.getMessage());
        }
        return id;
    }

    public void Like(int idPost, int idZalo) {
        String sql = "INSERT INTO [dbo].[Like] ([idPost],[idZalo])VALUES('" + idPost + "','" + idZalo + "')";
        try {

            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("like khong thanh cong " + e.getMessage());
        }
    }

    public boolean checkLike(int idPost, int idZalo) {
        String sql = "SELECT * FROM [dbo].[Like] where [idPost] = '" + idPost + "' and [idZalo]='" + idZalo + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("tim like khong thanh cong " + e.getMessage());
        }
        return false;
    }

    public void disLike(int idPost, int idZalo) {
        String sql = "DELETE FROM [dbo].[Like] where [idPost] = '" + idPost + "' and [idZalo]='" + idZalo + "'";
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  

        } catch (Exception e) {
            System.out.println("dislike khong thanh cong " + e.getMessage());
        }
    }

    public int countLikeByIdPost(int idPost) {
        String sql = "select count(idPost) from [dbo].[Like] where [idPost] = '" + idPost + "'";
        int count = 0;
        try {
            cnn = new DBContext().getConnection();
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);//Thực hiện câu lệnh select  
            while (rs.next()) {
                count = rs.getInt(1);
                return count;
            }
        } catch (Exception e) {
            System.out.println("khong dem duoc like " + e.getMessage());
        }
        return count;
    }

    public ArrayList<Post> listPost() {
        String sql = "select * from [dbo].[Post] p,[dbo].[Users] u where p.idZalo = u.IDzalo ORDER BY idPost DESC";
        ArrayList<Post> list = new ArrayList<Post>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String status = rs.getString(2);
                String image = rs.getString(3);
                int idZalo = rs.getInt(4);
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String avatar = rs.getString("avatar");
                int checkEnd = 0;

                Post post = new Post(idPost, status, image, idZalo, firstname, lastname, avatar, checkEnd);
                list.add(post);
            }
        } catch (Exception e) {
            System.out.println("loi select post " + e.getMessage());
        }
        return list;
    }

    public ArrayList<Post> listPostById(int id) {
        String sql = "select * from [dbo].[Post] p,[dbo].[Users] u where p.idZalo = u.IDzalo and p.idZalo ='" + id + "' ORDER BY idPost DESC";
        ArrayList<Post> list = new ArrayList<Post>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String status = rs.getString(2);
                String image = rs.getString(3);
                int idZalo = rs.getInt(4);
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String avatar = rs.getString("avatar");
                int checkEnd = 0;
                Post post = new Post(idPost, status, image, idZalo, firstname, lastname, avatar, checkEnd);
                list.add(post);
            }
        } catch (Exception e) {
            System.out.println("loi select post " + e.getMessage());
        }
        return list;
    }

    public Post showPostByIdPost(int idPostx) {
        String sql = "select * from [dbo].[Post] p,[dbo].[Users] u where p.idZalo = u.IDzalo and p.idPost ='" + idPostx + "'";
        Post post = null;
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPost = rs.getInt(1);
                String status = rs.getString(2);
                String image = rs.getString(3);
                int idZalo = rs.getInt(4);
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String avatar = rs.getString("avatar");
                int checkEnd = 0;

                post = new Post(idPost, status, image, idZalo, firstname, lastname, avatar, checkEnd);
            }
        } catch (Exception e) {
            System.out.println("loi select post " + e.getMessage());
        }
        return post;
    }

    public ArrayList<Post> listPostUpdate(ArrayList<Post> list) {
        ArrayList<Post> newlist = new ArrayList<Post>();;

        for (Post p : list) {
            Post post = new Post(p.getIdPost(), p.getStatus(), p.getImage(), p.getIdZalo(), p.getFirstname(), p.getLastname(), p.getAvatar(), p.getCheckEnd(), countCMTById(p.getIdPost()), countLikeByIdPost(p.getIdPost()));
            newlist.add(post);
        }
        return newlist;
    }

    
    // tim list user da like 1 bai viet bang idPost
    public ArrayList<User> listLikeByIDPost(int idP){
        String sql="SELECT * FROM [dbo].[Like] l ,  [dbo].Users u where l.idZalo = u.IDzalo and l.idPost='"+idP+"'";
        ArrayList<User> list=new ArrayList<>();
        try {
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idZalo = rs.getInt("idZalo");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String avatar = rs.getString("avatar");
                User u = new User(idZalo, firstname, lastname, avatar);
                list.add(u);
            }
        } catch (Exception e) {
            System.out.println("loi select post " + e.getMessage());
        }
        return list;
    }
    public static void main(String[] args) {
        DAO d = new DAO();
        ArrayList<Post> listPost = d.listPost();
        ArrayList<User> listU=d.listLikeByIDPost(3063);
        for (User user : listU) {
            System.out.println(user.getIdZalo());
        }
    }
}
