package Observer;

class Internet implements ObserverInterface {
    @Override
    public void update(float interest) {
        System.out.println("Internet: Interest rate updated to: " + interest);
    }
}