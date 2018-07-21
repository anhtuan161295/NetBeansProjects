/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.aptech.in;

/**
 *
 * @author QQ
 */
public class StudentBean {

    private String rollnumber;
    private String name;
    private int year;

    public StudentBean() {
    }

    public StudentBean(String rollnumber, String name, int year) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.year = year;
    }

    public String getRollnumber() {
        return rollnumber;
    }

    public void setRollnumber(String rollnumber) {
        this.rollnumber = rollnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
