package Facade;

import java.util.ArrayList;

class NonVegMenu implements Menus {
    public ArrayList<String> menu = new ArrayList<>();

    public NonVegMenu() {
        menu.add("Mutton Korma");
        menu.add("Nihari Gosht");
    }

    public void getItems() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }
}
