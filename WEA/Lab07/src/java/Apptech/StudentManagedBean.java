/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apptech;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author khang
 */
@ManagedBean
@SessionScoped
public class StudentManagedBean implements Serializable {

    private Student s;
    private List<Student> list;

    /**
     * Creates a new instance of StudentManagedBean
     */
    public StudentManagedBean() {
        s = new Student();
        list = new ArrayList<>();
        //list.add(new Student("1", "haha", 1920));
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public List<Student> getList() {
        return list;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public Student getS() {
        return s;
    }

    //Nhập lần 1, vì student chưa có giá trị nên input trống
    // Lần 2, student đã có giá trị nên sẽ ko sửa
    public String addStudent() {

        list.add(s);
        s = new Student();
        return "Success";
    }

}
