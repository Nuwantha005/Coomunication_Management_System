/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test4;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Nuwantha
 */
public class NewClass {
    public static void main(String[] args) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        System.out.println(f.format(d));
        if (f.format(d).equals("2019-01-13")) {
            System.out.println("nuwbneufefv");
        }
    }
    
}
