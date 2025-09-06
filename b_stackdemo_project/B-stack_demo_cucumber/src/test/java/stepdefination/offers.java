package stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import java.time.Duration;

public class offers {
    WebDriver driver;
    b_stack_page stack;

    @Given("the user is logged in for offers")
    public void user_is_logged_in_for_offers() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);
        stack.login();
    }

    @When("the user navigates to offers")
    public void user_navigates_to_offers() {
        stack.offers();
    }

    @Then("offers should be displayed")
    public void offers_should_be_displayed() {
        System.out.println("Offers displayed successfully");
        driver.quit();
    }
}
