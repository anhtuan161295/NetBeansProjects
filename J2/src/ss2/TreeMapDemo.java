/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss2;

import java.util.TreeMap;

/**
 *
 * @author QQ
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap map = new TreeMap();
        map.put(17, "Saturday");
        map.put(16, "Friday");
        map.put(15, "Thursday");
        map.put(14, "Wednesday");
        map.put(13, "Tuesday");
        map.put(12, "Monday");
        map.put(11, "Sunday");
        
        System.out.println("Keys in Tree Map: " + map.keySet());
        System.out.println("Values in Tree Map: "+ map.values());
        System.out.println("The first key is: "
                + map.firstKey() + " has value: "
                + map.get(map.firstKey()) + "\n");
        System.out.println("The last key is: "
                + map.lastKey()+ " has value: "
                + map.get(map.lastKey()) + "\n");
        System.out.println("Remove first data");
        map.remove(map.firstKey());
        System.out.println("Keys in Tree Map: " + map.keySet());
        System.out.println("Values in Tree Map: "+ map.values());
        System.out.println("Remove last data");
        map.remove(map.lastKey());
        System.out.println("Keys in Tree Map: " + map.keySet());
        System.out.println("Values in Tree Map: "+ map.values());
    }
    
}
