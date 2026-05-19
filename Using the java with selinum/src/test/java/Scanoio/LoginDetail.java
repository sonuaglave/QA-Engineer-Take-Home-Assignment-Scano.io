package Scanoio;

import org.openqa.selenium.By;

public class LoginDetail extends BaseClass {

    public void loginFlow() {

        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login Completed");
    }
}