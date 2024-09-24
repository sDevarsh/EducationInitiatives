package FlyWeight;

import java.util.HashMap;
import java.util.Scanner;

public class FlyWeightPattern {
    private static final String[] flavours = { "Americano", "Mocha", "Cappuccino", "Latte" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many orders do you want to process?");
        int orderCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < orderCount; ++i) {
            System.out.println("Enter flavour (Americano, Mocha, Cappuccino, Latte):");
            String flavour = scanner.nextLine();

            System.out.println("Enter table number:");
            int table = scanner.nextInt();

            System.out.println("Enter waiter number:");
            int waiter = scanner.nextInt();
            scanner.nextLine();

            ICoffee coffee = (ICoffee) CoffeeFactory.getCoffee(flavour);
            coffee.setTable(table);
            coffee.setWaiter(waiter);
            coffee.make();
        }

        scanner.close();
    }
}