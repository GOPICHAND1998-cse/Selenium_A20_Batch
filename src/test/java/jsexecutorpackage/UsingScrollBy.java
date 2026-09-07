package jsexecutorpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class UsingScrollBy
{
    public static void main(String[] args)
    {
      try
      {
          WebDriver driver = new FirefoxDriver();

          driver.manage().window().maximize();

          driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

          driver.get("https://www.worldometers.info/geography/flags-of-the-world/");

          JavascriptExecutor executor = (JavascriptExecutor) driver;

          executor.executeScript("window.scrollBy({top:2000,left:0,behavior:'smooth'})");
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
