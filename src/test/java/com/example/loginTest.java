package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
    WebDriver driver;
    login logObj;
    leave leaveObj;

    @Test(priority = 2)
    void verifyCancelLeave() {
     leaveObj.gotoLeave();
     leaveObj.selectCancelCheck();
        try {
            Assert.assertTrue(leaveObj.saveData());
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        // WebElement title;
    }

    @Test(priority =1)
    void VerifyRejectLeave() {

        driver.navigate().refresh();
        leaveObj.gotoLeave();
        boolean checkTemp=leaveObj.selectRejectedCheck();
        System.out.println(checkTemp);
        Assert.assertTrue(checkTemp);
        try {
            Assert.assertTrue(leaveObj.saveData());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    @BeforeClass
    void launchWeb() {
        
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String title= driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM", "launching fail");
    }
    @BeforeMethod
    @Parameters({"username", "password"})
    void login(String username, String password)
    {
        logObj=new login(driver);
        leaveObj=new leave(driver);
        logObj.setvalue(username,password);
        boolean check=leaveObj.Dashboard();
       Assert.assertTrue(check);
    }
    @AfterMethod
    void userLogout(){
        try {
            leaveObj.logout();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

    
    
}
