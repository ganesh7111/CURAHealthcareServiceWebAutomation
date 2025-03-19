package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestHistoryOfAppointments {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //logging in
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Performing login
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        //Navigating to History
        WebElement toggleButton = driver.findElement(By.id("menu-toggle"));
        toggleButton.click();

        //Locating the "Profile" link within the menu
        WebElement profilelink = driver.findElement(By.xpath("//a[contains(@href, 'history.php#history')]"));
        profilelink.click();

        //Chcking if there are any appointments
        WebElement noAppointmentMessage = driver.findElement(By.xpath("//p[text()='No appointment.']"));
        if (noAppointmentMessage.isDisplayed()) {
            System.out.println("No appointments found.");
        } else {
            // Find and print the appointments
            List<WebElement> appointments = driver.findElements(By.xpath("//div[@class='col-xs-12 col-sm-6']"));
            for (WebElement appointment : appointments) {
                System.out.println(appointment.getText());
            }

        }
    }
}
