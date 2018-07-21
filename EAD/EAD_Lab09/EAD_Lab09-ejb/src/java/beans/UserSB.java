/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controller.UsersJpaController;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author QQ
 */
@Stateless
public class UserSB implements UserSBLocal {

    EntityManagerFactory emf = null;
    UsersJpaController jpa = null;

    public boolean open() {
        boolean ok = false;
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("EAD_Lab09-ejbPU");
            jpa = new UsersJpaController(emf);
            if (emf.isOpen()) {
                ok = true;
            }
        }
        return ok;
    }

    public void close() {
        emf.close();
        emf = null;
        jpa = null;
    }

    @Override
    public List<Users> allUsers() {
        List<Users> list = new ArrayList<>();
        if (open()) {
            list = jpa.findUsersEntities();
        }
        close();
        return list;
    }

    @Override
    public boolean add(Users user) {
        boolean ok = false;
        if (open()) {
            try {
                jpa.create(user);
                ok = true;
            } catch (Exception e) {
                ok = false;
            }
        }
        close();
        return ok;
    }

    @Override
    public void edit(Users user) {
    }

    @Override
    public void delete(String id) {
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
