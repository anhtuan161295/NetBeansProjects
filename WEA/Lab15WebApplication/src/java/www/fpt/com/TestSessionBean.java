/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.fpt.com;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;

/**
 *
 * @author QQ
 */
@Stateless
@DeclareRoles({"Admin", "Customer"})
public class TestSessionBean implements TestSessionBeanLocal {

    @Override
    public String add() {
        return "Hello, insert data";
    }

    @Override
    public String update() {
        return "Hello, update data";
    }

    @Override
    public String select() {
        return "Hello, select data";
    }

}
