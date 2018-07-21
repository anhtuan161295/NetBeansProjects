/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Employee;
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
public class EmployeeFacade {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext(name = "EAD_ExamPU")
    private EntityManager em;

    public List<Employee> getAll() {
        Query q = em.createNamedQuery("Employee.findAll", Employee.class);
        return q.getResultList();
    }

    public Employee getEmployee(String id) {
        Query q = em.createNamedQuery("Employee.findByEmployeeID", Employee.class);
        q.setParameter("employeeID", id);
        Employee e = (Employee) q.getSingleResult();
        return e;
    }

    public void add(Employee book) {
        try {
            em.persist(book);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean login(String id, String pass) {
        boolean ok = false;
        Employee e = getEmployee(id);
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
