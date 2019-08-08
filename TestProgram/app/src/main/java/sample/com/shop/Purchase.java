package sample.com.shop;

public class Purchase {
    private Customer customer;
    private Discount discount;
    private double serviceCost;
    private double productCost;

    public Purchase(Customer customer, Discount discount, double serviceCost, double productCost) {
        this.customer = customer;
        this.discount = discount;
        this.serviceCost = serviceCost;
        this.productCost = productCost;
    }

    public double getBill(double serviceCost, double productCost) {
        return 0;
    }
}
