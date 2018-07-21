/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.BookBean;
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
public class BookSB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name = "EAD_Lab15-ejbPU")
    private EntityManager em;

    public List<BookBean> getAll() {
        Query q = em.createNamedQuery("BookBean.findAll", BookBean.class);
        return q.getResultList();
    }

    public List<BookBean> search(String title) {
        Query q = em.createNamedQuery("BookBean.findByTitleLike", BookBean.class);
        q.setParameter("title", "%" + title + "%");
        List<BookBean> list = q.getResultList();
        return list;
    }

    public void add(BookBean book) {
        try {
            em.persist(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void update(BookBean book) {
        try {
            book = em.merge(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(String code) {
        try {
            BookBean book;
            book = em.getReference(BookBean.class, code);
            book.getCode();
            em.remove(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public BookBean edit(String code) {
        return em.find(BookBean.class, code);
    }

}
