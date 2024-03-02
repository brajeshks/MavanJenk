package pom.com;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogOutPage {
@FindBy(xpath = "//span[text()='Account & Lists']")
private WebElement AccountList;

@FindBy(xpath = "//span[text()='Sign Out']")
private WebElement signoutElement;

public LogOutPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
public void setSignout(WebDriver driver)
{
	Actions s = new Actions(driver);
	s.moveToElement(AccountList);
	signoutElement.click();
}
}
