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
public class OtherGeneric<T> {
    T type;
    
    public void add(T typeOfdata){
        this.type = typeOfdata;
    }
    public T get(){
        return type;
    }
    
    public void showType(){
        System.out.println("The datatype is: " + type.getClass().getName());
    }
}
