/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
 
import javax.persistence.*;
/**
 *
 * @author Elena_Kholkina
 */
@Entity
@Table(name = "users")
public class Users  {
   
    @Id
    @GeneratedValue
    @Column(name = "userid")
    private Long userid;
    @Column(name = "username")
    private String username;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    public Users() {
    }

    public Users(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
