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

    public double getBill() {
        double service = serviceCost * (1 - discount.getServiceDiscount(customer.getMemberType()));
        double product = productCost * (1 - discount.getProductDiscount(customer.getMemberType()));

        return service + product;
    }
}
