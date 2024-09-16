package electricity;

public class Customer {
    String name;
    String address;
    int meterReading;

    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
        this.meterReading = 0;
    }

    public void setMeterReading(int reading) {
        this.meterReading = reading;
    }

    public int getMeterReading() {
        return this.meterReading;
    }
}
