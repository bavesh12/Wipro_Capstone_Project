package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class checkout {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for checkout")
    public void user_is_logged_in_for_checkout() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user adds items and proceeds to checkout {string} {string} {string} {string} {string}")
    public void checkouts(String firstname, String lastname, String address, String state, String postcode) {
        // Simply call the page class method and pass the parameters
        stack.checkouts(firstname, lastname, address, state, postcode);
    }

    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        System.out.println("Order placed successfully");
        driver.quit();
    }
}
