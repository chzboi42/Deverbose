package com.chzboi42.deverbose.encryptor;

import com.chzboi42.deverbose.ArrayUtil;
import com.chzboi42.deverbose.Maths;

public class InternalEncryptor {
    private final char[] charKey;
    private int[] key;

    protected InternalEncryptor(String key) {
        this.charKey = key.toCharArray();
        this.key = new int[charKey.length];
        for (int i = 0; i < this.key.length; i++) {
            this.key[i] = (int) charKey[i];
        }
    }

    protected String encrypt(String message) {
        ArrayUtil.rotate(key, key.length-4);
        char[] messageCharArray = message.toCharArray();
        int[] messageArray = new int[messageCharArray.length];
        while (key.length < messageArray.length) {
            key = ArrayUtil.repeat(key, 2);
        }

        //converts each character in the message to an int
        for (int i = 0; i < messageArray.length; i++) {
            messageArray[i] = (int) messageCharArray[i];
        }

        // Encrypts each digit
        for (int i = 0; i < messageArray.length; i++) {
            messageArray[i] = Maths.wrap(messageArray[i] + key[i], 32, 127, false);
        }

        //Converts each ASCII digit in the message back to a char
        for (int i = 0; i < messageArray.length; i++) {
            messageCharArray[i] = (char) messageArray[i];
            switch (messageCharArray[i]) {
                case '\"' -> messageCharArray[i] = 'È'; //200
                case '\\' -> messageCharArray[i] = 'É'; //201
                case ' ' -> messageCharArray[i] = 'Ê'; //202
                default -> {}
            }
        }

        return new String(messageCharArray);
    }

    protected String decrypt(String message) {
        ArrayUtil.rotate(key, key.length-4);
        char[] messageCharArray = message.toCharArray();
        int[] messageArray = new int[messageCharArray.length];
        while (key.length < messageArray.length) {
            key = ArrayUtil.repeat(key, 2);
        }

        // Converts each char to an ASCII digit
        for (int i = 0; i < messageArray.length; i++) {
            switch (messageCharArray[i]) {
                case 'È' -> messageCharArray[i] = '\"'; //200
                case 'É' -> messageCharArray[i] = '\\'; //201
                case 'Ê' -> messageCharArray[i] = ' '; //202
                default -> {}
            }
            messageArray[i] = (int) messageCharArray[i];
        }

        //Decrypts each digit
        for (int i = 0; i < messageArray.length; i++) {
            messageArray[i] = Maths.wrap(messageArray[i] - key[i], 32, 127, false);
        }

        //Converts each ASCII digit back into a char
        for (int i = 0; i < messageArray.length; i++) {
            messageCharArray[i] = (char) messageArray[i];
        }
        return new String(messageCharArray);
    }
}
