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
public class AccountSB implements AccountSBLocal {

    @Override
    public Double interest(double amount, int duration) {
        return amount * duration * 10 / 100;
    }

}
