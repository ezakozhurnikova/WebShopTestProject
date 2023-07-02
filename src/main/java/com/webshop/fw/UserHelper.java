package com.webshop.fw;

import com.webshop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegister() {

        click(By.xpath("//*[@class='ico-register']"));
    }
    public void fillLoginRegistrationForm(User user) {
        click(By.xpath("//input[@id='gender-male']"));
        type(By.xpath("//*[@id='FirstName']"), user.getFirstName());
        type(By.xpath("//*[@id='LastName']"), user.getLastName());
        type(By.xpath("//*[@id='Email']"), user.getEmail());
        type(By.xpath("//*[@id='Password']"), user.getPassword());
        type(By.xpath("//*[@id='ConfirmPassword']"), user.getPassword());
    }
    public void clickOnRegistrationButton(){
        click(By.xpath("//*[@id='register-button']"));
    }
}
