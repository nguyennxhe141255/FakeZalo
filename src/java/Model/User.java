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
public class User {

    private int idZalo;
    private String username, password, firstname, lastname, phone;
    private boolean gender;
    private String avatar,background;

    public User(int idZalo, String firstname, String lastname,String avatar ) {
        this.idZalo = idZalo;
        this.firstname = firstname;
        this.lastname = lastname;
        this.avatar = avatar;
    }
    
    public User(int UderId, String username, String password, String firstname, String lastname, String phone, String avatar) {
        this.idZalo = UderId;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.avatar = avatar;
    }

    public User(int idZalo, String username, String password, String firstname, String lastname, String phone,String avatar ,boolean gender ) {
        this.idZalo = idZalo;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User(int idZalo, String username, String password, String firstname, String lastname, String phone, boolean gender, String avatar, String background) {
        this.idZalo = idZalo;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.gender = gender;
        this.avatar = avatar;
        this.background = background;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getIdZalo() {
        return idZalo;
    }

    public void setIdZalo(int idZalo) {
        this.idZalo = idZalo;
    }
    
   

    public int getUderId() {
        return idZalo;
    }

    public void setUderId(int UderId) {
        this.idZalo = UderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
