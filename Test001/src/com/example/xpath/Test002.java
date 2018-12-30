package com.example.xpath;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test002 {
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
  public void test002() throws Exception {
    driver.get("https://www.calculator.net/");
    driver.findElement(By.xpath("//a[text()='Percentage Calculator']")).click();
    driver.findElement(By.xpath("//input[@id='cpar1']")).click();
    driver.findElement(By.xpath("//input[@id='cpar1']")).clear();
    driver.findElement(By.xpath("//input[@id='cpar1']")).sendKeys("5");
    driver.findElement(By.xpath("//input[@id='cpar2']")).click();
    driver.findElement(By.xpath("//input[@id='cpar2']")).clear();
    driver.findElement(By.xpath("//input[@id='cpar2']")).sendKeys("300");
    driver.findElement(By.xpath("//input[@value='Calculate']")).click();
    driver.findElement(By.xpath("//div[@id='content']//p[3]")).click();
    assertEquals(driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText(), "15");
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
