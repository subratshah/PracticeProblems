package sample.com.testprogram;

import java.util.ArrayList;
import java.util.List;

public class Echo {
    public String ping(String... messages) {
        String echosSentence = "";
        String warningSentence = "";

        if (messages[0].isEmpty()) {
            return "There is nothing to echo";
        } else {
            List<String> echoList = new ArrayList<>();
            List<String> warningList = new ArrayList<>();

            for (String message : messages) {
                if (message.equals(message.toUpperCase()) && message.length() != 0) {
                    warningList.add(message);
                } else if (!message.isEmpty()) {
                    echoList.add(message);
                }
            }

            while (!echoList.isEmpty()) {
                if (echosSentence.isEmpty()) {
                    echosSentence = "Echo: " + echoList.get(0);
                } else if (echoList.size() == 1) {
                    echosSentence = echosSentence + " and " + echoList.get(0);
                } else echosSentence += ", " + echoList.get(0);
                echoList.remove(0);
            }

            while (!warningList.isEmpty()) {
                if (warningSentence.isEmpty()) {
                    warningSentence = " WARNING: " + warningList.get(0);
                } else if (warningList.size() == 1) {
                    warningSentence = warningSentence + " AND " + warningList.get(0);
                } else warningSentence += ", " + warningList.get(0);
                warningList.remove(0);
            }
        }
        return (echosSentence + warningSentence).trim();
    }
}
