
import java.time.Duration; 
import org.openqa.selenium.By;  
import org.openqa.selenium.Keys; 
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.interactions.Actions; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait; 
 
public class App4 { 
public static void main(String[] args) throws InterruptedException {  
System.setProperty("webdriver.chrome.driver","src\\Driver\\chromedriver.exe");  
WebDriver driver = new ChromeDriver();  
driver.get("https://www.coursera.org/?authMode=login");  
driver.manage().window().maximize(); 
 
// Email Field (id) 
WebElement emailInput = driver.findElement(By.id("email"));  
emailInput.sendKeys("727822tuit012@skct.edu.in"); 
 
// Password Field (name) 
WebElement passwordInput = driver.findElement(By.name("password"));  
passwordInput.sendKeys("Rakash@14"); 
 
// Mouse Handling for click login button (xpath) 
WebDriverWait login = new WebDriverWait(driver, Duration.ofSeconds(40));  
WebElement clickLogin = 
login.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div/div/section/section/div[1]/form/div[3]/button"))); 
clickLogin.click(); 
 
Thread.sleep(60000); 
 
// Search box (xpath) 
WebElement search = driver.findElement(By.xpath("//*[@id=\"rendered-content\"]/div/div[1]/div/span/div[1]/header/div[1]/div/div/div/div/div/div[1]/div/div/div[3]/div/div[2]/form/div/div[1]/input")); 
search.sendKeys("Testing methodologies"); 
 
// Keyboard selector for enter search button 
Actions actions = new Actions(driver); actions.sendKeys(Keys.ENTER).perform();
}
}

