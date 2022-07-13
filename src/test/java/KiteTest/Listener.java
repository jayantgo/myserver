package KiteTest;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import KitePOM.BasePorp;
import KitePOM.UtilityProp;

public class Listener extends BasePorp implements ITestListener
{

	
	public void onTestFailure(ITestResult result)
	{
	
		try {
			UtilityProp.captureScreenshot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void onTestSuccess(ITestResult result) {
		Reporter.log("TC passed and TC name is "+result.getName(), true);
	}
	
	
}
