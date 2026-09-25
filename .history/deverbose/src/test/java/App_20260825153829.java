/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */




import com.chzboi42.deverbose.Console;
import com.chzboi42.deverbose.units2.Distance;
import com.chzboi42.deverbose.units2.LinearVelocity;
import com.chzboi42.deverbose.units2.Time;
import static com.chzboi42.deverbose.units2.Units.Mach;
import static com.chzboi42.deverbose.units2.Units.Metres;
import static com.chzboi42.deverbose.units2.Units.Seconds;

public class App {

    public static void main(String[] args) throws Error {
        int result = new App().main();
        if (result != 0) throw new Error("Bad");
    }

    int main() {
        Time timeForThunderToHit = Seconds.of(3.5);
        LinearVelocity speedOfSound = Mach.of(1);
        Distance lightningDistance = speedOfSound.getNumeratorFor(timeForThunderToHit);
        Console.println(lightningDistance.in(Metres));


        return 0;
    }
}