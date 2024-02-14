package TestNG;

import org.testng.annotations.Test;

public class GroupDependency2 {

    @Test(groups = {"Login"})
    public void Login(){
        System.out.println("Login Successful.");

    }

    @Test(groups = {"Dashboard"})
    public void dashboard()  {
        System.out.println("Dashboard Open.");
    }

    @Test(groups = {"Logout"})
    public void logout()  {
        System.out.println("Logout Done.");
    }
}
