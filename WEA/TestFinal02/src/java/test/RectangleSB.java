/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import javax.ejb.Stateless;

/**
 *
 * @author QQ
 */
@Stateless
public class RectangleSB implements RectangleSBLocal {

    @Override
    public Double area(Double length, Double width) {
        return length * width;
    }

    @Override
    public Double perimeter(Double length, Double width) {
        return (length + width) * 2;
    }

}
