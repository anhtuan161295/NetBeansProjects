/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test11111;

/**
 *
 * @author QQ
 */
public class TestSuper extends TestSupper{
    public TestSuper(){
        //super();
        name = "abc";
        System.out.println(name);
    }
    public static void main(String[] args) {
        new TestSuper();
    }
}
