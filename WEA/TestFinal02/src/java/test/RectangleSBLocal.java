/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Local;

/**
 *
 * @author QQ
 */
@Local
public interface RectangleSBLocal {

    Double area(Double length, Double width);

    Double perimeter(Double length, Double width);
    
}
