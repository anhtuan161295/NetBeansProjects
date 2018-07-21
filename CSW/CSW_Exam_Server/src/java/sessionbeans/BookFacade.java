/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbeans;

import entities.Book;
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
public class BookFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name = "ServerPU")
    private EntityManager em;

    public List<Book> all() {
        Query q = em.createNamedQuery("Book.findAll", Book.class);
        return q.getResultList();
    }

    public List<Book> searchLike(String title) {
        Query q = em.createNamedQuery("Book.findByTitle", Book.class);
        q.setParameter("title", "%" + title + "%");
        return q.getResultList();
    }

    public boolean delete(String code) {
        boolean ok = false;
        try {
            Book book;
            book = em.getReference(Book.class, code);
            book.getCode();
            em.remove(book);
            ok = true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ok = false;
        }
        return ok;
    }

}
