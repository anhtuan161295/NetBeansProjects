/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.fpt.com;

import javax.ejb.Local;

/**
 *
 * @author QQ
 */
@Local
public interface TestSessionBeanLocal {

    String add();

    String update();

    String select();
    
}
