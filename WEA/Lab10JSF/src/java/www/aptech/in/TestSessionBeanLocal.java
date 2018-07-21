/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.aptech.in;

import javax.ejb.Local;

/**
 *
 * @author QQ
 */
@Local
public interface TestSessionBeanLocal {

    float add(float a, float b);

    float sub(float a, float b);
    
}
