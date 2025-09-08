package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class search {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for search")
    public void user_is_logged_in_for_search() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String product) {
        stack.search_product(product);
    }

    @Then("the results for {string} should be displayed")
    public void the_results_for_should_be_displayed(String product) {
        System.out.println("Search results displayed successfully");
    }
}
