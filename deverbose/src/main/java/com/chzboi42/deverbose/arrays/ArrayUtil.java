package com.chzboi42.deverbose.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayUtil {

    public static <E, T> Object[][] fromMapObject(Map<E, T> map) {
        Object[][] array = new Object[map.size()][2];
        int i = 0;
        for (Map.Entry<E, T> entry : map.entrySet()) {
            array[i][0] = entry.getKey();
            array[i][1] = entry.getValue();
            i++;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[][] fromMapT(Map<T, T> map) {
        Object[][] array = new Object[map.size()][2];
        int i = 0;
        for (Map.Entry<T, T> entry : map.entrySet()) {
            array[i][0] = entry.getKey();
            array[i][1] = entry.getValue();
            i++;
        }
        return (T[][]) array;
    }

    public static <T> Map<T, T> toHashMap(T[][] arr) {
        Map<T, T> map = new HashMap<>();
        for (T[] row : arr) {
            map.put(row[0], row[1]);
        }
        return map;
    }

    public static void swap(double[] arr, int index1, int index2) {
        double temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
  
    public static void rotate(int[] arr, int places) {
        places %= arr.length;
        if (places < 0) places += arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, places - 1);
        reverse(arr, places, arr.length - 1);
    }

    private static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static int[] repeat(int[] original, int times) {
        int[] repeated = new int[original.length * times];

        for (int i = 0; i < times; i++) {
            // Copy the original array into the new one at the correct offset
            System.arraycopy(original, 0, repeated, i * original.length, original.length);
        }
        return repeated;
    }

    public static <T> T[] asSet(T[] arr) {
        ArrayList<T> list = new ArrayList<>();
        for (T t : arr) {
            if(!list.contains(t)) list.add(t);
        }
        return list.toArray(Arrays.copyOf(arr, list.size()));
    }


}
