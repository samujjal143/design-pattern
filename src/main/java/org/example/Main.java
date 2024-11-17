package org.example;

import org.example.singleton.SimpleSingleton;
import org.example.singleton.ThreadSafeSingleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Select a design pattern
                1. Singleton
                """);
        int num = sc.nextInt();
        switch (num) {
            case 1:
                SimpleSingleton.getInstance("simple singleton");
                ThreadSafeSingleton.getInstance("thread safe singleton");
                break;
        }
    }
}
