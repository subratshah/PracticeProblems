package sample.com.testprogram;

public class Thermometer {

    public double toCelsius(double temp) {
        return (temp - 32) * 5 / 9;
    }

    public double toFahrenheit(double temp) {
        return temp * 9 / 5 + 32;
    }
}
