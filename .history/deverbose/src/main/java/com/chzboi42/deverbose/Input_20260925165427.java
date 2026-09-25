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
        byte toReturn = scanner.nextByte();
        scanner.nextLine();
        return toReturn;
    }

    public static int inputInt(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        int toReturn =  scanner.nextInt();
        scanner.nextLine();
        return toReturn;
    }

    public static long inputLong(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        long toReturn = scanner.nextLong();
        scanner.nextLine();
        return toReturn;
    }

    public static double inputDouble(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        double toReturn = scanner.nextDouble();
        scanner.nextLine();
        return toReturn;
    }

    public static float inputFloat(String input, boolean newLine) {
        Console.print(input);
        if (newLine) {
            Console.write("");
        }
        float toReturn = scanner.nextFloat();
        scanner.nextLine();
        return toReturn;
    }

    public static Object input(Object input, boolean newLine) {
        print(input);
        if (newLine) {
            write("");
        }
        String toReturn = scanner.next();
        scanner.nextLine();
        return toReturn;
    }


}
