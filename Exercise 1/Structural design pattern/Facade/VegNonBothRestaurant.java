package Facade;

class VegNonBothRestaurant implements Hotel {
    public Menus getMenus() {
        Both b = new Both();
        return b;
    }
}
