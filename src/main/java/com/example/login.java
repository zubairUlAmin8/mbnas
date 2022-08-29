package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login {
    WebDriver driver;
    By username= By.id("txtUsername");
    By password= By.id("txtPassword");
    By submit= By.id("btnLogin");
    login(WebDriver driver){
        this.driver=driver;
    }
    void setvalue(String name, String pass)
    {
        driver.findElement(username).sendKeys(name);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(submit).click();
    }


}
