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
public class FirstThread extends Thread{
    public FirstThread(){
        System.out.println("First thread is created !");
    }
//    @Override
//    public void run(){
//        for (int i = 0; i < 10; i++) {
//            System.out.println("Thread #1: " + i);
//        }
//    }
    
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread #2: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
    
//    public static void main(String[] args) {
//        FirstThread test = new FirstThread();
//        test.run();
//    }
}
