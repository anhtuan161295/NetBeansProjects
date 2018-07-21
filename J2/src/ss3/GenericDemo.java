/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss3;

/**
 *
 * @author QQ
 */
public class GenericDemo {
    public static void main(String[] args) {
         OtherGeneric<Integer> testInteger = new OtherGeneric<>();
         
         testInteger.add(10);
         System.out.println(testInteger.get());
         testInteger.showType();
         System.out.println("\nAnother test: ");
         System.out.println("\n------------------------");
        
         OtherGeneric<Double> testDouble = new OtherGeneric<>();
         testDouble.add(1.0);
         System.out.println(testDouble.get());
         testDouble.showType();
         System.out.println("\nAnother test: ");
         System.out.println("\n------------------------");
    }
}
