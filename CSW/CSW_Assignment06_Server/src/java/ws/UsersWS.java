/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entities.Users;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import sessionbeans.UsersSB;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "UsersWS")
@Stateless()
public class UsersWS {

    @EJB
    private UsersSB ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "all")
    public List<Users> all() {
        return ejbRef.all();
    }

    @WebMethod(operationName = "searchById")
    public Users searchById(@WebParam(name = "username") String username) {
        return ejbRef.searchById(username);
    }

    @WebMethod(operationName = "insert")
    public boolean insert(@WebParam(name = "user") Users user) {
        return ejbRef.insert(user);
    }

    @WebMethod(operationName = "edit")
    public boolean edit(@WebParam(name = "user") Users user) {
        return ejbRef.edit(user);
    }

    @WebMethod(operationName = "delete")
    public boolean delete(@WebParam(name = "username") String username) {
        return ejbRef.delete(username);
    }

    @WebMethod(operationName = "checkLogin")
    public boolean checkLogin(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        return ejbRef.checkLogin(username, password);
    }

}
