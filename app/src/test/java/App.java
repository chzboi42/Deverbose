/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import com.chzboi42.deverbose.Console;
import com.chzboi42.deverbose.Loops;
import com.chzboi42.deverbose.units.Time;

public class App {
    static int i = 0;
    static boolean reached5 = false;
    
    public static void main(String[] args) {

        Console.parallel(
            () -> Loops.loop(10, () -> {
                Console.println(Loops.i());
                if (reached5) {Console.wait(Time.Milliseconds.of(10)); reached5 = false;}
            }),
            () -> Console.sequence(
                () -> Console.waitUntil(() -> Loops.i() >= 5),
                () -> {reached5 = true;},
                () -> Console.write("Finished 5")
            )
        );

    }
}