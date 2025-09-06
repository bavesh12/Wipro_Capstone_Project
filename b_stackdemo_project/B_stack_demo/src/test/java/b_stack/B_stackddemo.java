package b_stack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.b_stack_page;

public class B_stackddemo {
    WebDriver driver; 
    private b_stack_page stack;

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://bstackdemo.com/");
        stack = new b_stack_page(driver);

        // login once before all tests
        stack.login();
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    public void Favourites() throws InterruptedException {
        stack.fav();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void Offers() {
        stack.offers();
    }

    @Test(priority = 3)
    public void search() throws InterruptedException{
        stack.search_product();
    }

    @Test(priority = 4)
    public void sorting() throws InterruptedException {
        stack.sort();
        Thread.sleep(5000);
    }

    @Test(priority = 5)
    public void vendors() throws InterruptedException {
        stack.oneplus();
        Thread.sleep(1000);
        stack.samsung();
        Thread.sleep(1000);
        stack.google();
        Thread.sleep(1000);
        stack.apple();
        Thread.sleep(2000);

        //deslecton
        stack.oneplus();
        Thread.sleep(1000);
        stack.samsung();
        Thread.sleep(1000);
        stack.google();
        Thread.sleep(1000);
        stack.apple();
        Thread.sleep(2000);

        stack.oneplus();
        Thread.sleep(2000);
        
    }

    @Test(priority = 6)
    public void addtocart() throws InterruptedException {
        stack.addtocart();
        Thread.sleep(2000);
    }

    @Test(priority = 7)
    public void removefromcart() throws InterruptedException {
        stack.deleteitemfromcart();
        Thread.sleep(3000);
    }
    
    @Test(priority = 8)
    public void addtocart2() throws InterruptedException {
        stack.addtocart();
        Thread.sleep(2000);
    }


    @Test(priority = 9)
    public void checkout() throws InterruptedException {
        stack.checkout();
    }

    @Test(priority = 10)
    public void openPrivacyPolicy() throws InterruptedException {
        stack.privacypolicy();
        Thread.sleep(2000);
    }

    @Test(priority = 11)
    public void userLogout() throws InterruptedException {
        stack.logout();
        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        if (driver != null) {
            driver.quit();
        }
    }
}
