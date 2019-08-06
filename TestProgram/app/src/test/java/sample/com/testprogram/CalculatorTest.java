package sample.com.testprogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    Calculator subject;

    @Before
    public void setup() {
        subject = new Calculator(7, 4);
    }

    @Test
    public void addition_returnsSum() {
        assertEquals(11, subject.addition());
    }

    @Test
    public void subtract_returnsDifference() {
        assertEquals(3, subject.subtract());
    }

    @Test
    public void divide_returnsQuotient() {
        assertEquals(1, subject.divide(),1);
    }

    @Test
    public void multiply_returnsProduct() {
        assertEquals(28, subject.multiply());
    }
}