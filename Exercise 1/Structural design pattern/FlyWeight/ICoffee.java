package FlyWeight;

class ICoffee implements Coffee{
    private String flavour;
    private int table;
    private int waiter;
    public ICoffee(String flavour){
        this.flavour = flavour;
    }
    public void setTable(int table) {
        this.table = table;
    }
    public void setWaiter(int waiter) {
        this.waiter = waiter;
    }
    public void make() {
        System.out.println("FlyWeight.Coffee: Draw() [Flavour : " + flavour + ", Table : " +
                table + ", Waiter :" + waiter );
    }
}
