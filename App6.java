import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App6 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "src\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.psghospitals.com/book-an-appointment/#dr_appointment");
        driver.manage().window().maximize();

        WebElement doctor = driver.findElement(By.xpath("//*[@id='Container']/div[1]/div[1]/a/img[2]"));
        doctor.click();
        Thread.sleep(10000);

        WebElement doctorappoin = driver.findElement(
                By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/ul/li[1]/a"));
        doctorappoin.click();
        WebElement name = driver.findElement(By.name("PatientName"));
        name.sendKeys("ruhi");
        WebElement email = driver.findElement(By.name("Email"));
        email.sendKeys("archu@gmail.com");
        WebElement num = driver.findElement(By.name("Mobile"));
        num.sendKeys("12345567890");

        // Preferreddate
        WebElement date = driver.findElement(By.name("Preferreddate"));
        date.sendKeys("26-09-2024");
        WebElement det = driver.findElement(By.name("OtherDetails"));
        det.sendKeys("nil");
        WebElement submit = driver
                .findElement(By.xpath("/html/body/div[5]/div/div/div/div/div/div/div/form/ul/li[10]/p/input"));
        submit.click();
        // OtherDetails
    }
}
