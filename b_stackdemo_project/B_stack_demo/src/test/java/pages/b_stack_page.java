package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

public class b_stack_page {
    WebDriver driver;
    WebDriverWait wait;

    public b_stack_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Utility: Safe click with JS fallback
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

    public void fav() {
        safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
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
        try {
            // Read test data from Excel
            String filePath = "src/test/resources/testdata/checkoutdata.xlsx";
            Map<String, String> testData = ExcelReader.getCheckoutData(filePath, "Sheet1");
            
            // Extract data from map
            String firstName = testData.get("firstName");
            String lastName = testData.get("lastName");
            String address = testData.get("address");
            String state = testData.get("state");
            String postalCode = testData.get("postalCode");
            
            // Add fresh items before checkout
            safeClick(By.xpath("//*[@id='__next']/div/div/main/div[1]/div[4]/label/span"));
            safeClick(By.xpath("//*[@id='21']/div[4]"));
            safeClick(By.xpath("//*[@id='22']/div[4]"));
            safeClick(By.cssSelector(".buy-btn"));

            // Fill form with Excel data
            WebElement fname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstNameInput")));
            fname.clear();
            fname.sendKeys(firstName);

            WebElement lname = driver.findElement(By.id("lastNameInput"));
            lname.clear();
            lname.sendKeys(lastName);

            WebElement addr = driver.findElement(By.id("addressLine1Input"));
            addr.clear();
            addr.sendKeys(address);

            WebElement stateInput = driver.findElement(By.id("provinceInput"));
            stateInput.clear();
            stateInput.sendKeys(state);

            WebElement pin = driver.findElement(By.id("postCodeInput"));
            pin.clear();
            pin.sendKeys(postalCode);

            safeClick(By.id("checkout-shipping-continue"));
            safeClick(By.xpath("//*[@id=\"checkout-app\"]/div/div/div/div/a/button"));
            
        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
            throw new RuntimeException("Failed to read test data from Excel", e);
        }
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
