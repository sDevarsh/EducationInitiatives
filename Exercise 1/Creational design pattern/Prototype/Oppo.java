package Prototype;

class Oppo extends Mobile {
    public Oppo(){
        processor= "snapdragon 650";
    }
    @Override
    public void call() {
        System.out.println("Inside Prototype.Oppo::call() method.");
    }
}
