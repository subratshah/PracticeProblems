package sample.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PurchaseTest {

    Purchase purchase;
    Customer customer;
    Discount discount;

    @Before
    public void setup() {
        customer = new Customer("CUST1", "diamond");
        discount = new Discount();
    }

    @Test
    public void getName_nameCUST1_returnsCUST1() {
        assertEquals("CUST1", customer.getName());
    }

    @Test
    public void getMemberType_membeerTypeDiamond_returnsDiamond() {
        assertEquals("diamond", customer.getMemberType());
    }

    @Test
    public void getServiceDiscount_memberTypeDiamond_returns017() {
        assertEquals(0.17, discount.getServiceDiscount(customer.getMemberType()), 0);
    }

    @Test
    public void getProductDiscount_memberTypeDiamond_returns015() {
        assertEquals(0.15, discount.getProductDiscount(customer.getMemberType()), 0);
    }

    @Test
    public void getBill_ifCustomerIsPlatinumMemberAndServiceCostIs1000AndProductCostIs500_totalAmountIs1295() {
        customer = new Customer("CUST2", "platinum");
        purchase = new Purchase(customer, discount, 1000, 500);
        assertEquals(1295, purchase.getBill(), 0);
    }

    @Test
    public void getBill_ifCustomerIsDiamondMemberAndServiceCostIs700AndHasNoProductCosts_totalAmountIs() {
        customer = new Customer("CUST3", "diamond");
        purchase = new Purchase(customer, discount, 700, 0);
        assertEquals(581, purchase.getBill(), 0);
    }
}