
package Scanoio;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RunallTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(30));

        driver.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {

        driver.findElement(By.id("user-name")).sendKeys(username);

        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();
    }

    @Test(priority = 1)
    public void validLoginTest() {

        login("standard_user", "secret_sauce");

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
    }

    @Test(priority = 2)
    public void invalidLoginTest() {

        login("invalid_user", "wrong_password");

        String errorMessage =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(errorMessage.contains("Username and password do not match"));
    }

    @Test(priority = 3)
    public void emptyUsernamePasswordTest() {

        driver.findElement(By.id("login-button")).click();

        String errorMessage =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(errorMessage.contains("Username is required"));
    }

    @Test(priority = 4)
    public void lockedUserValidationTest() {

        login("locked_out_user", "secret_sauce");

        String errorMessage =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(errorMessage.contains("locked out"));
    }

    @Test(priority = 5)
    public void addRemoveProductTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Assert.assertEquals(
                driver.findElement(By.className("shopping_cart_badge")).getText(),
                "1"
        );

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        Assert.assertTrue(
                driver.findElements(By.className("shopping_cart_badge")).isEmpty()
        );
    }

    @Test(priority = 6)
    public void multipleProductsInCartTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        Assert.assertEquals(
                driver.findElement(By.className("shopping_cart_badge")).getText(),
                "2"
        );
    }

    @Test(priority = 7)
    public void cartPersistenceTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.navigate().refresh();

        Assert.assertEquals(
                driver.findElement(By.className("shopping_cart_badge")).getText(),
                "1"
        );
    }

    @Test(priority = 8)
    public void successfulCheckoutTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys("Sudarshan");

        driver.findElement(By.id("last-name")).sendKeys("Aglave");

        driver.findElement(By.id("postal-code")).sendKeys("411001");

        driver.findElement(By.id("continue")).click();

        driver.findElement(By.id("finish")).click();

        String successMessage =
                driver.findElement(By.className("complete-header")).getText();

        Assert.assertEquals(successMessage, "Thank you for your order!");
    }

    @Test(priority = 9)
    public void mandatoryFieldValidationTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("continue")).click();

        String errorMessage =
                driver.findElement(By.cssSelector("[data-test='error']")).getText();

        Assert.assertTrue(errorMessage.contains("First Name is required"));
    }

    @Test(priority = 10)
    public void checkoutCancellationTest() {

        login("standard_user", "secret_sauce");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        driver.findElement(By.className("shopping_cart_link")).click();

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("cancel")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}