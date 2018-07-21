/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class Event {
    String time;
    String place;
    String content;
    Scanner s = new Scanner(System.in);
    String filename;
    
    public Event(){
       System.out.print("Enter time: ");
        time = s.nextLine();
        System.out.print("Enter place: ");
        place = s.nextLine();
        System.out.print("Enter content: ");
        content = s.nextLine();
    }
    
    public Event(String time, String place, String content){
        this.time = time;
        this.place = place;
        this.content = content;
    }
    
  
    
    
    
    public void output(){
        ManageEvents me = new ManageEvents();
        
        for (Event event : me.al) {
        System.out.println("Time: " + event.time);
        System.out.println("Place: " + event.place);
        System.out.println("Content: " + event.content);
    }
    }

}


