import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class GmailCrawl {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.gmail.com");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("antenehadmasu8@gmail.com");
        driver.findElement(By.id("identifierNext")).click();

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(passwordField));
        passwordField.sendKeys("#########");
        driver.findElement(By.id("passwordNext")).click();

        // Thread sleep for captcha
        Thread.sleep(25000L);

        List<WebElement> unreadEmailMessages =  driver.findElement(By.className("Cp")).findElement(By.tagName("table")).findElements(By.className("zE"));
        System.out.println();
        System.out.println("Number of Unread Emails => " + unreadEmailMessages.size());
        System.out.println();

        for (int i = 0; i < unreadEmailMessages.size(); i++){
            System.out.println((i + 1) + " :Sub " + unreadEmailMessages.get(i).findElement(By.className("y6")).getText());
        }
    }
}
