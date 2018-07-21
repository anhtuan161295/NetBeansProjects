/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author QQ
 */
public class UserController {

    private User user;

    /**
     * Creates a new instance of UserController
     */
    public UserController() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String createUser() {
        System.out.println("User Created");
        // insert user to database or list

        return "Welcome";

    }

}
