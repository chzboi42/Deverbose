package com.chzboi42.deverbose;
import java.util.Scanner;


public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean newLine = false;
    private static final Input INSTANCE = new Input();

    public static String inputString(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextLine();
    }

    public static byte inputByte(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextByte();
    }

    public static int inputInt(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextInt();
    }

    public static long inputLong(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextLong();
    }

    public static double inputDouble(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextDouble();
    }

    public static float inputFloat(String input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.nextFloat();
    }

    public static Object input(Object input) {
        Console.print(input);
        if (newLine) {
            Console.write("");
            newLine = false;
        }
        return scanner.next();
    }

    public static Input withNewLine() {
        newLine = true;
        return INSTANCE;
    }



}
