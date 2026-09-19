package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pompackage.HomePagePOM;
import pompackage.LogInPOM;
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

    static LogInPOM login;
    static HomePagePOM home;

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

        action = new ActionsUtility(driver);

        login = new LogInPOM(driver);
        home = new HomePagePOM(driver);

        action.writeInInputField(login.getUserNameField(),username);
        action.writeInInputField(login.getPasswordField(),password);
        action.clickOnElement(login.getLogInButton());

        driver.navigate().back();

        action.clickOnElement(home.getOnlineServiceLink());




     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }
}
