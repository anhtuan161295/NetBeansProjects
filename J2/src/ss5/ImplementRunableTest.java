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
public class ImplementRunableTest {
    public static void main(String[] args) {
        ImplementRunable test = new ImplementRunable();
        Thread th = new Thread(test);
        th.start();
    }
}
