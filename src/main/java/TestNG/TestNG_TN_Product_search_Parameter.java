package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_TN_Product_search_Parameter {
    WebDriver driver;

    @BeforeMethod
    public void testSetup() throws InterruptedException {
        driver = new FirefoxDriver();
        Reporter.log("Browser Launch..");
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        Reporter.log("Webpage open..");
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    @Parameters({"searchKeyword","quantity"})
    public void TC_01_Product_Search_Valid(String searchKeyword, String quantity) throws InterruptedException {

        //Search_Button
        WebElement Search_Button = driver.findElement(By.cssSelector("div#search > input[name='search']"));
        Search_Button.sendKeys(searchKeyword);
        Reporter.log("Search by " + searchKeyword);

        //Search Product
        WebElement IPhone = driver.findElement(By.cssSelector("img[alt='iPhone']"));
        IPhone.click();

        //Quantity Button
        WebElement Qty_Field = driver.findElement(By.cssSelector("input#input-quantity"));
        Qty_Field.clear();
        Qty_Field.sendKeys(quantity);
        Reporter.log("Add Quantity "+ quantity);

        //Add To Cart
        WebElement Add_To_Cart = driver.findElement(By.cssSelector("button#button-cart"));
        Add_To_Cart.click();
        Reporter.log("Click add to cart.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
