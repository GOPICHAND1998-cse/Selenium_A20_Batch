package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM
{
    @FindBys({@FindBy(xpath = "//a[@href='services/ParaBank?wsdl']"),@FindBy(xpath = "//a[text()='Withdraw Funds']")})
    private WebElement withDrawFundsLink;

    @FindAll({@FindBy(xpath = "//li[@class='captiontwo']"),@FindBy(xpath = "//li[text()='Online Services']")})
    private WebElement onlineServiceLink;

    public HomePagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getWithDrawFundsLink() {
        return withDrawFundsLink;
    }

    public WebElement getOnlineServiceLink() {
        return onlineServiceLink;
    }
}
