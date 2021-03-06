/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intercepter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author QQ
 */
public class SimpleInterceptor {

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        System.out.println("SimpleInterceptor - Logging BEFORE calling method :" + context.getMethod().getName());

        Object result = context.proceed();
        System.out.println("SimpleInterceptor - Logging AFTER calling method :" + context.getMethod().getName());

        return result;
    }
}
