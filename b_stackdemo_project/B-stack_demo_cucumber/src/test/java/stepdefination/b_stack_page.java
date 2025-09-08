package stepdefination;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class b_stack_page {
    WebDriver driver;
    WebDriverWait wait;

    public b_stack_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //Safe click with JS fallback
    private void safeClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void invalidLogin() {
        safeClick(By.id("signin"));
        safeClick(By.id("password"));
        safeClick(By.xpath("//div[text()='testingisfun99']"));
        safeClick(By.id("login-btn"));
    }

    public void login() {
        try {
            safeClick(By.id("signin"));
            safeClick(By.id("username"));
            safeClick(By.xpath("//div[text()='demouser']"));
            safeClick(By.id("password"));
            safeClick(By.xpath("//div[text()='testingisfun99']"));
            safeClick(By.id("login-btn"));
        } catch (Exception e) {
            System.out.println("Already logged in, skipping login.");
        }
    }

    public void fav() throws InterruptedException {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
        Thread.sleep(1500);
        safeClick(By.xpath("//*[@id='21']/div[1]/button"));
        safeClick(By.id("favourites"));
    }

    public void offers() {
        safeClick(By.id("offers"));
    }

    public void search_product() throws InterruptedException {
        safeClick(By.cssSelector("img.Navbar_logo__image__3Blki"));
        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("input[placeholder='Search']")));
        search.sendKeys("Apple");
        search.sendKeys(Keys.ENTER);
        safeClick(By.cssSelector("button.px-4"));
        Thread.sleep(1000);
        
    }

    public void sort() {
        safeClick(By.cssSelector("img.Navbar_logo__image__3Blki"));
        safeClick(By.cssSelector("select>option[value='lowestprice']"));
    }

    public void oneplus() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
    }

    public void samsung() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[2]/label/span"));
    }

    public void google() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[3]/label/span"));
    }

    public void apple() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[1]/label/span"));
    }
    
    

    public void addtocart() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
        safeClick(By.xpath("//*[@id='21']/div[4]"));
        safeClick(By.xpath("//*[@id='22']/div[4]"));
        safeClick(By.cssSelector("div.float-cart__close-btn"));
    }
   

    public void deleteitemfromcart() {
        // Open cart
        safeClick(By.cssSelector("span[class='bag bag--float-cart-closed']"));

        // Delete first item
        safeClick(By.cssSelector("div[class='shelf-item__del']"));

        // Try deleting a second item if present
        try {
            safeClick(By.cssSelector("div[class='shelf-item__del']"));
        } catch (Exception e) {
            System.out.println("Only one item in cart, deleted successfully.");
        }
    }


    public void checkout() {
        // Add fresh items before checkout
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
        safeClick(By.xpath("//*[@id='21']/div[4]"));
        safeClick(By.xpath("//*[@id='22']/div[4]"));
        safeClick(By.cssSelector(".buy-btn"));

        WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstNameInput")));
        fname.sendKeys("sai bavesh", Keys.ENTER);

        WebElement lname = driver.findElement(By.id("lastNameInput"));
        lname.sendKeys("vellampalli", Keys.ENTER);

        WebElement address = driver.findElement(By.id("addressLine1Input"));
        address.sendKeys("hyderabad", Keys.ENTER);

        WebElement state = driver.findElement(By.id("provinceInput"));
        state.sendKeys("Telengana", Keys.ENTER);

        WebElement pin = driver.findElement(By.id("postCodeInput"));
        pin.sendKeys("500008", Keys.ENTER);

        safeClick(By.xpath("//*[@id='checkout-app']/div/div/div/div/a/button"));
    }

    public void privacypolicy() {
        safeClick(By.cssSelector("img.Navbar_logo__image__3Blki"));
        safeClick(By.cssSelector("span.block.absolute"));
    }

    public void logout() {
        try {
            safeClick(By.id("signin"));
            System.out.println("User logged out.");
        } catch (Exception e) {
            System.out.println("Already logged out, skipping logout.");
        }
    }
}


