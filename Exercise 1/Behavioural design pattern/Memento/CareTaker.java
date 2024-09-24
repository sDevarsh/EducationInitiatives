package Memento;

import java.util.HashMap;
import java.util.Map;

class CareTaker {
    private int counter;
    private Map<Integer, Memento> mementoMap = new HashMap<Integer,
            Memento>();

    public CareTaker() {
        counter = 1;
    }

    public void addState(Memento m) {
        mementoMap.put(counter, m);
        counter++;
    }

    public void removeState(int i) {
        mementoMap.remove(i);
    }

    public void printAllSavedState() {
        System.out.println("------ Saved States------");
        for (Map.Entry<Integer, Memento> entry : mementoMap.entrySet()) {
            System.out.println("State " + entry.getKey());
            entry.getValue().printMemento();
        }
        System.out.println("-------------------------");
    }

    public Memento getState(int i) {
        return mementoMap.get(i);
    }
}
