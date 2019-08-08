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
}