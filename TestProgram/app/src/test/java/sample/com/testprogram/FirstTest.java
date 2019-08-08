package sample.com.testprogram;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FirstTest {

    @Test
    public void test() {
        First first = new First();
        assertEquals("Hello World", first.printMe());
    }
}