package generics.com;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.com.LogOutPage;
import pom.com.LoginPage;

public class BaseClass {
	public static WebDriver driver;

	@BeforeTest
	public void openBrowser() {
		Reporter.log("openBrowser", true);
		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser", true);
		driver.close();
	}

	@BeforeMethod
	public void login() throws IOException, Throwable {
		Reporter.log("login", true);
		FileLibClass f = new FileLibClass();
		String add = f.getPropertyValue("url","C:\\Users\\Me\\eclipse-workspace\\DheerajBaba.com\\src\\test\\resources\\data\\dheerajBaba.property");
		String unm = f.getPropertyValue("un","C:\\Users\\Me\\eclipse-workspace\\DheerajBaba.com\\src\\test\\resources\\data\\dheerajBaba.property");
		Thread.sleep(3000);
		String pd = f.getPropertyValue("pwd","C:\\Users\\Me\\eclipse-workspace\\DheerajBaba.com\\src\\test\\resources\\data\\dheerajBaba.property");
		System.out.println(pd);
		driver.get(add);
		LoginPage l = new LoginPage(driver);
		l.setLogin(unm, pd);

	}

	@AfterMethod
	public void logout() {
		Reporter.log("Logout", true);
		LogOutPage lg = new LogOutPage(driver);
		lg.setSignout(driver);

	}

}
