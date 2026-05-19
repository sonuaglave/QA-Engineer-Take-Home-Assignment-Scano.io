package Scanoio;

import org.testng.annotations.Test;

public class RunTestScano extends CheckoutDetail {

    @Test
    public void completeFlowTest() {

        loginFlow();

        cartFlow();

        checkoutFlow();

        System.out.println("Complete Flow Executed Successfully");
    }
}