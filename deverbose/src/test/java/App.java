
import com.chzboi42.deverbose.Loops;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class App {

    public static void main(String[] args) throws Error {
        int result = new App().main();
        if (result != 0) throw new Error("Bad");
    }

    int main() {try {
        int[] e = new int[] {1, 2, 3, 4, 5, 6, 7};
        Loops.foreach(e, run -> run.setIterator(run.iterator() * 2));
        System.out.println(java.util.Arrays.toString(e));
        return 0;
    }catch(Exception e){return 1;}}
}