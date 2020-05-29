
import com.Utils;
import com.pageModules.iPageRepository.IpageLocatores;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Iterator;
import java.util.Set;

public class Spces extends Utils implements IpageLocatores {
    WebDriver driver;
    SoftAssert softAssert=new SoftAssert();

    @BeforeMethod
    public void launchBrowsers(){
        driver=launchBrowser();
    }
    @AfterMethod
    public void closeBrowsers(){
        closeBrowser();
    }

    @Test
    public void task1(){
        navToUrl("https://www.annauniv.edu/department/index.php");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(facultyOfCivilEr)).perform();
        actions.moveToElement(driver.findElement(By.id("menuItemHilite32"))).click().perform();
        softAssert.assertEquals(driver.getTitle(),"Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts");
        actions.moveToElement(driver.findElement(By.linkText("Research Themes"))).perform();
        actions.moveToElement(driver.findElement(By.id("menuItemHilite13"))).click().perform();
        softAssert.assertEquals(driver.getTitle(),":: IOM - Institute For Ocean Management - Anna University ::");
        softAssert.assertAll();
    }

    @Test
    public void task2(){
        navToUrl("https://triphobo.com");
        safeClick(planyourvacation);
        safeType(placeWherego, "Bhopal");
        safeClick(selectCity);
        safeClick(startDate);
        selectDate(sdate);
        safeClick(endDate);
        selectDate(eDate);
        safeClick(startPlanningBtn);
        safeClick(next);
        safeClick(thingsToDo);
        safeClick(next);
        waitForInvissibleElement(loader);
        safeClick(next);
        waitForInvissibleElement(loader);
        safeClick(next);
        safeClick(By.cssSelector(".solo-ep"));
        safeClick(next);
        waitForInvissibleElement(loader);
        safeClick(By.cssSelector("[class=\"view-tab calendar\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".icon-angle-down"))).perform();
        safeClick(By.cssSelector(".js-finish-planning"));
        softAssert.assertEquals(driver.getTitle(),"Travel Guide & Travel Information, Travel Advice, Reviews for: TripHobo");
        softAssert.assertAll();
    }
    @Test
    public void task3(){
        navToUrl("https://google.com");
        safeClick(gmail);
        safeClick(signin);
        Set set = driver.getWindowHandles();
        Iterator<String> iterator = set.iterator();
        String parentWin = iterator.next();
        String childWin = iterator.next();
        swichToWin(childWin);
        safeType(emailBox,"ankit20.sharma@paytmmoney.com");
        safeClick(nextBtn);
        safeType(pwdBox,"123456789");
        safeClick(nextBtn);
        closeBrowser();
        swichToWin(parentWin);
        navBack();
        safeType(googleSearchbox,"Selenium webdriver");
        safeClick(googleSearchBtn);
        softAssert.assertEquals(driver.getTitle(),"Selenium webdriver - Google Search");
        softAssert.assertAll();
    }
}

