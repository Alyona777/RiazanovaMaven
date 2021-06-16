import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SetPropertyChrome {

    @Test
    public void startChromeWithSetProperties() {

        String pathToRootOfProject = System.getProperty("user.dir");

        String pathToChromeDriver = pathToRootOfProject + "/chromedriver.exe";


        System.setProperty("webdriver.chrome.driver", pathToChromeDriver);

        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://accounts.google.com/signin");

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement email_phone = webDriver.findElement(By.xpath("//input[@id='identifierId']"));
        email_phone.sendKeys("+380733110723");
        webDriver.findElement(By.id("identifierNext")).click();
        WebElement password = webDriver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(webDriver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(password));
        password.sendKeys("Alona.Ria123");
        webDriver.findElement(By.id("passwordNext")).click();


        webDriver.manage().deleteAllCookies();
        webDriver.quit();
    }

    
}

