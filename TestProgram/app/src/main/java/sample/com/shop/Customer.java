package sample.com.shop;

public class Customer {
    private String name;
    private String memberType;

    public Customer(String name, String memberType) {
        this.name = name;
        this.memberType = memberType;
    }

    public String getName() {
        return name;
    }

    public String getMemberType() {
        return memberType;
    }
}
