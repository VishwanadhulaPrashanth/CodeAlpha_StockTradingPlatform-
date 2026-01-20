package com.stock;

import java.util.ArrayList;

class Market {
    ArrayList<Stock> stocks = new ArrayList<>();

    public Market() {
        stocks.add(new Stock("TCS", 3500));
        stocks.add(new Stock("INFY", 1500));
        stocks.add(new Stock("WIPRO", 450));
    }

    public void showMarket() {
        System.out.println("\nAvailable Stocks:");
        for (Stock s : stocks) {
            System.out.println(s.getSymbol() + " - Rs." + s.getPrice());
        }
    }

    public Stock getStock(String symbol) {
        for (Stock s : stocks) {
            if (s.getSymbol().equalsIgnoreCase(symbol)) {
                return s;
            }
        }
        return null;
    }
}

