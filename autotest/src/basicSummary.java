import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class basicSummary {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();

        String url = "https://www.google.com/";
        driver.get(url);

        String title = driver.getTitle();

        int titleLength = driver.getTitle().length();

        System.out.println("Title of the page is : " + title);
        System.out.println("Length of the title is : "+ titleLength);

        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(url)){
            System.out.println("Verification Successful - The correct Url is opened.");
        } else {
            System.out.println("Verification Failed - An incorrect Url is opened.");
            //In case of Fail, you like to print the actual and expected URL for the record purpose
            System.out.println("Actual URL is : " + actualUrl);
            System.out.println("Expected URL is : " + url);
        }

        String pageSource = driver.getPageSource();
        int pageSourceLength = pageSource.length();
        System.out.println("Total length of the Page Source is : " + pageSourceLength);

//        driver.close();
    }

}
