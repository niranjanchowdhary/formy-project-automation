package org.maven.advanced;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestRun {
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\Web Driver Jars\\geckodriver-v0.25.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/keypress");
        WebElement name=driver.findElement(By.id("name"));
        name.click();
        name.sendKeys("Prashanth Niranjan");

        WebElement button = driver.findElement(By.id("button"));
        button.click();

        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement autocomplete=driver.findElement(By.id("autocomplete"));
        autocomplete.sendKeys("231/B/244,Sri Krina Nagar,Hyderabad");

        WebElement street_number=driver.findElement(By.id("street_number"));
        street_number.sendKeys("B-block");

        WebElement route=driver.findElement(By.id("route"));
        route.sendKeys("Jubli Hills Road No-5");

        WebElement locality=driver.findElement(By.id("locality"));
        locality.sendKeys("Hyderabad");

        WebElement administrative_area_level_1=driver.findElement(By.id("administrative_area_level_1"));
        administrative_area_level_1.sendKeys("Yousuf guda");

        WebElement postal_code=driver.findElement(By.id("postal_code"));
        postal_code.sendKeys("500045");

        WebElement country=driver.findElement(By.id("country"));
        country.sendKeys("India");

        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement uname=driver.findElement(By.id("name"));
        Actions actions1=new Actions(driver);
        actions1.moveToElement(uname);
        uname.sendKeys("Prashanth Niranjan");

        WebElement date=driver.findElement(By.id("date"));
        date.sendKeys("25/09/2019");

        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement newTabButton=driver.findElement(By.id("new-tab-button"));
        newTabButton.click();

        String originalHandle=driver.getWindowHandle();
        for (String handle:driver.getWindowHandles()){
            driver.switchTo().window(handle);
        }

        driver.switchTo().window(originalHandle);

        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement alertButton=driver.findElement(By.id("alert-button"));
        alertButton.click();

        Alert alert=driver.switchTo().alert();
        alert.accept();

        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement modalButton=driver.findElement(By.id("modal-button"));
        modalButton.click();

        WebElement closeButton=driver.findElement(By.id("close-button"));
        JavascriptExecutor executor=(JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();",closeButton);

        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement image=driver.findElement(By.id("image"));
        WebElement box=driver.findElement(By.id("box"));
        Actions dragDrop=new Actions(driver);
        dragDrop.dragAndDrop(image,box).build().perform();

        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radioButton1=driver.findElement(By.id("radio-button-1"));
        radioButton1.click();

        WebElement radioButton2=driver.findElement(By.cssSelector("input[value='option2']"));
        radioButton2.click();

        WebElement radioButton3=driver.findElement(By.xpath("/html/body/div/div[3]/label"));
        radioButton3.click();

        driver.get("https://formy-project.herokuapp.com/checkbox");
        WebElement checkBoxes1=driver.findElement(By.id("checkbox-1"));
        checkBoxes1.click();

        WebElement checkBoxes2=driver.findElement(By.cssSelector("input[value='checkbox-2']"));
        checkBoxes2.click();

        WebElement checkBoxes3=driver.findElement(By.xpath("//*[@id=\"checkbox-3\"]"));
        checkBoxes3.click();

        driver.get("https://formy-project.herokuapp.com/datepicker");
        WebElement dateField=driver.findElement(By.id("datepicker"));
        dateField.sendKeys("11/10/1993");
        dateField.sendKeys(Keys.RETURN);

        driver.get("https://formy-project.herokuapp.com/dropdown");
        WebElement dropDownMenu=driver.findElement(By.id("dropdownMenuButton"));
        dropDownMenu.click();

        WebElement autoComplete=driver.findElement(By.id("autocomplete"));
        autoComplete.click();

        driver.get("https://formy-project.herokuapp.com/fileupload");
        WebElement fileUpload=driver.findElement(By.id("file-upload-field"));
        fileUpload.sendKeys("Hydrangeas.jpg");

        driver.get("https://formy-project.herokuapp.com/form");

        submitForm(driver);

        waitForAlertBanner(driver);

        Assertions.assertEquals("The form was successfully submitted!",getAlertBannerText(driver));

        //driver.get("https://github.com/niranjanchowdhary/SupportClasses.git");
        //driver.quit();
    }
    public static void submitForm(WebDriver driver){
        driver.findElement(By.id("first-name")).sendKeys("Prashanthi");
        driver.findElement(By.id("last-name")).sendKeys("Niranjan");
        driver.findElement(By.id("job-title")).sendKeys("Software Engineer");
        driver.findElement(By.id("radio-button-1")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("11/10/1993");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary")).click();
    }
    public static void waitForAlertBanner(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));
    }

    public static String getAlertBannerText(WebDriver driver){
        return driver.findElement(By.className("alert")).getText();
    }

    public void faceBookPageRegistration(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\Web Driver Jars\\geckodriver-v0.25.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");
        WebElement facebook=driver.findElement(By.id("email"));
        Actions actions=new Actions(driver);
        actions.moveToElement(facebook);
        facebook.sendKeys("9703337436");

        WebElement password=driver.findElement(By.id("pass"));
        password.sendKeys("9703337433");

        //WebElement login=driver.findElement(By.id("loginbutton"));
        //login.click();

        WebElement firstname=driver.findElement(By.name("firstname"));
        Actions fname=new Actions(driver);
        fname.moveToElement(firstname);
        firstname.sendKeys("Niranjan");

        WebElement lastname=driver.findElement(By.name("lastname"));
        lastname.sendKeys("chowdary");

        WebElement email=driver.findElement(By.id("u_0_r"));
        Actions e_mail=new Actions(driver);
        e_mail.moveToElement(email);
        email.sendKeys("Niranjan.433@gmail.com");

        WebElement reenter=driver.findElement(By.id("u_0_u"));
        reenter.sendKeys("Niranjan.433@gmail.com");

        WebElement newpass=driver.findElement(By.name("reg_passwd__"));
        newpass.sendKeys("Vijayachandra@3");
    }

    static void titleCheck(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\Web Driver Jars\\geckodriver-v0.25.0-win64\\geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.navigate().to("https://www.google.com");
        String title=driver.getTitle();
        if (title.equals("Google")){
            System.out.println("Pass:title is google");
        }
        else{
            System.out.println("Fail:title is not google");
        }

        String getCurrentUrl=driver.getCurrentUrl();
        if (getCurrentUrl.contains("google.com")){
            System.out.println("Pass");
        }
        else{
            System.out.println("Fail");
        }
    }

    public static void main(String[] args){
        TestRun t=new TestRun();
        t.startBrowser();
    }
}
