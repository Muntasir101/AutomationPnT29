package TutorialNinja;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Product_search_order {
    public static void main(String[] args) throws InterruptedException {
        TC_01_Product_Search_Valid();
    }

    public static void TC_01_Product_Search_Valid() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        //Search_Button
        WebElement Search_Button = driver.findElement(By.cssSelector("div#search > input[name='search']"));
        Search_Button.sendKeys("I Phone");

        //Search Product
        WebElement IPhone = driver.findElement(By.cssSelector("img[alt='iPhone']"));
        IPhone.click();

        //Quantity Button
        WebElement Qty_Button = driver.findElement(By.cssSelector("input#input-quantity"));
        Qty_Button.sendKeys("2");

        //Add To Cart
        WebElement Add_To_Cart = driver.findElement(By.cssSelector("button#button-cart"));
        Add_To_Cart.click();

        //Check_Out
        WebElement Check_Out = driver.findElement(By.cssSelector("a[title='Checkout'] > .hidden-md.hidden-sm.hidden-xs"));
        Check_Out.click();

        //Use Coupon Code
        WebElement Coupon = driver.findElement(By.cssSelector("#accordion .panel-default:nth-of-type(1) .fa-caret-down"));
        Coupon.click();

        //Coupon Search Box
        WebElement Coupon_Search_Box = driver.findElement(By.cssSelector("input#input-coupon"));
        Coupon_Search_Box.sendKeys("753520");

        //Apply Coupon
        WebElement Apply_Coupon = driver.findElement(By.cssSelector("input#button-coupon"));
        Apply_Coupon.click();

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

        driver.close();

    }
}
