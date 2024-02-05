package SeleniumBasic;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Apple {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.apple.com/");
        Thread.sleep(5000);

        // verify home page open by Title
        String expectedHomeTitle = "Apple";
        String actualHomeTitle = driver.getTitle();

        if(expectedHomeTitle.equals(actualHomeTitle)){
            System.out.println("Title Matched.Home page opened");
        }
        else{
            System.out.println("Title mismatch.");
        }

        driver.close();

    }
}
