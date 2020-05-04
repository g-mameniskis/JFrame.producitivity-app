//package com.graysonmameniskis;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class NewTab {
//
//    private MyTimer myTimer;
//
//    public void openNewTab() {
//        String os = System.getProperty("os.name").toLowerCase();
//        WebDriver driver = new ChromeDriver();
//
//        if (os.contains("mac")) {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
//        } else {
//            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
//        }
//
//        driver.findElement(By.cssSelector("Body")).sendKeys(Keys.CONTROL + "t");
//        driver.get("https://info.umkc.edu/womenc/wp-content/uploads/2018/01/Timesup.jpg");
//    }
//
//    public boolean isMinutesElapsed25() {
//        if (myTimer.getElapsedMinutes() == 1) {
//            return true;
//        }
//
//        return false;
//    }
//}
