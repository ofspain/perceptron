/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perceptron;

/**
 *
 * @author femi
 */
public class Utilities {
    
    public static  String prettyPrintArray(double[] array) {
        String d = "[";
        for (double t : array) {
            d += (t + ", ");
        }
        if (d.endsWith(", ")) {
            d = d.substring(0, d.lastIndexOf(", "));
        }
        d += "]";
        return d;
    }
    
}
