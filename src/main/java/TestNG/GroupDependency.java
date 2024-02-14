package TestNG;

import org.testng.annotations.Test;

public class GroupDependency {

    @Test(groups = {"SignIn"})
    public void login(){
        System.out.println("Login Successful.");

    }

    @Test(groups = {"SignIn"})
    public void dashboard()  {
        System.out.println("Dashboard Open.");
    }

    @Test(dependsOnGroups = {"SignIn"})
    public void logout()  {
        System.out.println("Logout Done.");
    }
}
