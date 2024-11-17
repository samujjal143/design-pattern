package org.example.singleton;

public class SimpleSingleton {
    private static SimpleSingleton instance; // private static instance
    private String data;

    private SimpleSingleton(String data) { // private constructor
        this.data = data;
    }

    public static SimpleSingleton getInstance(String data) {
        if (instance == null) {
            instance = new SimpleSingleton(data);
        }
        return instance;
    }

    /*
    If we're dealing with multithreaded environments, nothing in this code prevents 2 threads from accessing this
    piece of code at the same time
     */
}
