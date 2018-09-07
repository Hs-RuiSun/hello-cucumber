package com.cgi.action;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginAction {
    private static final String LOGIN_URL = "http://192.168.1.138:2020/#!/";
    
    static WebDriver driver;

    public static void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(LOGIN_URL);
        TimeUnit.SECONDS.sleep(5);
    }
    
    public static void attempLogin(String username, String password) {
        WebElement usernameElement = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement signinElement = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        signinElement.click();
    }
    
    public static boolean verifyLogin(UserType userType) throws InterruptedException {
        String verifyElementXpath = null;
        switch(userType) {
            case USER:
                verifyElementXpath = "//a[text()=' Map']";
                break;
            case ADMIN:
                verifyElementXpath = "";
                break;
            case SUPER:
                verifyElementXpath = "";
        }
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(verifyElementXpath)));
            return true;
        }catch(NoSuchElementException e) {
            System.out.println("why no such element????");
        }
        return false;
    }
}