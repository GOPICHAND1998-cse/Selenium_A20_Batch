package jsexecutorpackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandlingHiddenElement
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            Object jsObj = executor.executeScript("return document.querySelector('div#finish')");

            WebElement hiddenElement = (WebElement) jsObj;

            executor.executeScript("arguments[0].removeAttribute('style')",hiddenElement);

            System.out.println(hiddenElement.getText());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
