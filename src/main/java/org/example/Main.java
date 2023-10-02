package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://pastebin.com/");

        //accepting privacy terms
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//span[text()='AGREE']"))).click();


        //unique identifier when using cssSelector
        WebElement code = driver.findElement(By.cssSelector("#postform-text"));
        //adding requested text into code field
        code.sendKeys("Hello from WebDriver");

        //opening the paste expiration dropdown and selecting requested 10 minutes time
        WebElement pasteExpiration = driver.findElement(By.id("select2-postform-expiration-container"));
        pasteExpiration.click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();

        //adding the requested title
        WebElement title = driver.findElement(By.id("postform-name"));
        title.sendKeys("helloweb");

        //submitting by clicking the Create New Paste button
        WebElement createPasteInput = driver.findElement(By
                .xpath("//button[@type='submit' and contains(text(),'Paste')]"));
        createPasteInput.click();


        driver.quit();


    }
}
