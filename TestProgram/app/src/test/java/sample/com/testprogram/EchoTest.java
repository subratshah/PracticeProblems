package sample.com.testprogram;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EchoTest {

    private Echo subject;

    @Before
    public void setup() {
        subject = new Echo();
    }

    @Test
    public void messageStarfish_ping_returnsEchoStarfish() {
        assertEquals("Echo: Starfish", subject.ping("Starfish"));
    }

    @Test
    public void messageNull_ping_returnsReplacementMessage() {
        assertEquals("There is nothing to echo", subject.ping(""));
    }

    @Test
    public void messageUppercase_ping_returnsWarning() {
        assertEquals("WARNING: SHARK", subject.ping("SHARK"));
    }

    @Test
    public void messageTwoStrings_ping_returnsEchoString1String2() {
        assertEquals("Echo: Beluga and Whale", subject.ping("Beluga", "Whale"));
    }

    @Test
    public void messageManyStrings_ping_returnsEcho() {
        assertEquals("Echo: Walrus, Whale and Seal", subject.ping("Walrus", "Whale", "", "Seal"));
    }

    @Test
    public void messageManyStrings_ping_returnsWarning() {
        assertEquals("Echo: Walrus, Whale and Seal WARNING: SHARK, SEASNAKE AND SHARK",
                subject.ping("Walrus", "SHARK", "Whale", "Seal", "SEASNAKE", "SHARK"));
    }
}