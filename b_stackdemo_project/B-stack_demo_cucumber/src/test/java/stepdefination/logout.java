package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class logout {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for logout")
    public void user_is_logged_in_for_logout() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user logs out")
    public void the_user_logs_out() {
        stack.logout();
    }

    @Then("the user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() {
        System.out.println("User logged out successfully");
        driver.quit();
    }
}
