
import org.openqa.selenium.By;  
import org.openqa.selenium.Keys; 
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.chrome.ChromeDriver;  
import org.openqa.selenium.interactions.Actions; 
 
public class App5 { 
public static void main(String[] args) throws Exception {  
System.setProperty("webdriver.chrome.driver","src\\Driver\\chromedriver.exe");  
WebDriver driver=new ChromeDriver();  
driver.get("https://www.linkedin.com/");  
driver.manage().window().maximize(); 
 
WebElement username = driver.findElement(By.id("session_key"));  
WebElement password = driver.findElement(By.id("session_password"));  
username.sendKeys("vishwakumar0410@gmail.com"); 
password.sendKeys("VISHWA4580"); 
 
WebElement sub = driver.findElement(By.xpath("//*[@id=\"main-content\"]/section[1]/div/div/form/div[2]/button")); 
sub.click();  
Thread.sleep(30000); 
 
//For typing the Job  
WebElement search = 
driver.findElement(By.xpath("/html/body/div[5]/header/div/div/div/div[1]/input"));  
search.sendKeys("Reactjs Developer jobs"); 
Actions actions = new Actions(driver);  
actions.sendKeys(Keys.ENTER).perform();  
Thread.sleep(4000); 

WebElement seeAllJob = 
driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[2]/div/div[1]/main/div/div/div[1]/div/div[2]/a")); 
seeAllJob.click();  
Thread.sleep(4000); 
 
//for Selecting the paticular Job from search result  
WebElement clickApply = 
driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[4]/div/div/main/div/div[2]/div[1]/div/ul/li[1]/div/div/div[1]/div[1]/div[2]/div[1]/a/strong")); 
clickApply.click();  
Thread.sleep(4000); 
 
//After selecting the job click apply  
WebElement clickApplyy = 
driver.findElement(By.xpath("/html/body/div[5]/div[3]/div[4]/div/div/main/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div[1]/div/div[1]/div[1]/div[5]/div/div/div/button/span")); 
clickApplyy.click(); 
 
//After selecting the job click Mobile Number  
WebElement mobilenumber = 
driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/div/div/div[4]/div/div/div[1]/div/input")); 
mobilenumber.sendKeys("7418529631");  
Thread.sleep(4000); 
  
//After selecting the job click Next Button  
WebElement nextButton = 
driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/div/div[2]/form/footer/div[2]/button")); 
nextButton.click(); 
 } 
}
