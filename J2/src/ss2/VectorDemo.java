/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author QQ
 */
public class VectorDemo {
    public static void main(String[] args) {
        Vector vt = new Vector();
        for (int i = 0; i < 6; i++) {
            vt.add("Vector Element " + (i+1));
        }
        vt.add(4,"--Vector Element-----");
        Iterator it = vt.iterator();
        while(it.hasNext()){
            System.out.println("" + it.next());
        }
        for (Object object : vt) {
            System.out.println(object);
        }
    }
}
