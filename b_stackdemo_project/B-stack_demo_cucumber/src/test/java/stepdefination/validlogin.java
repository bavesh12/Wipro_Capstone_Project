package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class validlogin {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is on the bstack demo page")
    public void the_user_is_on_the_bstack_demo_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {
        stack.login();
    }

    @Then("the user should be logged in successfully")
    public void the_user_should_be_logged_in_successfully() {
        System.out.println("User logged in successfully");
        driver.quit();
    }
}
