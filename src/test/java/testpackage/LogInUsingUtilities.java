package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilspackage.ActionsUtility;
import utilspackage.BrowserUtility;
import utilspackage.PropertyFileUtility;

public class LogInUsingUtilities
{
    static String browser;
    static String url;
    static String username;
    static String password;
    static PropertyFileUtility property;
    static BrowserUtility browserUtil;
    static ActionsUtility action;

    static WebDriver driver;

    public static void main(String[] args)
    {
     try
     {
        property = new PropertyFileUtility();

        browser = property.getData("browser");
        url = property.getData("url");
        username = property.getData("username");
        password = property.getData("password");

        browserUtil = new BrowserUtility();

        browserUtil.openBrowser(browser);
        browserUtil.maximizeBrowser();
        browserUtil.waitForPageLoad(10);
        browserUtil.openUrl(url);
        browserUtil.waitForElements(10);

        driver = browserUtil.getDriver();

        WebElement userNameField = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));

        action = new ActionsUtility(driver);

        action.writeInInputField(userNameField,username);
        action.writeInInputField(passwordField,password);
        action.clickOnElement(logInButton);


     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }
}
