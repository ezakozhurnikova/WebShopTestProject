package com.webshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class AppManager {
    String browser;
    public WebDriver driver;


    UserHelper user;


    public AppManager(String browser) {
        this.browser = browser;
    }

    public UserHelper getUser() {
        return user;
    }


    public void init() {
        System.err.close(); //убирает системные warnings

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            //  driver=new FirefoxDriver();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new FirefoxDriver(options);

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions options = new EdgeOptions();
            options.addArguments("remote-allow-origins=*");
            driver = new EdgeDriver(options);

        }


        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);


    }

    public void stop() {
        driver.quit();
    }

}
