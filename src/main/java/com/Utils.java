package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Utils {
    public WebDriverWait wait;
    WebDriver driver;

    public WebDriver launchBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void navToUrl(String url) {
        driver.get(url);
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public void safeClick(By element) {
        waitForElement(element);
        waitforElementToBeClickable(element);
        driver.findElement(element).click();
    }

    public void safeType(By element, String value) {
        waitForElement(element);
        driver.findElement(element).sendKeys(value);
    }

    public void quitBrowser() {
        driver.quit();
    }

    public void closeBrowser() {
        driver.close();
    }

    public void waitForElement(By element) {
        try{
            wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        }catch (Exception e){ e.printStackTrace();}
    }

//    public void mauseOverEvent(By element) {
////        waitForElement(element);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(driver.findElement(element)).click().perform();
//    }

    public void swichToWin(String id) {
        driver.switchTo().window(id);
    }

    public void navBack() {
        driver.navigate().back();
    }

    public void selectDate(By ele) {
        while (true){
            try {
                safeClick(ele);
                break;
            } catch (Exception e) {
                safeClick(By.cssSelector("[title=\"Next\"]"));
            }
        }
    }

    public void waitforElementToBeClickable(By element) {
        try{
            wait = new WebDriverWait(driver, 120);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){e.printStackTrace();}
    }

    public void jsClick(By element) {
        waitforElementToBeClickable(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeAsyncScript("arguments[0].click();", element);
    }
    public void waitForInvissibleElement(By element){
        try{
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(element)));
        }catch (Exception e){ e.printStackTrace();}
    }
    public boolean isDisplay(By element){
        waitForElement(element);
        return driver.findElement(element).isDisplayed();
    }

}
