package utilspackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtility
{
    Actions action;

    public ActionsUtility(WebDriver driver)
    {
        action = new Actions(driver);
    }

    public void clickOnElement(WebElement element)
    {
        action.click(element).perform();
    }

    public void writeInInputField(WebElement element,String data)
    {
        action.sendKeys(element,data).perform();
    }

    public void moveMouseToElement(WebElement element)
    {
        action.moveToElement(element).perform();
    }


}
