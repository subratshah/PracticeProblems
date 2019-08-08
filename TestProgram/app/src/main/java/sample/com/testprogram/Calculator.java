package sample.com.testprogram;

public class Calculator {
    public int a, b;

    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int addition() {
        return a + b;
    }

    public int subtract() {
        return a - b;
    }

    public float divide() {
        return a / b;
    }

    public int multiply() {
        return a * b;
    }
}
