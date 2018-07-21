/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apptech;

/**
 *
 * @author khang
 */
public class Student {
    private String rollnumber;
    private String fullname;
    private int yob;

    public Student()
    {
        
    }
    
    public Student(String rollnumber, String fullname, int yob) {
        this.rollnumber = rollnumber;
        this.fullname = fullname;
        this.yob = yob;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public String getFullname() {
        return fullname;
    }

    public int getYob() {
        return yob;
    }

    
}
