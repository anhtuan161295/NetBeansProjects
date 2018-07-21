/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author QQ
 */
@Stateless
@LocalBean
public class UsersSB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name = "CSW_Assignment02_ServerPU")
    private EntityManager em;

    public List<Users> getAll() {
        Query q = em.createNamedQuery("Users.findAll", Users.class);
        return q.getResultList();
    }

    public Users getUser(String username) {
//        Query q = em.createNamedQuery("Users.findByUsername", Users.class);
//        q.setParameter("username", username);
//        List<Users> e = q.getResultList();
//        if (e.isEmpty()) {
//            return null;
//        } else {
//            return e.get(0);
//        }
        return em.find(Users.class, username);
    }

    public boolean add(Users user) {
        boolean ok = false;
        try {
            em.persist(user);
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    public boolean edit(Users user) {
        boolean ok = false;
        try {
            user = em.merge(user);
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    public boolean delete(String username) {
        boolean ok = false;
        try {
            Users users;
            users = em.getReference(Users.class, username);
            users.getUsername();
            em.remove(users);
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

    public boolean login(String id, String pass) {
        boolean ok = false;
        Users e = getUser(id);
        if (e != null) {
            if (e.getPassword().equals(pass)) {
                // success
                ok = true;
            } else {
                // wrong pass
                ok = false;
            }
        } else {
            // invalid
            ok = false;
        }
        return ok;
    }

}
