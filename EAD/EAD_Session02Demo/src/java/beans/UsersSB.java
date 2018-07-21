/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controller.UsersJpaController;
import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author QQ
 */
@Stateless
public class UsersSB implements UsersSBLocal {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("EAD_Session02DemoPU");
    private final UsersJpaController userController = new UsersJpaController(emf);

    @Override
    public void add(Users user) {
        try {
            userController.create(user);
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Users user) {
        try {
            userController.edit(user);
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(String uername) {
        try {
            userController.destroy(uername);
        } catch (Exception e) {
        }
    }

    @Override
    public List<Users> allUsers() {
        return userController.findUsersEntities();
    }

}
