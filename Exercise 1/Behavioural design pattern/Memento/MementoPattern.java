package Memento;

import java.util.Scanner;

public class MementoPattern {
    public static void main(String args[]) {
        Originator originator = new Originator();
        CareTaker careTaker = new CareTaker();
        Scanner scanner = new Scanner(System.in);

        // Taking user input for initial state
        System.out.println("Enter the initial state values for Temperature , Pressure , Volume :");
        double x = scanner.nextDouble();
        double y = scanner.nextDouble();
        double z = scanner.nextDouble();
        originator.setState(x, y, z);
        careTaker.addState(originator.saveToMemento());

        // Taking user input for another state
        System.out.println("Enter the next state values for  Temperature , Pressure , Volume :");
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        z = scanner.nextDouble();
        originator.setState(x, y, z);

        // Another state change
        System.out.println("Enter another state values for  Temperature , Pressure , Volume :");
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        z = scanner.nextDouble();
        originator.setState(x, y, z);
        careTaker.addState(originator.saveToMemento());

        // Another state change before restoring
        System.out.println("Enter the final state values for  Temperature , Pressure , Volume :");
        x = scanner.nextDouble();
        y = scanner.nextDouble();
        z = scanner.nextDouble();
        originator.setState(x, y, z);

        careTaker.printAllSavedState();
        System.out.println("------ Current State ------");
        originator.printState();

        // Restoring the second state (index 1)
        originator.restoreStateFromMemento(careTaker.getState(1));
        System.out.println("------ State after Restoration ------");
        originator.printState();

        scanner.close();
    }
}
