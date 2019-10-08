package org.maven.advanced;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class QuickWinsTest {
    static WebDriver driver;

    @BeforeAll
    public static void createDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://github.com/niranjanchowdhary/SupportClasses.git/");

    }

    @Test
    public void canSelectAnOptionUsingSelect(){
        final WebElement selectMenu=driver.findElement(By.id("select-menu"));
        final Select select=new Select(selectMenu);
        select.selectByVisibleText("Options 3");
        //final List<WebElement> options=selectMenu.findElements(By.tagName("option"));
        //options.get(2).click();
        //final Long selectIndex=(Long)((JavascriptExecutor)driver).executeScript("return arguments[0].selectedIndex;",selectMenu);

        Assertions.assertEquals("3",select.getFirstSelectedOption().getAttribute("value"));
    }

    @Test
    public void findInstructionsByIdOrName(){

    }



}
