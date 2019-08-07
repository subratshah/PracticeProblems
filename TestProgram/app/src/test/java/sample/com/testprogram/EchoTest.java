package sample.com.testprogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    private Echo subject;
    private String message = "Starfish";

    @Before
    public void setup() {
        subject = new Echo();

    }

    @Test
    public void messageStarfish_ping_returnsEchoStarfish() {
        assertEquals("Echo:" + message, subject.ping(message));
    }

    @Test
    public void messageNull_ping_returnsReplacementMessage() {
        assertEquals("There is nothing to echo", subject.ping(null));
    }
}