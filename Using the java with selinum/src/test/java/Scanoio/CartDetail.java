package Scanoio;

import org.openqa.selenium.By;

public class CartDetail extends LoginDetail {

    public void cartFlow() {

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack"))
                .click();

        driver.findElement(By.className("shopping_cart_link"))
                .click();

        System.out.println("Cart Completed");
    }
}