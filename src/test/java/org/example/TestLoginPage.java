package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        // Performing login
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        // Checking if login was successful
        try {
            // Waiting for the appointment button to be visible (indicating successful login)
            WebElement makeAppointmentBtn = driver.findElement(By.id("btn-book-appointment"));
            if (makeAppointmentBtn.isDisplayed()) {
                System.out.println("Login successful: Book Appointment button is visible.");
            }
        } catch (Exception e) {
            System.out.println("Login failed: Make Appointment button is not visible.");
        } finally {
            // Closing the browser
            driver.quit();
        }
    }
    }

