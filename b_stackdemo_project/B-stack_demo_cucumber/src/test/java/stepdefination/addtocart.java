package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class addtocart {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for add to cart")
    public void user_is_logged_in_for_add_to_cart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user adds products to the cart")
    public void user_adds_products_to_the_cart() {
        stack.addtocart();
    }

    @Then("the products should appear in the cart")
    public void the_products_should_appear_in_the_cart() {
        System.out.println("Products added to cart successfully");
        driver.quit();
    }
}
