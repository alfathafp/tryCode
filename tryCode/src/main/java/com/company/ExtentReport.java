package com.company;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;


public class ExtentReport {
    static ExtentTest test;
    static ExtentReports report;
    static WebDriver driver;


    @BeforeClass
    public static void startTest()
    {
        report = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("/Users/alfath/FinAccel/tryCode/extentreport/extentReportTrial.html");
        report.attachReporter(sparkReporter);
        test = report.createTest("ExtentDemo");
    }

    @Test
    public void extentReportsDemo() throws InterruptedException {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        Thread.sleep(3);
        driver.findElement(By.xpath("//div/input[@type='text']")).sendKeys("alfathfebriadi@gmail.com");
        Thread.sleep(3);
        driver.findElement(By.xpath("//div/input[@type='password']")).sendKeys("password");
        String title = driver.getTitle();
        System.out.println(title);
        if(driver.getTitle().contains("facebook")) {
            test.pass("Navigated to the specified UR");
        }
        else {
            test.fail("Test Failed");
        }
        driver.quit();
    }

    @AfterClass
    public static void afterClass(){
        driver.quit();
        report.flush();
    }


}
