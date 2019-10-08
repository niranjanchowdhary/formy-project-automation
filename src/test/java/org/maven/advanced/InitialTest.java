package org.maven.advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InitialTest {
    private static WebDriver driver;

    @BeforeAll
    public static void createDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://github.com/niranjanchowdhary/SupportClasses.git");
    }

    @Test
    public void asInitialTest(){
        Assertions.assertEquals("Support Classes Example",driver.getTitle());
    }

    @AfterAll
    public void closeDriver(){
        driver.quit();
    }
}
