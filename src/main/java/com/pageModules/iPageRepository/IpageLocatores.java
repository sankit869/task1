package com.pageModules.iPageRepository;

import org.openqa.selenium.By;

public interface IpageLocatores {
    By dept = By.linkText("Departments");
    By facultyOfCivilEr=By.xpath("//strong[contains(text(),'Faculty of Civil Engineering')]");


    //task 2
    By planyourvacation = By.linkText("Plan Your Next Vacation");
    By placeWherego = By.cssSelector("[class=\"input-control js_city_search\"]");
    By selectCity = By.xpath("//ul[@class=\"city-list-collection\"]/li[1]");
    By startDate = By.cssSelector("[placeholder='Start Date']");
    By endDate = By.cssSelector("[placeholder=\"End Date\"]");
    By sdate = By.linkText("10");
    By eDate = By.xpath("(//a[text()='14'])[1]");
    By startPlanningBtn = By.cssSelector(".start-planning");
    By next = By.xpath("(//span[text()='Next'])[1]");
    By loader = By.cssSelector(".loader-body");
    By thingsToDo = By.xpath("(//span[text()='Things to do'])[3]");
//    By nextButton = By.cssSelector(".js-next-alreadybooked");


    //task 3
    By gmail = By.linkText("Gmail");
    By signin = By.partialLinkText("Sign in");
    By emailBox = By.id("identifierId");
    By nextBtn = By.xpath("//span[text()='Next']");
    By pwdBox = By.name("password");
    By googleSearchbox = By.name("q");
    By googleSearchBtn = By.name("btnK");
}
