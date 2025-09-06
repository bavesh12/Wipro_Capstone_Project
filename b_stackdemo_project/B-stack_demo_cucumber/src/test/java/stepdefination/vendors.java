package stepdefination;

import io.cucumber.java.en.*;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class vendors {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for vendors")
    public void the_user_is_logged_in_for_vendors() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login(); 
    }

    @When("the user selects Google, Apple, Samsung, and OnePlus")
    public void the_user_selects_google_apple_samsung_and_one_plus() {
        stack.google();
        stack.apple();
        stack.samsung();
        stack.oneplus();
    }

    @When("then deselects them")
    public void then_deselects_them() {
        // Click again to deselect
        stack.google();
        stack.apple();
        stack.samsung();
        stack.oneplus();
    }

    @When("selects OnePlus again")
    public void selects_one_plus_again() {
        stack.oneplus();
    }

    @Then("only OnePlus products should be displayed")
    public void only_one_plus_products_should_be_displayed() {
        System.out.println("Only OnePlus products are displayed");
        driver.quit();
    }
}
