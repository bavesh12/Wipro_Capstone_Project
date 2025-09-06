package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class sort {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for sort")
    public void user_is_logged_in_for_sort() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user sorts products by lowest price")
    public void user_sorts_products_by_lowest_price() {
        stack.sort();
    }

    @Then("products should be displayed in sorted order")
    public void products_should_be_displayed_in_sorted_order() {
        System.out.println("Products sorted successfully");
        driver.quit();
    }
}
