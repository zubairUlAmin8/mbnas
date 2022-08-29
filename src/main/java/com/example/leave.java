package com.example;

import java.util.List;

// import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class leave {
    WebDriver driver;
    By leave=By.id("menu_leave_viewLeaveModule");
    By cancled= By.id("leaveList_chkSearchFilter_0");
    By search=By.id("btnSearch");
    By all=By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck");
    By rejected=By.id("leaveList_chkSearchFilter_-1");
    By scheduled=By.id("leaveList_chkSearchFilter_0");
    By pendingApproval=By.id("leaveList_chkSearchFilter_1");
    By taken=By.id("leaveList_chkSearchFilter_3");
    By deshboard=By.linkText("Dashboard");
    By selectAction=By.xpath("//div[@class='message warning fadable']");

    By status= By.xpath("//table[@id='resultTable']//tbody//tr//td[]");
    By saveButton=By.id("btnSave");

    By profileIcon=By.id("welcome");
    By logout=By.xpath("//a[contains(text(), 'Logout')]");


    int rowSize;


    leave(WebDriver driver){
        this.driver=driver;
    }
    public boolean Dashboard(){
        boolean b=false;        
        WebElement desh= driver.findElement(deshboard);
        String temp=desh.getText();

        if(temp.equals(desh.getText())){
            b=true;
        }
        return b;
    }
    public void gotoLeave(){
        driver.findElement(leave).click();
    }
    public void selectCancelCheck(){
        driver.findElement(cancled).click();
        if(driver.findElement(pendingApproval).isSelected());
        {
            driver.findElement(pendingApproval).click();
        }
        driver.findElement(search).click();
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr"));
        System.out.println("Total Canceled Leave: "+rows.size());

    }

    public Boolean selectRejectedCheck(){

        boolean check=false;

        driver.findElement(rejected).click();
        if(driver.findElement(pendingApproval).isSelected());
        {
            driver.findElement(pendingApproval).click();
        }
        
        driver.findElement(search).click();
        List<WebElement> rows= driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr"));
        List<WebElement> statusColoum= driver.findElements(By.xpath("//table[@id='resultTable']//tbody//tr//td[6]"));
        System.out.println("Total Rejected Leave:"+rows.size());
        rowSize=rows.size();
        for(WebElement col: statusColoum ){

            String checkRejected= col.getText();
            String subStrRejected= checkRejected.substring(0, 8);
            if(subStrRejected.equals("Rejected"))
            {
                check=true;
            }
            else
            {
                check = false;
                break;
            }
        }
        return check;
    }
    public void logout() throws InterruptedException{
        driver.findElement(profileIcon).click();
        Thread.sleep(2000);
        driver.findElement(logout).click();

    }
    public boolean saveData() throws InterruptedException {
        driver.findElement(saveButton).click();
        boolean temp=false;
        Thread.sleep(2000);
        String tem=driver.findElement(selectAction).getText();
         if(tem.equals("Select Action")){
             temp=true;
         }
        return temp;

    }

}
