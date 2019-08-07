package sample.com.testprogram;

public class Echo {
    public String ping(String message) {
        if (message == null || message.isEmpty()) {
            return "There is nothing to echo";
        } else if (message.equals(message.toUpperCase())) {
            return "WARNING:" + message;
        } else {
            return "Echo:" + message;
        }
    }
}
