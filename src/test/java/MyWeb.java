import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyWeb {

    WebDriver driver;
    @BeforeAll
    public void mySetUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void form() throws IOException, InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        WebElement accept = driver.findElement(By.id("onetrust-accept-btn-handler"));
        accept.click();
        //Utils.getSS(driver);
        driver.findElement(By.id("edit-name")).sendKeys("Md Rezaul Islam");
        driver.findElement(By.id("edit-number")).sendKeys("+880175254680");
        Utils.scroll(driver,0, 5000);
        driver.findElement(By.id("edit-email")).sendKeys("rezaul@gmail.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("Expertise in developing and implementing comprehensive test plans, test cases, and automated testing solutions to identify and rectify defects, ensuring optimal functionality and user satisfaction. Committed to maintaining up-to-date knowledge of emerging trends and quality assurance to drive continuous improvement. Seeking a challenging role in a dynamic organization where I can leverage my skills to contribute to the successful delivery of cutting-edge software products.");
        Utils.scroll(driver,0, 700);
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"./src/test/resources/screenshots/16-03-2024-10-08-PM.png");
        Thread.sleep(20000);
        driver.findElements(By.id("edit-age")).get(0).click();
        driver.findElements(By.id("edit-submit")).get(0).click();
        String actualMessage = driver.findElement(By.id("block-pagetitle-2")).getText();
        String expectedMessage = "Thank you for your submission!";
        Assertions.assertTrue(actualMessage.contains(expectedMessage));

    }
    @AfterAll
    public void close(){
        //driver.close();
    }


}
