package Scanoio;

import org.openqa.selenium.By;

public class CheckoutDetail extends CartDetail {

    public void checkoutFlow() {

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name"))
                .sendKeys("Sudarshan");

        driver.findElement(By.id("last-name"))
                .sendKeys("Aglave");

        driver.findElement(By.id("postal-code"))
                .sendKeys("411001");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        System.out.println("Checkout Completed");
    }
}