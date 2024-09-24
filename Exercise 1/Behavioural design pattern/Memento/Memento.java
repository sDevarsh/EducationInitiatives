package Memento;

class Memento {
    private double temperature;
    private double pressure;
    private double volume;

    public Memento(double temp, double pressure, double volume) {
        this.temperature = temp;
        this.pressure = pressure;
        this.volume = volume;
    }

    public double getTemperature() {
        return temperature;
    }

    public void printMemento() {
        System.out.println("State : [ Temperature = " + temperature
                + ", Pressure = " + pressure + ", Volume = " + volume + "]");
    }

    public double getPressure() {
        return pressure;
    }

    public double getVolume() {
        return volume;
    }
}
