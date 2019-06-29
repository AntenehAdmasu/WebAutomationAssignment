import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class AutoTest {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        System.setProperty("webdriver.gecko.driver", "~/Downloads/geckodriver-v0.24.0-linux64/geckodriver");
        WebDriver driver;
        driver = new ChromeDriver();

        //Launch the some site
        driver.get("http://localhost");

        // Print a Log In message to the screen
        System.out.println("Successfully opened the website localhost");

        String CurrentUrl = driver.getCurrentUrl();
        String PageSource = driver.getPageSource();

        System.out.println("URL: "+CurrentUrl);
        System.out.println("Source Code: "+PageSource);

        //Wait for 5 Sec
        Thread.sleep(5);

        // Close the driver
        driver.quit();
    }
}
