package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test003 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\official\\Desktop\\Project-TestNG\\Test001\\libs\\chromedriver.exe");
	driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test003() throws Exception {
    driver.get("http://www.newtours.demoaut.com/");
    driver.findElement(By.name("userName")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("nadeeka12#");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Nadeesmtl123");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.name("fromPort")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.name("fromMonth")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Passengers:'])[1]/following::td[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
    driver.findElement(By.name("findFlights")).click();
    driver.findElement(By.name("reserveFlights")).click();
    driver.findElement(By.name("userName")).click();
    driver.findElement(By.name("userName")).clear();
    driver.findElement(By.name("userName")).sendKeys("nadeeka12#");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("Nadeesmtl123");
    driver.findElement(By.name("login")).click();
    driver.findElement(By.name("fromPort")).click();
    new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("London");
    driver.findElement(By.name("fromPort")).click();
    driver.findElement(By.name("toPort")).click();
    new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("New York");
    driver.findElement(By.name("toPort")).click();
    driver.findElement(By.name("toMonth")).click();
    new Select(driver.findElement(By.name("toMonth"))).selectByVisibleText("December");
    driver.findElement(By.name("toMonth")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Preferences'])[1]/following::font[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Airline:'])[1]/preceding::input[2]")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
