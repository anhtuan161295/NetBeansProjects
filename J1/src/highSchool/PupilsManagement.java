/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package highSchool;
import server.Pupils;
/**
 *
 * @author QQ
 */
public class PupilsManagement {
    int nextPupil = 0;
    Pupils[] pupil = new Pupils[10];
    
    public void addPupils(){
        if(nextPupil < pupil.length){
            pupil[nextPupil] = new Pupils();
            nextPupil++;
        }
        
    }
    public void showPupils(){
        if(nextPupil == 0){
            System.out.println("No pupils in list");
        }else{
            for (int i = 0; i < nextPupil; i++) {
                System.out.println("");
                System.out.println("Pupil " + (i+1));
                System.out.println("Name: " + pupil[i].name);
                System.out.println("Age: " + pupil[i].age);
                System.out.println("Nationality: " + pupil[i].nationality);
                
            }
        }
        
        
    }
}
