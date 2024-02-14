package TestNG;
import org.testng.annotations.Test;

public class DependsOn {

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
