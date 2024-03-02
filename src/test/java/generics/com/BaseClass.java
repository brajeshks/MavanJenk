package generics.com;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pom.com.LogOutPage;
import pom.com.LoginPage;

public class BaseClass {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Reporter.log("openBrowser", true);

	}

	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser", true);
		driver.close();
	}

	@BeforeMethod
	public void login() throws IOException, Throwable {
		FileLibClass f = new FileLibClass();
		String add = f.getPropertyValue("url",".\\src\\test\\resources\\data\\dheerajBaba.properties");
		String unm = f.getPropertyValue("un",".\\src\\test\\resources\\data\\dheerajBaba.properties");
		Thread.sleep(3000);
		String pd = f.getPropertyValue("pwd",".\\src\\test\\resources\\data\\dheerajBaba.properties");
		System.out.println(pd);
		driver.get(add);
		LoginPage l = new LoginPage(driver);
		l.setLogin(unm,pd);
		Reporter.log("login", true);


	}

	@AfterMethod
	public void logout() {
		Reporter.log("Logout", true);
	//	LogOutPage lg = new LogOutPage(driver);
		//lg.setSignout(driver);

	}

}
