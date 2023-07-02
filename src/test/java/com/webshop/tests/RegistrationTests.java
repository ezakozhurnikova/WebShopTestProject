package com.webshop.tests;

import com.webshop.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    WebDriver driver;

    @BeforeMethod

   public void setUp() {
      ChromeOptions options = new ChromeOptions();
        options.addArguments("remote-allow-origins=*");
        driver = new ChromeDriver();
        driver.navigate().to("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        app.getUser().clickOnRegister();
    }

    @Test

    public void positiveRegistrationTest(){

app.getUser().fillLoginRegistrationForm(new User().setFirstName("Axel")
        .setLastName("Springer")
        .setEmail("springer@gmail.com")
        .setPassword("Springer1!"));
app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//*[@class='result']")));
    }

}
