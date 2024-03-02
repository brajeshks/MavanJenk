package testScripts.com;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generics.com.BaseClass;

public class VerifyingTitleTest extends BaseClass{
@Test
public void testhomePageTitle()
{
	String expectedTitleString=driver.getTitle();
	String actualTitleString=driver.getTitle();
	SoftAssert s=new SoftAssert();
	s.assertEquals(actualTitleString, expectedTitleString);
	s.assertAll();
}
}
