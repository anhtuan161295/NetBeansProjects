/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Local;

/**
 *
 * @author QQ
 */
@Local
public interface AccountSBLocal {

    Double interest(double amount, int duration);
    
}
