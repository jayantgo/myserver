package KiteTest;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import KitePOM.BasePorp;
import KitePOM.KiteHomePage;
import KitePOM.KiteLoginPage;
import KitePOM.KitePinPage;
import KitePOM.UtilityProp;

@Listeners(KiteTest.Listener.class)
public class ValidateKiteUserNameProp extends BasePorp {
	KitePinPage pin;
	KiteHomePage home;
	KiteLoginPage login;
	//String TCID="9911";
	@BeforeClass
	public void launchBrowser() throws IOException
	{
		openBrowser();
		pin= new KitePinPage(driver);
	    home= new KiteHomePage(driver);
	    login= new KiteLoginPage(driver);
		
	}
	
	@BeforeMethod
	public void loginToKiteApp() throws IOException
	{
		login.sendUserName(UtilityProp.readDataFromPropertyFile("UN"));
		login.sendPassWord(UtilityProp.readDataFromPropertyFile("PWD"));
		login.clickOnLoginButton();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
		
		pin.sendPin(UtilityProp.readDataFromPropertyFile("PIN"));
		pin.clickOnContinueButton();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

	}
	
	@Test
		public void validateUserID100() throws IOException
	{
		Assert.assertEquals(home.getActualUserID(),UtilityProp.readDataFromPropertyFile("UN"),"Actual and Expacted User ID not matching TC failed");
		Reporter.log("Actual and Expacted User ID matching TC Passed",true);
		
	}
	
	@AfterMethod
	public void logOutFromKiteApp() throws InterruptedException
	{
		home.clickOnlogOut();
	}
	
	@AfterClass
	public void closeBrowser()
	{
	driver.close();	
	}
}
