package org.example;

import org.example.adapter.*;
import org.example.builder.Computer;
import org.example.builder.ComputerBuilder;
import org.example.builder.ComputerDirector;
import org.example.builder.DesktopComputerBuilder;
import org.example.observer.Investor;
import org.example.observer.StockMarketImpl;
import org.example.observer.StockObserver;
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
                3. Adapter
                4. Observer
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
            case 3 -> {
                PaymentGateway paypalGateway = new PayPalAdapter(new PayPal());
                PaymentGateway stripeGateway = new StripeAdapter(new Stripe());

                double amount = 100.0;

                paypalGateway.processPayment(amount);
                stripeGateway.processPayment(amount);
            }
            case 4 -> {
                StockMarketImpl stockMarket = new StockMarketImpl();

                StockObserver investor1 = new Investor("Alice");
                StockObserver investor2 = new Investor("Bob");

                stockMarket.registerObserver(investor1);
                stockMarket.registerObserver(investor2);

                stockMarket.setStockPrice("INFY", 1250.0); // Both investors receive updates
                stockMarket.setStockPrice("TCS", 2500.0); // Both investors receive updates

                stockMarket.removeObserver(investor1);

                stockMarket.setStockPrice("WIPRO", 700.0); // Only investor2 receives the update
            }
        }
    }
}
