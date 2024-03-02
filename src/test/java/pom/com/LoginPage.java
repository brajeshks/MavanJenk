package pom.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement AccountList;
	
	@FindBy(id="nav-flyout-ya-signin")
	private WebElement signBtnElement;
	
	@FindBy(id="ap_email")
	private WebElement emailTextElement;
	
	@FindBy(id="continue")
	private WebElement continebtn;
	
	@FindBy(id="ap_password")
	private WebElement passwordtbxElement;
	
	@FindBy(id="signInSubmit")
	private WebElement signinSubmitElement;
	
	@FindBy(id="nav-item-signout")
	private WebElement signoutElement;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setLogin(String userName,String password)
	{
		AccountList.click();
		emailTextElement.sendKeys(userName);
		continebtn.click();
		passwordtbxElement.sendKeys(password);
		signinSubmitElement.click();
		
		
		
	}
	
}

