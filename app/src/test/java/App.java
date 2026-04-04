/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.chzboi42.deverbose.Console;
import com.chzboi42.deverbose.Interpolator;
import com.chzboi42.deverbose.Loops;
import com.chzboi42.deverbose.units.Time;

public class App {
    static int i = 0;
    static boolean reached5 = false;

    public static void main(String[] args) {

        Interpolator data = new Interpolator();

        data.put(1,19);
        data.put(2,23);
        data.put(3,43);
        data.put(4,59);
        data.put(6,95);

//        data.put(1,10);
//        data.put(3,30);

        System.out.println(data.get(69));

    }
}