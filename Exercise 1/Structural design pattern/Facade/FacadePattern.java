package Facade;

import java.util.ArrayList;

public class FacadePattern {
    public static void main(String[] args) {
        HotelKeeper keeper = new HotelKeeper();
        VegMenu v = (VegMenu) keeper.getMenu(RestaurantType.VEG);
        NonVegMenu nv = (NonVegMenu) keeper.getMenu(RestaurantType.NONVEG);
        Both B = (Both) keeper.getMenu(RestaurantType.BOTH);
        v.getItems();
        nv.getItems();
        B.getItems();
    }
}
