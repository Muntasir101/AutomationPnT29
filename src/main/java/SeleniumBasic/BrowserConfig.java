package SeleniumBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class BrowserConfig {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wikipedia.org/");

        WebElement searchBox = driver.findElement(By.cssSelector("input#searchInput"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));

        searchBox.clear();
        searchBox.sendKeys("Selenium");

        submitButton.click();

        Thread.sleep(5000);

        //driver.quit();
    }
}
