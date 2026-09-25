import java.util.ArrayList;
import java.util.Scanner;

public class TradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Store available stocks
        ArrayList<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("AAPL", "Apple Inc.", 150.00));
        stocks.add(new Stock("GOOGL", "Alphabet Inc.", 2800.00));
        stocks.add(new Stock("AMZN", "Amazon.com Inc.", 3400.00));

        // Create user with virtual money
        User user = new User("Muskan", 10000);

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("       STOCK TRADING PLATFORM");
            System.out.println("=================================");

            System.out.println("Welcome, " + user.name);
            System.out.println("Virtual Balance: $" + user.balance);

            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Sell Stock");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n--------- MARKET ---------");

                    for (Stock stock : stocks) {
                        System.out.println(
                            "Symbol: " + stock.symbol +
                            " | Company: " + stock.companyName +
                            " | Price: $" + stock.price
                        );
                    }
                    break;

                case 2:
                    System.out.print("\nEnter stock symbol: ");
                    String symbol = sc.next().toUpperCase();

                    Stock selectedStock = null;

                    for (Stock stock : stocks) {
                        if (stock.symbol.equals(symbol)) {
                            selectedStock = stock;
                            break;
                        }
                    }

                    if (selectedStock == null) {
                        System.out.println("Stock not found!");
                        break;
                    }

                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();
                    if (quantity <= 0) {
    System.out.println("Quantity must be greater than 0.");
    break;
}

                    double totalCost = selectedStock.price * quantity;

                    if (totalCost > user.balance) {
                        System.out.println("Insufficient balance!");
                    } else {
                        user.balance -= totalCost;
                       Holding holding=new Holding(selectedStock,quantity,selectedStock.price);

                       user.portfolio.add(holding);

                       Transaction transaction = new Transaction(
                    "BUY",
                    selectedStock.symbol,
                    quantity,
                    selectedStock.price
                 );

                    user.transactions.add(transaction);

                        System.out.println("\nPurchase successful!");
                        System.out.println("Stock: " + selectedStock.symbol);
                        System.out.println("Quantity: " + quantity);
                        System.out.println("Total Cost: $" + totalCost);
                        System.out.println("Remaining Balance: $" + user.balance);
                    }
                    break;

                case 3:
    System.out.println("\n--------- PORTFOLIO ---------");

    if (user.portfolio.isEmpty()) {

        System.out.println("Your portfolio is empty.");

    } else {

        for (Holding holding : user.portfolio) {

            System.out.println(
                "Symbol: " + holding.stock.symbol +
                " | Company: " + holding.stock.companyName +
                " | Quantity: " + holding.quantity +
                " | Purchase Price: $" + holding.purchasePrice +
                " | Current Price: $" + holding.stock.price
            );
        }
    }

    break;
                case 4:

    System.out.print("\nEnter stock symbol to sell: ");
    String sellSymbol = sc.next().toUpperCase();

    System.out.print("Enter quantity to sell: ");
    int sellQuantity = sc.nextInt();
    if (sellQuantity <= 0) {
    System.out.println("Quantity must be greater than 0.");
    break;
}

    boolean found = false;

    for (Holding holding : user.portfolio) {

        if (holding.stock.symbol.equals(sellSymbol)) {

            found = true;

            if (sellQuantity > holding.quantity) {
                System.out.println("You don't have enough shares!");
            } else {

                double saleAmount =
                        holding.stock.price * sellQuantity;

                user.balance += saleAmount;
                holding.quantity -= sellQuantity;

                Transaction transaction = new Transaction(
                "SELL",
                holding.stock.symbol,
                sellQuantity,
                holding.stock.price
            );

            user.transactions.add(transaction);

                System.out.println("\nStock sold successfully!");
                System.out.println("Stock: " + sellSymbol);
                System.out.println("Quantity Sold: " + sellQuantity);
                System.out.println("Amount Received: $" + saleAmount);
                System.out.println("Updated Balance: $" + user.balance);

                if (holding.quantity == 0) {
                    System.out.println("Holding Completely sold.");
                }
            }

            break;
                }
            }

                if (!found) {
                System.out.println("You don't own this stock!");
                 }

                break;


                case 5:

    System.out.println("\n--------- TRANSACTION HISTORY ---------");

    if (user.transactions.isEmpty()) {

        System.out.println("No transactions yet.");

    } else {

        for (Transaction transaction : user.transactions) {

            System.out.println(
                "Type: " + transaction.type +
                " | Stock: " + transaction.symbol +
                " | Quantity: " + transaction.quantity +
                " | Price: $" + transaction.price +
                " | Total: $" + transaction.totalAmount
            );
        }
    }

    break;

                case 6:
                    System.out.println("\nThank you for using the Stock Trading Platform!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}