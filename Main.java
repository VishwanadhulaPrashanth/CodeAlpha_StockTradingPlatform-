package com.stock;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Market market = new Market();
        TradingPlatform platform = new TradingPlatform();

        User user = new User("Prashanth", 100000);

        while (true) {
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    market.showMarket();
                    break;

                case 2:
                    System.out.print("Enter Stock Symbol: ");
                    String buySymbol = sc.next();
                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();
                    Stock buyStock = market.getStock(buySymbol);
                    if (buyStock != null)
                        platform.buyStock(user, buyStock, buyQty);
                    else
                        System.out.println("Stock not found!");
                    break;

                case 3:
                    System.out.print("Enter Stock Symbol: ");
                    String sellSymbol = sc.next();
                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();
                    Stock sellStock = market.getStock(sellSymbol);
                    if (sellStock != null)
                        platform.sellStock(user, sellStock, sellQty);
                    else
                        System.out.println("Stock not found!");
                    break;

                case 4:
                    platform.showPortfolio(user, market);
                    break;

                case 5:
                    System.out.println("Thank You!");
                    System.exit(0);
            }
        }
    }
}
