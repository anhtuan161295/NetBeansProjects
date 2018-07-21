/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Stateful;

/**
 *
 * @author QQ
 */
@Stateful(mappedName = "myBank")
public class Bank implements BankRemote {

    private int amount = 0;

    @Override
    public boolean withdraw(int amount) {
        if (amount <= this.amount) {
            this.amount -= amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deposit(int amount) {
        this.amount += amount;
    }

    @Override
    public int getBalance() {
        return amount;
    }

}
