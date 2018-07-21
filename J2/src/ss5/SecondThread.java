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
public class SecondThread extends Thread{
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread #1: " + i);
        }
    }
        
    public static void main(String[] args) {
        new FirstThread().start();
        new SecondThread().start();
    }
}
