package sample.com.shop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PurchaseTest {

    private Purchase purchase;
    private Customer customer;
    private Discount discount = mock(Discount.class);

    @Before
    public void setup() {
        customer = new Customer("CUST1", "diamond");
    }

    @Test
    public void getName_nameCUST1_returnsCUST1() {
        assertEquals("CUST1", customer.getName());
    }

    @Test
    public void getMemberType_memberTypeDiamond_returnsDiamond() {
        assertEquals("diamond", customer.getMemberType());
    }

    @Test
    public void getServiceDiscount_memberTypeDiamond_returns017() {
        discount = new Discount();

        assertEquals(0.17, discount.getServiceDiscount(customer.getMemberType()), 0);
    }

    @Test
    public void getProductDiscount_memberTypeDiamond_returns015() {
        discount = new Discount();

        assertEquals(0.15, discount.getProductDiscount(customer.getMemberType()), 0);
    }

    @Test
    public void getBill_ifCustomerIsPlatinumMemberAndServiceCostIs1000AndProductCostIs500_totalAmountIs1295() {
        customer = new Customer("CUST2", "platinum");
        purchase = new Purchase(customer, discount, 1000, 500);
        when(discount.getServiceDiscount("platinum")).thenReturn(.13);
        when(discount.getProductDiscount("platinum")).thenReturn(.15);

        assertEquals(1295, purchase.getBill(), 0);

        verify(discount).getServiceDiscount("platinum");
    }

    @Test
    public void getBill_ifCustomerIsDiamondMemberAndServiceCostIs700AndHasNoProductCosts_totalAmountIs() {
        customer = new Customer("CUST3", "diamond");
        purchase = new Purchase(customer, discount, 700, 0);
        when(discount.getServiceDiscount("diamond")).thenReturn(.17);

        assertEquals(581, purchase.getBill(), 0);

        verify(discount).getServiceDiscount("diamond");
    }

    @Test
    public void getBill_ifCustomerIsNotAMemberAndServiceCostIs500_totalAmountIs500() {
        customer = new Customer("CUST4", "");
        purchase = new Purchase(customer, discount, 500, 0);

        when(discount.getServiceDiscount("")).thenReturn(.0);
//        verify(discount).getServiceDiscount("");

        assertEquals(500, purchase.getBill(), 0);
    }

    @Test
    public void getBill_ifCustomerIsMemberAndServiceCostIs0AndProductCostIs700_totalAmountIs595() {
        customer = new Customer("CUST5", "gold");
        purchase = new Purchase(customer, discount, 0, 700);
        when(discount.getProductDiscount("gold")).thenReturn(.15);

        assertEquals(595, purchase.getBill(), 0);

        verify(discount).getProductDiscount("gold");
    }

    @Test
    public void getBill_ifCustomerIsDifferentMemberAndServiceCostIs500AndProductCostIs500_totalAmountIs1000() {
        customer = new Customer("CUST6", "nonmember");
        purchase = new Purchase(customer, discount, 500, 500);
        when(discount.getServiceDiscount("nonmember")).thenReturn(.0);
        when(discount.getProductDiscount("nonmember")).thenReturn(.0);

        assertEquals(1000, purchase.getBill(), 0);

        verify(discount).getServiceDiscount("nonmember");
        verify(discount).getProductDiscount("nonmember");
    }
}