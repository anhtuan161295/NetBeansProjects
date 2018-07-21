
package ss2;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;


public class HashtableDemo {
    public static void main(String[] args) {
    Hashtable table = new Hashtable();
    
    table.put("1","Pham Chi Nghi");
    table.put("2","Pham Chi Nghi2");
    table.put("3","Pham Chi Nghi3");
    
    Collection collection = table.values(); //get collection of value
        System.out.println("SIMPLE GET VALUES");
        System.out.println(collection);
//        System.out.println(table.values());
        System.out.println("--------------");
        System.out.println("Get Element by Iterator");
        Iterator it = collection.iterator();
        //Iterator it = table.values().iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("--------------");
        System.out.println("Get element by Enumration");
        Enumeration e = table.elements();
        while(e.hasMoreElements()){
            System.out.println(e.nextElement());
        }
    }
}
