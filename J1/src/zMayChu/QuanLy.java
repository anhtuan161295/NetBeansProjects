/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zMayChu;

/**
 *
 * @author QQ
 */
public class QuanLy {
    //DoiTuong test = new DoiTuong();
    DoiTuong[] doituong = new DoiTuong[2];
    int next = 0;
    public void add(){
        
            if(next < doituong.length){
           
           doituong[next] = new DoiTuong();
           doituong[next].input();
           next++;
            }
            else{
                System.out.println("Data full !");  
            }
        
            
        
        
        
        
    }
    
    public void display(){
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
