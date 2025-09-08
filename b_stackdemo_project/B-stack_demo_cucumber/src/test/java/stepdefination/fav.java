package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class fav{
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for favourites")
    public void user_is_logged_in_for_favourites() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user adds a product to favourites")
    public void user_adds_product_to_favourites() throws InterruptedException{
        stack.fav();
    }

    @Then("the product should be in the favourites list")
    public void product_should_be_in_the_favourites_list() {
        System.out.println("Product added to favourites successfully");
        driver.quit();
    }
}

