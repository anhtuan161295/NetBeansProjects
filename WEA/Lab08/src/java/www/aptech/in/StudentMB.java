/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.aptech.in;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@SessionScoped
public class StudentMB implements Serializable {

    private StudentBean student;
    private List<StudentBean> list;

    public StudentMB() {
        student = new StudentBean();
        list = new ArrayList<>();
    }

    public StudentBean getStudent() {
        return student;
    }

    public void setStudent(StudentBean student) {
        this.student = student;
    }

    public List<StudentBean> getList() {
        return list;
    }

    public void setList(List<StudentBean> list) {
        this.list = list;
    }

    public String addStudent() {
        list.add(student);
        student = new StudentBean();
        return "success";
    }

}
