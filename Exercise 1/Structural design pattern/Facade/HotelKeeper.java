package Facade;

class HotelKeeper {
    public Menus getMenu(RestaurantType select) {
        switch (select) {
            case VEG:
                VegRestaurant v = new VegRestaurant();
                VegMenu vegMenu = (VegMenu) v.getMenus();
                return vegMenu;
            case NONVEG:
                NonVegRestaurant nv = new NonVegRestaurant();
                NonVegMenu NonvegMenu = (NonVegMenu) nv.getMenus();
                return NonvegMenu;
            case BOTH:
                VegNonBothRestaurant b = new VegNonBothRestaurant();
                Both bothMenu = (Both) b.getMenus();
                return bothMenu;
        }
        return null;
    }
}
