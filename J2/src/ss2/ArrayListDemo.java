/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


/**
 *
 * @author QQ
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList ary = new ArrayList();
    
//    for(int i = 0; i<4 ; i++){
//        ary.add("Add person " + (i+1));
//    }
    ary.add("Add person 1");
    ary.add("Add person 2");
    ary.add("Add person 3");
    ary.add("Add person 4");
    ary.add("Add person 5");
    ary.add("Add person 6");
    ary.add(2,"--More person");
//    1. Use Iterator
//    Iterator it = ary.iterator();
//    while(it.hasNext()){
//        System.out.println(" " + it.next());
//    }
//        System.out.println("Display using Iterator");

//    2. Use array GET
//        for (int i = 0; i < ary.size(); i++) {
//            System.out.println(ary.get(i));
//        }
//        System.out.println("Display using array GET");
        
//    3.Use for each
//        for (Object object : ary) {
//            System.out.println(object);
//        }
//        4. Modify list element
        ListIterator lit = ary.listIterator();
        while(lit.hasNext()){
            lit.set(lit.next() + "++");
        }
//           for (Object object : ary) {
//            System.out.println(object);
//        }     
//        5. Modify element backward
            //ListIterator lit = ary.listIterator();
//            ListIterator phải set next trước mới dùng previous được,
//          vì lúc này con trỏ chạy từ cuối > đầu mảng.
            while(lit.hasPrevious()){
                System.out.print("\n" + lit.previous());
            }
//            for (Object object : ary) {
//            System.out.println(object);
//        }   
}
}
