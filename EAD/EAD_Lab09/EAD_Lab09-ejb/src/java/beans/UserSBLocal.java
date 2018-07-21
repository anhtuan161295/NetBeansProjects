/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author QQ
 */
@Local
public interface UserSBLocal {
    
    List<Users> allUsers();
    boolean add(Users user);
    void edit(Users user);
    void delete(String id);
    
}
