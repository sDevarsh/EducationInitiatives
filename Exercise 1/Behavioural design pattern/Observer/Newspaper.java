package Observer;

class Newspaper implements ObserverInterface {
    @Override
    public void update(float interest) {
        System.out.println("Newspaper: Interest rate updated to: " + interest);
    }
}
