package com.company;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class scrappingselenium {

    @Test
    public void scrappingData() throws InterruptedException {
        WebDriver webDriver = new SafariDriver();
        webDriver.manage().window().maximize();

        //Specifiying pageLoadTimeout and Implicit wait
        webDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        webDriver.get("https://shopee.co.id/erigostore?shopCollection=243859973#product_list");
        Thread.sleep(1000);

//        String xpath = "//div[@class='shop-search-result-view__item col-xs-2-4'][1]//div[@class='HwO23R']";

//        String CasesCount = Utility.WebDriverHelper.Wdriver.findElement
//                (By.xpath("//button[text()=' "+tabname+"']/span")).getText();

//        get the clothes
//        List<WebElement> list = webDriver.findElements(By.xpath("//div[@class='shop-search-result-view__item col-xs-2-4']"));
//        int muchList = list.size();
        int muchList = 10;
        for (int i = 1; i <= muchList; i++) {
            clickWithJS(webDriver, "//div[@class='shop-search-result-view__item col-xs-2-4']["+i+"]//div[@class='HwO23R']");
            Thread.sleep(1000);
            String getStringName = webDriver.findElement(By.xpath("//div[@class='_44qnta']/span")).getText();
            String getStringPrice = webDriver.findElement(By.xpath("//div[@class='_44qnta']/following::div[@class='pqTWkA']")).getText();
            System.out.println(getStringName + ": " + getStringPrice);
            webDriver.navigate().back();
            Thread.sleep(1000);

        }

        System.out.println();
        webDriver.quit();

    }

    public void clickWithJS(WebDriver webDriver, String xpath){
        WebElement yourelement= webDriver.findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor)webDriver;
        executor.executeScript("arguments[0].click();", yourelement);
    }

}
