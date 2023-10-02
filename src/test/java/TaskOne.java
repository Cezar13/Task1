import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TaskOne {
    WebDriver driver = new EdgeDriver();

    @AfterTest
    public void quitBrowser() {
        driver.quit();
    }

    @Test
    public void testTask1() {

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
        String addedTitle = "helloweb";
        WebElement title = driver.findElement(By.id("postform-name"));
        title.sendKeys(addedTitle);

        //submitting by clicking the Create New Paste button
        WebElement createPasteInput = driver.findElement(By
                .xpath("//button[@type='submit' and contains(text(),'Paste')]"));
        createPasteInput.click();
        System.out.println("Test");

        //add assertion
        WebElement resultTitle = driver.findElement(By.cssSelector(".info-top"));
        Assert.assertEquals(resultTitle.getText(), addedTitle, "Title is not " + addedTitle);
        //failed assert example
//        Assert.assertEquals("toFail", addedTitle, "Title is not " + addedTitle);
        //soft verify assertion
        System.out.println(resultTitle.getText() + " vs " + addedTitle);
    }
}
