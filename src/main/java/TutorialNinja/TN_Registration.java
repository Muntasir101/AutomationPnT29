package TutorialNinja;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import org.json.simple.JSONObject;

public class TN_Registration {
    public static void main(String[] args) throws InterruptedException, IOException {
        TC_001_registration_valid();
        TC_002_registration_invalid_FirstName();
    }

    private static String generateRandomEmail(){
        String uuid = UUID.randomUUID().toString();
        return "user_" + uuid.substring(0, 8) + "@gmail.com";
    }

    private static String generateRandomPassword(){
        String uuid = UUID.randomUUID().toString();
        return  uuid.substring(0, 8);
    }
    public static void TC_001_registration_valid() throws InterruptedException, IOException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(3000);

        // Enter First Name
        WebElement FirstName= driver.findElement(By.cssSelector("#input-firstname"));
        FirstName.sendKeys("Shafi");

        // Enter Last Name
        WebElement LastName= driver.findElement(By.cssSelector("#input-lastname"));
        LastName.sendKeys("Mahmud");

        // Create a random Email Address
        String randomEmail = generateRandomEmail();

        // Create a random password
        String randomPassword =  generateRandomPassword();

        // Store the email and password in JSON object
        JSONObject userData = new JSONObject();
        userData.put("email", randomEmail);
        userData.put("password", randomPassword);

        // Write the JSON object to a file
        FileWriter file = new FileWriter("data/userdata.json");
        file.write(userData.toJSONString());
        file.flush();


        // Enter Email - Random unique Email
        WebElement Email= driver.findElement(By.cssSelector("#input-email"));
        Email.sendKeys(randomEmail);

        // Enter phone
        WebElement Phone= driver.findElement(By.cssSelector("#input-telephone"));
        Phone.sendKeys("6463878899");

        // Enter password
        WebElement Password= driver.findElement(By.cssSelector("input#input-password"));
        Password.sendKeys(randomPassword);

        // Enter confirm password
        WebElement ConfirmPassword= driver.findElement(By.cssSelector("input#input-confirm"));
        ConfirmPassword.sendKeys(randomPassword);

        // Click Subscribe
        WebElement SubscribeYesButton = driver.findElement(By.cssSelector("label:nth-of-type(1) > input[name='newsletter']"));
        SubscribeYesButton.click();

        // Click Privacy Policy
        WebElement PrivacyPolicy = driver.findElement(By.cssSelector("input[name='agree']"));
        PrivacyPolicy.click();

        // Click Continue button
        WebElement Continue_Button = driver.findElement(By.cssSelector("input[value='Continue']"));
        Continue_Button.click();

        // verify account created
        String Expected_Success_text = "Your Account Has Been Created!";
        String Actual_text = driver.findElement(By.cssSelector("#content h1")).getText();
        if(Expected_Success_text.equals(Actual_text)){
            System.out.println("Account created successfully.Test Passed.");
        }
        else{
            System.out.println("Account did not create.Test Failed!!!");
        }

        // Click Logout
        WebElement Logout_Button = driver.findElement(By.cssSelector("div > a:nth-of-type(13)"));
        Logout_Button.click();

        driver.close();

    }

    public static void TC_002_registration_invalid_FirstName() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        Thread.sleep(3000);

        // Keep First Name blank
       // WebElement FirstName= driver.findElement(By.cssSelector("#input-firstname"));
       // FirstName.sendKeys("");

        // Enter Last Name
        WebElement LastName= driver.findElement(By.cssSelector("#input-lastname"));
        LastName.sendKeys("Mahmud");

        // Enter Email - Random unique Email
        WebElement Email= driver.findElement(By.cssSelector("#input-email"));
        Email.sendKeys(generateRandomEmail());

        // Enter phone
        WebElement Phone= driver.findElement(By.cssSelector("#input-telephone"));
        Phone.sendKeys("6463878899");

        // Enter password
        WebElement Password= driver.findElement(By.cssSelector("input#input-password"));
        Password.sendKeys("123456");

        // Enter confirm password
        WebElement ConfirmPassword= driver.findElement(By.cssSelector("input#input-confirm"));
        ConfirmPassword.sendKeys("123456");

        // Click Subscribe
        WebElement SubscribeYesButton = driver.findElement(By.cssSelector("label:nth-of-type(1) > input[name='newsletter']"));
        SubscribeYesButton.click();

        // Click Privacy Policy
        WebElement PrivacyPolicy = driver.findElement(By.cssSelector("input[name='agree']"));
        PrivacyPolicy.click();

        // Click Continue button
        WebElement Continue_Button = driver.findElement(By.cssSelector("input[value='Continue']"));
        Continue_Button.click();

        // Verify Error Message display for first name
        String Expected_Error_Message_FirstName = "First Name must be between 1 and 32 characters!";
        String Actual_Error_Message_FirstName = driver.findElement(By.cssSelector("#account .text-danger")).getText();
        if (Expected_Error_Message_FirstName.equals(Actual_Error_Message_FirstName)){
            System.out.println("Error Message for First Name Displayed.Test Passed.");
        }
        else{
            System.out.println("Error Message for First Name Did not Display.Test Failed!!!");
        }

        driver.close();
    }


}
