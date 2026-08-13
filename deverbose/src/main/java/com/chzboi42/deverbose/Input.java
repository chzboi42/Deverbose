package com.chzboi42.deverbose;
import java.util.Scanner;


public class Input {
    private Input() {}
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextLine();
    }

    public static byte inputByte(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextByte();
    }

    public static int inputInt(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextInt();
    }

    public static long inputLong(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextLong();
    }

    public static double inputDouble(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextDouble();
    }

    public static float inputFloat(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.nextFloat();
    }

    public static Object input(Object input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        return scanner.next();
    }



}
