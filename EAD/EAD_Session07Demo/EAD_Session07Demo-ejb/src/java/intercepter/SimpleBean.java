/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercepter;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.interceptor.Interceptors;

/**
 *
 * @author QQ
 */
@Stateless
@LocalBean
@Interceptors(SimpleInterceptor.class)
public class SimpleBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public String printMessage(String message) {
        System.out.println(" Executing method : printMessage - " + message);
        return "Message is " + message;
    }
}
