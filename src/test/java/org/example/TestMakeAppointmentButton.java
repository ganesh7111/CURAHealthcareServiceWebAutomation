package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//Verifying that clicking the "Make Appointment" button redirects to the appointment page.
public class TestMakeAppointmentButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        WebElement makeAppointmentBtn = driver.findElement(By.id("menu-toggle"));
        makeAppointmentBtn.click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Make Appointment");
    }
}
