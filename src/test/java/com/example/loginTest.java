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

    // @Parameters({"username", "password"})

    @Test(priority = 2)
    void verifyCancelLeave() {
     leaveObj.gotoLeave();
     leaveObj.selectCancelCheck();
        // WebElement title;
    }
    

    @Test(priority =1)
    void VerifyRejectLeave() {

        driver.navigate().refresh();
        leaveObj.gotoLeave();
        boolean checkTemp=leaveObj.selectRejectedCheck();
        System.out.println(checkTemp);
        Assert.assertTrue(checkTemp);
        leaveObj.saveData();

    }


    @BeforeClass
    void launchWeb() {
        
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String title= driver.getTitle();
        Assert.assertEquals(title,"OrangeHRM", "launching fail fail");
    }
    @BeforeMethod
    void login(){
        logObj=new login(driver);
        leaveObj=new leave(driver);
        logObj.setvalue("Admin","admin123");
        boolean check=leaveObj.Dashboard();
        Assert.assertTrue(check);
    }
    @AfterMethod
    void userLogout(){
        try {
            leaveObj.logout();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

    
    
}
