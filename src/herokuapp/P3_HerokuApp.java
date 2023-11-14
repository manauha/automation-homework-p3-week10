package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-3 - ProjectName : com-herokuapp
 * BaseUrl = http://the-internet.herokuapp.com/login
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Enter the email to email field.
 * 7. Enter the password to password field.
 * 8. Click on Login Button.
 * 9. Print the current url.
 * 10. Refresh the page.
 * 11. Close the browser.
 */

public class P3_HerokuApp {

    // 1. Setup chrome browser.
    static String browser = "Chrome";
    static String baseUrl = "http://the-internet.herokuapp.com/login";
    static WebDriver driver;

    //main method
    public static void main(String[] args) {

        //multi browser set up
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Invalid Browser name");
        }

        //2. Open URL.
        driver.get(baseUrl);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 3. Print the title of the page.
        String title = driver.getTitle();
        System.out.println("Page title : " + driver.getTitle());

        // 4. Print the current url.
        String CurrentUrl = driver.getCurrentUrl();
        System.out.println("The current url : " + CurrentUrl);

        // 5. Print the page source.
        String pageSource = driver.getPageSource();
        System.out.println("Page Source : \n" + pageSource);

        //  6. Enter the email to email field.
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith");

        //  7. Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //  8. Click on Login Button.
        WebElement loginLink = driver.findElement(By.className("radius"));
        loginLink.click();

        //  9. Print the current url.
        System.out.println("Get the current URL : " + driver.getCurrentUrl());

        //  10. Refresh the page.
        driver.navigate().refresh();


        //11. Close the browser.
        driver.quit();
    }
}
