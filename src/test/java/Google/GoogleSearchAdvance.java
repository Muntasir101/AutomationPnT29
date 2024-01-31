package Google;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;


public class GoogleSearchAdvance {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("[maxlength]"));
        searchBox.clear();
        searchBox.sendKeys("Selenium Tutorial");
        Thread.sleep(5000);


        String desireSuggestionText = "Selenium Tutorial guru99";

        while (true){
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(2000);

            if (searchBox.getAttribute("value").equalsIgnoreCase(desireSuggestionText)){
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
        }

        Thread.sleep(5000);

        driver.close();

    }
}
