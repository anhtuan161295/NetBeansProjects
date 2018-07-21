/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.Users;
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
    @PersistenceContext(name = "EAD_Session11-ejbPU")
    private EntityManager em;

    public List<Users> allUsers() {
        Query q = em.createNamedQuery("Users.findAll", Users.class);
        return q.getResultList();
    }

    public Users findByUsername(String username) {
        Query q = em.createNamedQuery("Users.findByUsername", Users.class);
        q.setParameter("username", username);
        Users user = (Users) q.getSingleResult();
        return user;
    }

    public void add(Users user) {
        try {
            em.persist(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void edit(Users user) {
        try {
            user = em.merge(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String username) {
        try {
            Users users;
            users = em.getReference(Users.class, username);
            users.getUsername();
            em.remove(users);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Users findUser(String id) {
        return em.find(Users.class, id);
    }

    public boolean checkLogin(String user, String pass) {
        Query q = em.createQuery("Select u From Users u Where u.username = :username and u.password = :password ", Users.class);
        q.setParameter("username", user);
        q.setParameter("password", pass);
        try {
            Users u = (Users) q.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkLogin2(String user, String pass) {
        Query q = em.createQuery("Select u From Users u Where u.username = ?1 and u.password = ?2 ", Users.class);
        q.setParameter(1, user);
        q.setParameter(2, pass);
        try {
            Users u = (Users) q.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkLogin3(String user, String pass) {
        Query q = em.createNamedQuery("Users.checkLogin", Users.class);
        q.setParameter("username", user);
        q.setParameter("password", pass);
        try {
            Users u = (Users) q.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
