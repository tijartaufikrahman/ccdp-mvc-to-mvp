package ac.id.unikom.challenge;

public class Meter {

    private double meter;

    public void setMeter(double meter) {
        this.meter = meter;
    }

    public double toKilometer() {
        return meter / 1000;
    }

    public double toCentimeter() {
        return meter * 100;
    }
}
