/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Remote;

/**
 *
 * @author QQ
 */
@Remote
public interface BankRemote {
    boolean withdraw(int amount);
    void deposit(int amount);
    int getBalance();
    
}
