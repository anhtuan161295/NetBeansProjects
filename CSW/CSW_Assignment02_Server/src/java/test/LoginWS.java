/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.UsersSB;
import entities.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "LoginWS")
public class LoginWS {

    @EJB
    private UsersSB usersSB;

    @WebMethod(operationName = "login")
    public boolean login(@WebParam(name = "id") String id, @WebParam(name = "pass") String pass) {
        boolean ok = false;
        if (usersSB.login(id, pass)) {
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    @WebMethod(operationName = "getAll")
    public List<Users> getAll() {
        return usersSB.getAll();
    }

    @WebMethod(operationName = "getUser")
    public Users getUser(@WebParam(name = "username") String username) {
        return usersSB.getUser(username);
    }

    @WebMethod(operationName = "add")
    public boolean add(@WebParam(name = "user") Users user) {
        boolean ok = false;
        if (usersSB.add(user)) {
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "user") Users user) {
        boolean ok = false;
        if (usersSB.edit(user)) {
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "username") String username) {
        boolean ok = false;
        if (usersSB.delete(username)) {
            ok = true;
        } else {
            ok = false;
        }
        return ok;
    }

}
