package FlyWeight;

import java.util.HashMap;

class CoffeeFactory {
    private static HashMap iCoffeeMap = new HashMap();
    public static Coffee getCoffee(String flavour){
        ICoffee iCoffee = (ICoffee)iCoffeeMap.get(flavour);
        if(iCoffee == null) {
            iCoffee = new ICoffee(flavour);
            iCoffeeMap.put(flavour, iCoffee);
            System.out.println("Creating iCoffee of flavour : " + flavour);
        }
        return iCoffee;
    }
}
