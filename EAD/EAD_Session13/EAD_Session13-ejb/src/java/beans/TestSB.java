/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author QQ
 */
@Stateless
@LocalBean
@DeclareRoles({"admin", "customer"})
public class TestSB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @RolesAllowed({"admin", "customer"})
    public String select() {
        return "Select method";
    }

    @RolesAllowed({"admin"})
    public String insert() {
        return "Insert method";
    }
}
