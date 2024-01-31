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
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("[maxlength]"));
        searchBox.clear();
        searchBox.sendKeys("Selenium Tutorial");
        Thread.sleep(5000);

        String desireSuggestionText = "selenium tutorial w3schools";

        while (true) {
            searchBox.sendKeys(Keys.ARROW_DOWN);
            Thread.sleep(1000);

            if (searchBox.getAttribute("value").equalsIgnoreCase(desireSuggestionText)){
                searchBox.sendKeys(Keys.ENTER);
                break;
            }
        }
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("#rso > div:nth-child(1) > div > div > div.kb0PBd.cvP2Ce.jGGQ5e > div > div > span > a > div > div > span")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
