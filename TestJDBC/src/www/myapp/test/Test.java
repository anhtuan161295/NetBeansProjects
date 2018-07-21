/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.myapp.test;

import java.util.List;
import www.myapp.dao.DBConnection;
import www.myapp.entities.User;

/**
 *
 * @author QQ
 */
public class Test {

    public static void main(String[] args) {
        DBConnection myCon = new DBConnection();
        List<User> getAll = myCon.getList();
        for (User u : getAll) {
            System.out.println("User name: " + u.getUsername());
        }
    }
}
