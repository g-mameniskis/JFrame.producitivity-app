package com.graysonmameniskis;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String os = System.getProperty("os.name").toLowerCase();
        WebDriver driver = new ChromeDriver();

        if (os.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
        }

        driver.get("http://google.com");
        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
        driver.get("https://info.umkc.edu/womenc/wp-content/uploads/2018/01/Timesup.jpg");

    }
}
