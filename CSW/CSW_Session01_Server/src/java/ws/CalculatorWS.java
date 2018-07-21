/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author QQ
 */
@WebService(serviceName = "CalculatorWS")
public class CalculatorWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public Double add(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a + b;
    }

    @WebMethod(operationName = "sub")
    public Double sub(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a - b;
    }

    @WebMethod(operationName = "mul")
    public Double mul(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a * b;
    }

    @WebMethod(operationName = "div")
    public Double div(@WebParam(name = "a") double a, @WebParam(name = "b") double b) {
        return a / b;
    }
}
