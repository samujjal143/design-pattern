package org.example.observer;

public interface StockObserver {
    void update(String stockSymbol, double stockPrice);
}
