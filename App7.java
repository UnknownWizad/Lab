
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App7 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement collections = driver.findElement(By.xpath("//*[@id='vl-flyout-nav']/ul/li[5]"));
        action.moveToElement(collections).click().perform();

        WebElement comics = driver
                .findElement(By.xpath("//*[@id='mainContent']/section[2]/div[2]/span[1]/a/div[1]/img"));
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.moveToElement(comics).perform();
        Thread.sleep(3000);
        comics.click();

        WebElement bookTitle = driver
                .findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/div[2]/span[4]/a/div[1]/img"));
        action.sendKeys(Keys.ARROW_DOWN).perform();
        action.moveToElement(bookTitle).perform();
        Thread.sleep(3000);
        bookTitle.click();

        WebElement marvel = driver.findElement(By.xpath("//*[@id=\"s0-28-9-0-1[0]-0-0-12-list\"]/li[1]/a"));
        action.moveToElement(marvel).perform();
        Thread.sleep(3000);
        marvel.click();
        WebElement search = driver.findElement(By.xpath("//*[@id='gh-ac']"));
        search.sendKeys("decors");
        Thread.sleep(2000);
        action.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);
        search.sendKeys(" items");
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);

        driver.quit();
    }
}
