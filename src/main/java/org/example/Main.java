package org.example;

import org.example.builder.Computer;
import org.example.builder.ComputerBuilder;
import org.example.builder.ComputerDirector;
import org.example.builder.DesktopComputerBuilder;
import org.example.singleton.SimpleSingleton;
import org.example.singleton.ThreadSafeSingleton;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                Select a design pattern
                1. Singleton
                2. Builder
                """);
        int num = sc.nextInt();
        switch (num) {
            case 1 -> {
                SimpleSingleton.getInstance("simple singleton");
                ThreadSafeSingleton.getInstance("thread safe singleton");
            }
            case 2 -> {
                ComputerBuilder desktopBuilder = new DesktopComputerBuilder();
                ComputerDirector director = new ComputerDirector(desktopBuilder);
                Computer desktop = director.constructComputer();
                System.out.println(desktop);
            }
        }
    }
}
