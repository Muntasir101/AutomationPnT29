package Google;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("[maxlength]"));
        searchBox.clear();
        searchBox.sendKeys("Selenium Tutorial");

        // Simulate arrow down three times
        for (int i = 0; i <= 1; i++) {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(2000);
        }

        // Press Enter to select highlighted result
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(5);

    }
}
