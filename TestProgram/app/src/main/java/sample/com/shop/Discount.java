package sample.com.shop;

public class Discount {
    private static final double DIAMOND_SERVICE_DISCOUNT = 0.17;
    private static final double PLATINUM_SERVICE_DISCOUNT = 0.13;
    private static final double GOLD_SERVICE_DISCOUNT = 0.09;
    private static final double PRODUCT_DISCOUNT = 0.15;

    public double getServiceDiscount(String membershipType) {
        return 0;
    }

    public double getProductDiscount(String membershipType) {
        return PRODUCT_DISCOUNT;
    }
}
