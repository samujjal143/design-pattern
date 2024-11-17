package org.example.singleton;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance; // private static instance
    private String data;

    private ThreadSafeSingleton(String data) { // private constructor
        this.data = data;
    }

    public static ThreadSafeSingleton getInstance(String data) {
        if (instance == null) { // Double-checked locking idiom
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton(data);
                }
            }
        }
        return instance;
    }
}
