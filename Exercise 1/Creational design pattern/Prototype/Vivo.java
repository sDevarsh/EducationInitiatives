package Prototype;

class Vivo extends Mobile {
    public Vivo() {
        processor = "meidatech super";
    }

    @Override
    public void call() {
        System.out.println("Inside Prototype.Vivo::call() method.");
    }
}
