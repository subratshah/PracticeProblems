package sample.com.testprogram;

public class Echo {
    public String ping(String message) {
        if (message != null) {
            return "Echo:" + message;
        } else {
            return "There is nothing to echo";
        }
    }
}
