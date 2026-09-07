package jsexecutorpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingDisableElement
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://www.qa-practice.com/elements/button/disabled");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement disabledButton = driver.findElement(By.cssSelector("input#submit-id-submit"));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            executor.executeScript("arguments[0].removeAttribute('disabled')",disabledButton);

            disabledButton.click();


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
