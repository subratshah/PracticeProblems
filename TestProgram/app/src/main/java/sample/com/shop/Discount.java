package sample.com.shop;

import java.util.Arrays;
import java.util.List;

public class Discount {
    private static final double DIAMOND_SERVICE_DISCOUNT = 0.17;
    private static final double PLATINUM_SERVICE_DISCOUNT = 0.13;
    private static final double GOLD_SERVICE_DISCOUNT = 0.09;
    private static final double PRODUCT_DISCOUNT = 0.15;

    public double getServiceDiscount(String membershipType) {
        switch (membershipType.toLowerCase()) {
            case "diamond":
                return DIAMOND_SERVICE_DISCOUNT;
            case "platinum":
                return PLATINUM_SERVICE_DISCOUNT;
            case "gold":
                return GOLD_SERVICE_DISCOUNT;
            default:
                return 0;
        }
    }

    public double getProductDiscount(String membershipType) {
        List<String> membership = Arrays.asList("Diamond", "Platinum", "Gold");
        if (membership.contains(membershipType))
            return PRODUCT_DISCOUNT;
        return 0;
    }
}
