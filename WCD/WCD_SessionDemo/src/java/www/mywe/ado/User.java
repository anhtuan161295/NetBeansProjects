/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.mywe.ado;

/**
 *
 * @author QQ
 */
public class User {

    private String username;
    private String password;
    private String fullname;
    private int level;

    public User() {
    }

    public User(String username, String password, String fullname, int level) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.level = level;
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
