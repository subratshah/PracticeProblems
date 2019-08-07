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
    public void ping_messageSingleWord_returnsEchoWord() {
        assertEquals("Echo: Starfish", subject.ping("Starfish"));
    }

    @Test
    public void ping_messageNull_reutrnsNothingToEcho() {
        assertEquals("There is nothing to echo", subject.ping(""));
    }

    @Test
    public void ping_messageSingleCaps_returnsWarningCaps() {
        assertEquals("WARNING: SHARK", subject.ping("SHARK"));
    }

    @Test
    public void ping_messageTwoWords_returnsEchoAndBetweenWords() {
        assertEquals("Echo: Beluga and Whale", subject.ping("Beluga", "Whale"));
    }

    @Test
    public void ping_messageMultipleWordsIncludingNull_returnsEchoCommasWordsAndLastWordRemoveNull() {
        assertEquals("Echo: Walrus, Whale and Seal", subject.ping("Walrus", "Whale", "", "Seal"));
    }

    @Test
    public void ping_messageMultipleWordsAndCaps_returnsEchoCommaAndWordsWithWarningCommaAndCaps() {
        assertEquals("Echo: Walrus, Whale and Seal WARNING: SHARK, SEASNAKE AND SHARK",
                subject.ping("Walrus", "SHARK", "Whale", "Seal", "SEASNAKE", "SHARK"));
    }
}