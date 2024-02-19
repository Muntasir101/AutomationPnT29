package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_TN_Product_search_order {
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
    public void TC_01_Product_Search_Valid() throws InterruptedException {

        //Search_Button
        WebElement Search_Button = driver.findElement(By.cssSelector("div#search > input[name='search']"));
        Search_Button.sendKeys("I Phone");
        Reporter.log("Search..");

        //Search Product
        WebElement IPhone = driver.findElement(By.cssSelector("img[alt='iPhone']"));
        IPhone.click();

        //Quantity Button
        WebElement Qty_Button = driver.findElement(By.cssSelector("input#input-quantity"));
        Qty_Button.sendKeys("2");
        Reporter.log("Add Quantity..");

        //Add To Cart
        WebElement Add_To_Cart = driver.findElement(By.cssSelector("button#button-cart"));
        Add_To_Cart.click();
        Reporter.log("Click add to cart.");

        //Check_Out
        WebElement Check_Out = driver.findElement(By.cssSelector("a[title='Checkout'] > .hidden-md.hidden-sm.hidden-xs"));
        Check_Out.click();
        Reporter.log("Click Checkout.");

        //Use Coupon Code
        WebElement Coupon = driver.findElement(By.cssSelector("#accordion .panel-default:nth-of-type(1) .fa-caret-down"));
        Coupon.click();
        Reporter.log("Click Coupon.");

        //Coupon Search Box
        WebElement Coupon_Search_Box = driver.findElement(By.cssSelector("input#input-coupon"));
        Coupon_Search_Box.sendKeys("753520");

        //Apply Coupon
        WebElement Apply_Coupon = driver.findElement(By.cssSelector("input#button-coupon"));
        Apply_Coupon.click();
        Reporter.log("Click Apply Coupon.");

        //Shipping & Taxes
        WebElement Shipping_Taxes = driver.findElement(By.cssSelector("#accordion .panel-default:nth-of-type(2) .fa-caret-down"));
        Shipping_Taxes.click();

        //Country Drop Down
        Select Country_Drop_down = new Select(driver.findElement(By.cssSelector("select#input-country")));
        Country_Drop_down.selectByValue("18");
        Thread.sleep(3000);

        //Region Drop Down
        Select Region_Drop_Down = new Select(driver.findElement(By.cssSelector("#input-zone")));
        Region_Drop_Down.selectByValue("322");

        //Post Code
        WebElement Post_Code = driver.findElement(By.cssSelector("input#input-postcode"));
        Post_Code.sendKeys("1216");

        //Get Quotes
        WebElement Get_Quotes = driver.findElement(By.cssSelector("button#button-quote"));
        Get_Quotes.click();

        //Flat Shipping Rate
        WebElement Flat_Shipping_modal = driver.findElement(By.id("modal-shipping"));
        WebElement Flat_Shipping_rate = Flat_Shipping_modal.findElement(By.cssSelector("input[name='shipping_method']"));
        Flat_Shipping_rate.click();
        Thread.sleep(3000);
        WebElement Apply_Shipping = Flat_Shipping_modal.findElement(By.cssSelector("input#button-shipping"));
        Apply_Shipping.click();

        //Final Check_Out
        WebElement Final_Check_Out = driver.findElement(By.cssSelector("#content div:nth-child(8) .btn-primary"));
        Final_Check_Out.click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
