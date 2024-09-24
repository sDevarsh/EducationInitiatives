package Facade;

import java.util.ArrayList;

class VegMenu implements Menus {
    public ArrayList<String> menu = new ArrayList<>();

    public VegMenu() {
        menu.add("Paratha");
        menu.add("Chole Kulcha");
        menu.add("Veg.Pizza");
    }

    public void getItems() {
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }
}
