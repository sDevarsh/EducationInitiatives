package Singleton;

import java.util.Scanner;

public class SingletonPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MobileClass mobile = MobileClass.getInstance();

        System.out.println("Current Mobile State: " + mobile.getProcess());

        while (true) {
            System.out.println("Enter an action to perform (1 = Play Audio, 2 = Play Game, 3 = Play Video, 4 = Get Current Process 0 = Exit):");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mobile.playAudio();
                    break;
                case 2:
                    mobile.playGame();
                    break;
                case 3:
                    mobile.playVideo();
                    break;
                case 4:
                    mobile.getProcess();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println("Current Mobile State: " + mobile.getProcess());
        }
    }
}