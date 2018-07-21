/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss5;

/**
 *
 * @author QQ
 */
public class ImplementRunable implements Runnable{
    public int val = 10;
    @Override
    public void run() {
        System.out.println("The " + val);
    }
    
}
