package com.stock;

class TradingPlatform {

    public void buyStock(User user, Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;

        if (user.getBalance() >= cost) {
            user.deductBalance(cost);
            user.getPortfolio().put(
                stock.getSymbol(),
                user.getPortfolio().getOrDefault(stock.getSymbol(), 0) + quantity
            );
            System.out.println("Stock Purchased Successfully!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void sellStock(User user, Stock stock, int quantity) {
        int ownedQty = user.getPortfolio().getOrDefault(stock.getSymbol(), 0);

        if (ownedQty >= quantity) {
            user.getPortfolio().put(stock.getSymbol(), ownedQty - quantity);
            user.addBalance(stock.getPrice() * quantity);
            System.out.println("Stock Sold Successfully!");
        } else {
            System.out.println("Not enough stocks to sell!");
        }
    }

    public void showPortfolio(User user, Market market) {
        double totalValue = 0;

        System.out.println("\nYour Portfolio:");
        for (String symbol : user.getPortfolio().keySet()) {
            int qty = user.getPortfolio().get(symbol);
            Stock stock = market.getStock(symbol);
            double value = qty * stock.getPrice();
            totalValue += value;

            System.out.println(symbol + " - Quantity: " + qty + " | Value: Rs." + value);
        }
        System.out.println("Total Portfolio Value: Rs." + totalValue);
        System.out.println("Remaining Balance: Rs." + user.getBalance());
    }
}

