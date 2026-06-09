/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Arrays;

import com.chzboi42.deverbose.Console;
import com.chzboi42.deverbose.Interpolator;
import com.chzboi42.deverbose.Loops;
import com.chzboi42.deverbose.Maths;
import com.chzboi42.deverbose.Sorter;

public class App {
    static Interpolator hood = new Interpolator();
    static Interpolator flywheel = new Interpolator();

    public static void main(String[] args) throws Error {
        int result = new App().main();
        if (result != 0) throw new Error("Bad");
    }

    int main() {

        int[] e = new int[10000];
        for (int i = 0; i < e.length; i++) {
            e[i] = (int) (Math.random()*100000)+1;
        }
        Sorter.mergeSort(e);
        Console.write(Arrays.toString(e));
        Loops.loop(5, -2, () -> Console.println(Maths.wrap(Loops.i(),0,4, true)));

        System.out.println(Arrays.toString(interpolate(7)));
        return 0;
    }

    static void addData(double hoodAngle, double flywheelSpeed, double distance) {
        hood.put(distance, hoodAngle);
        flywheel.put(distance, flywheelSpeed);
    }

    static double[] interpolate(double distance) {
        return new double[] {hood.get(distance), flywheel.get(distance)};
    }

    static {
        addData(45, 40, 1.83);
        addData(50, 42, 2.310);
        addData(65, 43.5, 2.802);
        addData(70, 45.5, 3.16);
        addData(75, 54, 4.730);
        addData(75, 57, 5.006);
    }
}