/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessionbeans.UsersFacade;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "UsersWS")
@Stateless()
public class UsersWS {

    @EJB
    private UsersFacade ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "entity") Users entity) {
        ejbRef.create(entity);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "entity") Users entity) {
        ejbRef.edit(entity);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "entity") Users entity) {
        ejbRef.remove(entity);
    }

    @WebMethod(operationName = "find")
    public Users find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Users> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Users> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "id") String id, @WebParam(name = "pass") String pass) {
        boolean ok = false;
        Users e = ejbRef.find(id);
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

    @WebMethod(operationName = "search")
    public List<Users> search(@WebParam(name = "id") String id) {
        List<Users> list = new ArrayList<>();
        for (Users u : ejbRef.findAll()) {
            if (u.getUsername().contains(id)) {
                list.add(u);
            }
        }
        return list;
    }

}
