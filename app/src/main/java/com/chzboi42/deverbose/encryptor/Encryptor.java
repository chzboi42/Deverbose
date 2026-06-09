package com.chzboi42.deverbose.encryptor;

public class Encryptor {
    private final String key;

    public Encryptor(String key) {
        this.key = key;
    }

    public String encrypt(String message) {
        return new InternalEncryptor(key).encrypt(message);
    }

    public String decrypt(String message) {
        return new InternalEncryptor(key).decrypt(message);
    }
}
