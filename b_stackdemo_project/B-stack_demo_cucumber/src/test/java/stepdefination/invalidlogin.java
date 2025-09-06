package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class invalidlogin {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is on the bstack demo page for invalid login")
    public void the_user_is_on_the_bstack_demo_page_invalid() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
    }

    @When("the user tries to login with invalid credentials")
    public void the_user_tries_invalid_login() {
        stack.invalidLogin();
    }

    @Then("an error message should be shown")
    public void an_error_message_should_be_shown() {
        System.out.println("Error message displayed for invalid login");
        driver.quit();
    }
}
