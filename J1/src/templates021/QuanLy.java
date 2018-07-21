/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates021;

/**
 *
 * @author QQ
 */
public class QuanLy {
    DoiTuong[] doituong = new DoiTuong[2];
    int next = 0;
    void add(){
        
            if(next < doituong.length){
           doituong[next++] = new DoiTuong(); 
            }
            else{
                System.out.println("Data full !");  
            }
        
            
        
        
        
        
    }
    
    void display(){
        if(next == 0){
            System.out.println("No data here!");
        }
        else{
            for (int i = 0; i < next; i++) {
               doituong[i].output();
            } 
        }

    }
    
}
