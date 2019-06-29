import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PortalCrawl {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get("https://portal.aait.edu.et/");

        WebElement userNameField = driver.findElement(By.id("UserName"));
        WebElement passwordField = driver.findElement(By.id("Password"));

        userNameField.sendKeys("ATR/2674/09");
        passwordField.sendKeys("####");

        driver.findElement(By.id("home")).findElement(By.className("btn")).click();
        driver.findElement(By.id("m2")).click();

        driver.navigate().to("https://portal.aait.edu.et/Grade/GradeReport");
        String allMyGradeValues  = driver.findElement(By.className("table")).getText();
        
        export(allMyGradeValues);
    }

    public static void export(String text){
        try (PrintWriter out = new PrintWriter("grade.txt")) {
            out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
