package Prototype;
import java.util.Scanner;
import java.util.Hashtable;

public class Prototype {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MobileCache.loadCache();


        System.out.println("Enter mobile ID (1 for Samsung, 2 for Apple, 3 for OnePlus):");
        String mobileId1 = scanner.nextLine();
        Mobile clonedMobile = MobileCache.getMobile(mobileId1);
        System.out.println("Prototype.Mobile : " + clonedMobile.getProcessor());

        System.out.println("Enter mobile ID (1 for Samsung, 2 for Apple, 3 for OnePlus):");
        String mobileId2 = scanner.nextLine();
        Mobile clonedMobile2 = MobileCache.getMobile(mobileId2);
        System.out.println("Prototype.Mobile : " + clonedMobile2.getProcessor());

        System.out.println("Enter mobile ID (1 for Samsung, 2 for Apple, 3 for OnePlus):");
        String mobileId3 = scanner.nextLine();
        Mobile clonedMobile3 = MobileCache.getMobile(mobileId3);
        System.out.println("Prototype.Mobile : " + clonedMobile3.getProcessor());

        scanner.close();
    }
}