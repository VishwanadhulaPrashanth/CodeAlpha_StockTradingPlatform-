package com.stock;

import java.util.HashMap;

class User {
    private String name;
    private double balance;
    private HashMap<String, Integer> portfolio = new HashMap<>();

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public HashMap<String, Integer> getPortfolio() {
        return portfolio;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }

    public void addBalance(double amount) {
        balance += amount;
    }
}

