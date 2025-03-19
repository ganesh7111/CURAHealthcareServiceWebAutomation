package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogOut {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Navigatting to Website to Login
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        //Loggin in
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-login")).click();

        //Navigating to menu-toggle
        WebElement toggleButton = driver.findElement(By.id("menu-toggle"));
        toggleButton.click();

        //Locating the "Profile" link within the menu
        WebElement profilelink = driver.findElement(By.xpath("//a[contains(@href, 'profile.php#profile')]"));
        profilelink.click();

        // Locate the Logout button
        WebElement logoutButton = driver.findElement(By.cssSelector("a.btn.btn-default"));

        // Click the Logout button
        logoutButton.click();

        //Checking weather logoed out or not
        String title = driver.getTitle();
        if (title.equals("CURA Healthcare Service")) {
            System.out.println("Confirmation: Your page is logged out");
        } else {
            System.out.println("Error: Your page is not logged out");
        }


    }
}
