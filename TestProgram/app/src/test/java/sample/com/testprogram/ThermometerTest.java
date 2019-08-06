package sample.com.testprogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ThermometerTest {

    Thermometer subject;

    @Before
    public void setup() {
        subject = new Thermometer();
    }

    @Test
    public void convertToFahrenheit() {
        assertEquals(10, subject.toCelsius(50),0);
    }

    @Test
    public void convertToCelsius() {
        assertEquals(50, subject.toFahrenheit(10),0);
    }
}