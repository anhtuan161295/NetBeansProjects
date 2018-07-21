/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.aptech.in;

import javax.ejb.Stateless;

/**
 *
 * @author QQ
 */
@Stateless
public class TestSessionBean implements TestSessionBeanLocal {

    @Override
    public float add(float a, float b) {
        return (a+b);
    }

    @Override
    public float sub(float a, float b) {
        return (a-b);
    }
}
