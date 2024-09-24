package Facade;

class NonVegRestaurant implements Hotel {
    public Menus getMenus() {
        NonVegMenu nv = new NonVegMenu();
        return nv;
    }
}
