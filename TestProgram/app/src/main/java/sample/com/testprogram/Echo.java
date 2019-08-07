package sample.com.testprogram;

public class Echo {
    public String ping(String... messages) {
        String echo = "";
        String warning = "";
        String separator = " ";
        if (messages.length > 2) separator = ", ";

        for (int i = 0; i < messages.length; i++) {

            if (messages[i] == null || messages[i].isEmpty()) {
                return "There is nothing to echo";
            } else if (messages[i].equals(messages[i].toUpperCase())) {
                if (messages.length > 2 && (i == messages.length - 1)) {
                    warning = warning.substring(0, warning.length() - 2) + " AND " + messages[i];
                } else warning += messages[i] + separator;
            } else {
                if (messages.length > 2 && (i == messages.length - 1)) {
                    echo = echo.substring(0, echo.length() - 2) + " and " + messages[i];
                } else echo += messages[i] + separator;
            }
        }
        if (!echo.isEmpty())
            echo = "Echo: " + echo.trim();
        if (!warning.isEmpty())
            warning = "WARNING: " + warning.trim();

        return echo + warning;
    }
}
