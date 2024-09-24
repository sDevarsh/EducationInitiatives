package Memento;

class Originator {
    private double temperature;
    private double pressure;
    private double volume;

    public void setState(double temp, double pressure, double volume) {
        this.temperature = temp;
        this.pressure = pressure;
        this.volume = volume;
    }

    public void printState() {
        System.out.println("State : [ Temperature = " + temperature
                + ", Pressure = " + pressure + ", Volume = " + volume + "]");
    }

    public Memento saveToMemento() {
        return new Memento(temperature, pressure, volume);
    }

    public void restoreStateFromMemento(Memento m) {
        this.temperature = m.getTemperature();
        this.pressure = m.getPressure();
        this.volume = m.getVolume();
    }
}
