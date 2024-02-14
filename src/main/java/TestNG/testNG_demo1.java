package TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG_demo1 {

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method Executed.");
    }

    @Test
    public void testCase1()  {
        System.out.println("Test case 1 Executed.");
    }

    @Test
    public void testCase2()  {
        System.out.println("Test case 2 Executed.");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method Executed.");
    }

}
