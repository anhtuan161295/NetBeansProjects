/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package www.aptech.in;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author QQ
 */
@ManagedBean
@SessionScoped
public class CalculatorMB implements Serializable {

    @EJB
    private TestSessionBeanLocal testSessionBean;

    private float result;
    private float numA;
    private float numB;

    public CalculatorMB() {
    }

    public float getNumA() {
        return numA;
    }

    public void setNumA(float numA) {
        this.numA = numA;
    }

    public float getNumB() {
        return numB;
    }

    public void setNumB(float numB) {
        this.numB = numB;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public void add() {
        result = testSessionBean.add(numA, numB);

    }

    public void sub() {
        result = testSessionBean.sub(numA, numB);

    }

}
