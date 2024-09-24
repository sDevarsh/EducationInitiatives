package Observer;

import java.util.ArrayList;
import java.util.List;

class Loan {
    private String type;
    private float interest;
    private String bank;
    private List<ObserverInterface> observers = new ArrayList<>();

    public Loan(String type, float interest, String bank) {
        this.type = type;
        this.interest = interest;
        this.bank = bank;
    }

    public void registerObserver(ObserverInterface observer) {
        observers.add(observer);
    }

    public void unregisterObserver(ObserverInterface observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (ObserverInterface observer : observers) {
            observer.update(this.interest);
        }
    }

    public void setInterest(float interest) {
        System.out.println("Interest rate updated.");
        this.interest = interest;
        notifyObservers();
    }

    public float getInterest() {
        return interest;
    }

    public String getBank() {
        return bank;
    }

    public String getType() {
        return type;
    }
}