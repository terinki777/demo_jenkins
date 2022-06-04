package stepDef;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Site {
    public static WebDriver driver;
    public static WebElement params;


    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\JAVA\\Lessons\\ANTARA\\at_004\\" +
                "homeWork9CucumberAndGerkin\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void teardown() {
        driver.quit();
    }

    @Attachment
    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
