package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class removefromcart {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for remove from cart")
    public void user_is_logged_in_for_remove_from_cart() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }
    
    @Given("the user adds a product to the cart")
    public void user_adds_a_product_to_the_cart() {
        stack.addtocart();   // add ()
    }

    
    @When("the user removes products from the cart")
    public void user_removes_products_from_the_cart() {
        stack.deleteitemfromcart();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        System.out.println("Cart is empty now");
        driver.quit();
    }
}
