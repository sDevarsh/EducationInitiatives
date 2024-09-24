package Observer;

import java.util.Scanner;

public class ObserverPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Loan Type:");
        String loanType = scanner.nextLine();

        System.out.println("Enter Initial Interest Rate:");
        float interestRate = scanner.nextFloat();

        System.out.println("Enter Bank Name:");
        scanner.nextLine();
        String bankName = scanner.nextLine();

        Newspaper printMedia = new Newspaper();
        Internet onlineMedia = new Internet();

        Loan personalLoan = new Loan(loanType, interestRate, bankName);

        personalLoan.registerObserver(printMedia);
        personalLoan.registerObserver(onlineMedia);

        System.out.println("Loan created: " + personalLoan.getType() + " with initial interest rate " +
                personalLoan.getInterest() + " from " + personalLoan.getBank());
        System.out.println("Enter the new interest rate:");
        float newInterestRate = scanner.nextFloat();
        personalLoan.setInterest(newInterestRate);

        scanner.close();
    }
}