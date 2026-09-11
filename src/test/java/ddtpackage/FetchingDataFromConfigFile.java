package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class FetchingDataFromConfigFile
{
    static WebDriver driver;

    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/CommonData/Config.properties");

            Properties property = new Properties();

            property.load(fis);

            String browser = property.getProperty("browser");
            String password=property.getProperty("password");
            String username=property.getProperty("username");
            String url=property.getProperty("url");

            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new InvalidArgumentException("The Browser Name is Invalid");
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get(url);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.findElement(By.xpath("//input[@name='username']"))
                    .sendKeys(username);

            driver.findElement(By.xpath("//input[@name='password']"))
                    .sendKeys(password);

            driver.findElement(By.xpath("//input[@value='Log In']"))
                    .click();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
