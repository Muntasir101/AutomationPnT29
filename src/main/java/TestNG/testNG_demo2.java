package TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG_demo2 {

    @Test
    public void login(){
        System.out.println("Login Successful.");

    }

    // Single depends on
    @Test(dependsOnMethods = {"login"})
    public void dashboard()  {
        System.out.println("Dashboard Open.");
    }

    // Multiple depends on
    @Test(dependsOnMethods = {"login", "dashboard"})
    public void logout()  {
        System.out.println("Logout Done.");
    }

}
