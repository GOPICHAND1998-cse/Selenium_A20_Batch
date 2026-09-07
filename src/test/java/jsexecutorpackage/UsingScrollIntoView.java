package jsexecutorpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class UsingScrollIntoView
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor)driver;

            executor.executeScript("document.querySelector(\"img[src='/images/flags/w240/in.webp']\").scrollIntoView({block:'end',behavior:'smooth'})");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
