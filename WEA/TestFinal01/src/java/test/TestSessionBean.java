/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Stateless;

/**
 *
 * @author QQ
 */
@Stateless
public class TestSessionBean implements TestSessionBeanLocal {

    @Override
    public Double changeDegree(double f) {
        double c = (f - 32) * 5 / 9;
        return c;
    }

}
