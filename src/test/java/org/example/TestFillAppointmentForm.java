package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class TestFillAppointmentForm {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

            // Handle login
            driver.findElement(By.id("btn-make-appointment")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt-username")));
            driver.findElement(By.id("txt-username")).sendKeys("John Doe");
            driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
            driver.findElement(By.id("btn-login")).click();

            // Wait for appointment form to load
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility")));

            // Facility dropdown
            Select dropdown = new Select(driver.findElement(By.id("combo_facility")));
            dropdown.selectByVisibleText("Seoul CURA Healthcare Center");

            // Hospital readmission checkbox
            WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            // Medicaid program radio
            WebElement radioMedico = driver.findElement(By.id("radio_program_medicaid"));
            radioMedico.click();

            // Visit date
            WebElement dateField = driver.findElement(By.id("txt_visit_date"));
            dateField.sendKeys("05/22/2025"); // MM/DD/YYYY format

            // Comment
            WebElement comment = driver.findElement(By.id("txt_comment"));
            comment.sendKeys("Fever, Body Pains");

            // Submit
            driver.findElement(By.id("btn-book-appointment")).click();

            // Wait for confirmation
            wait.until(ExpectedConditions.urlContains("appointment.php#summary"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}