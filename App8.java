import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App8 {
    public static void main(String args[]) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com");
        driver.manage().window().maximize();

        // // Close the login popup if it appears
        // try {
        // WebElement closeLoginPopup =
        // driver.findElement(By.xpath("//button[contains(text(), '✕')]"));
        // closeLoginPopup.click();
        // } catch (Exception e) {
        // // Popup didn't appear, continue
        // }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Headphones");

        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for search results to load and click on the first result
        WebElement searchResult = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-tkid]/a[1]")));
        searchResult.click();

        // Replace with the correct XPath for the buy now button if applicable
        // WebElement buyNowButton =
        // wait.until(ExpectedConditions.elementToBeClickable(By.className("abutt
        // on-input")));

        // For example, if 'apply' refers to adding to cart, use correct XPath
        WebElement apply = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Add to Cart')]")));
        apply.click();

        driver.quit();
    }
}
