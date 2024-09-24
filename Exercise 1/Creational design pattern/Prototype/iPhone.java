package Prototype;

class iPhone extends Mobile {
    public iPhone() {
        processor = "helio g80";
    }

    @Override
    public void call() {
        System.out.println("Inside iphone::call() method.");
    }
}
