/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author QQ
 */
public class Employee {

    private String name, role, gender;
    private int age, id;

    //<editor-fold defaultstate="collapsed" desc="comment">
    public Employee() {
    }
    
    public Employee(String name, String role, String gender, int age, int id) {
        this.name = name;
        this.role = role;
        this.gender = gender;
        this.age = age;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
//</editor-fold>
    
//    @Override
//    public String toString() {
//        return "Employee{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", role=" + role + '}';
//    }

}
