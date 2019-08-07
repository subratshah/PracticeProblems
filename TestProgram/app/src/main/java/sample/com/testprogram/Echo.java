package sample.com.testprogram;

public class Echo {
    public String ping(String... messages) {
        String echo = "";
        String warning = "";

        for (String message : messages) {
            if (message == null || message.isEmpty()) {
                return "There is nothing to echo";
            } else if (message.equals(message.toUpperCase())) {
                warning += " " + message;
            } else {
                echo += " " + message;
            }
        }
        if (!echo.isEmpty()) echo = "Echo:" + echo;
        if (!warning.isEmpty()) warning = "WARNING:" + warning;
        return echo + warning;
    }
}
