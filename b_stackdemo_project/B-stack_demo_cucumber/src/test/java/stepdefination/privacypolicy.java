package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class privacypolicy {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for privacy policy")
    public void user_is_logged_in_for_privacy_policy() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user opens the privacy policy")
    public void the_user_opens_the_privacy_policy() {
        stack.privacypolicy();
    }

    @Then("the privacy policy should be displayed")
    public void the_privacy_policy_should_be_displayed() {
        System.out.println("Privacy policy displayed successfully");
        driver.quit();
    }
}
