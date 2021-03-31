import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginUtils {

    public static void performLoginAndPostStatus(String email, String password,String statusMessage) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","/usr/local/bin/geckodriver");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(AutomationConstants.baseURL);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        Thread.sleep(5000);
        String username=driver.findElement(By.xpath(AutomationConstants.usernameXpath)).getText();
        driver.findElement(By.xpath("//span[normalize-space()=\"What's on your mind, "+username+"?\"]")).click();
        Thread.sleep(3000);
        WebElement element=driver.switchTo().activeElement();
        element.sendKeys(AutomationConstants.statusMessage);
        driver.findElement(By.xpath(AutomationConstants.postButtonXpath)).click();

    }

}
