package KitePOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage
{
	@FindBy (xpath = "//span[@class='user-id']") private WebElement userID;
	
	@FindBy(xpath = "//a[@target='_self']") private WebElement logOutButton;
	
	public KiteHomePage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	
//	public void validateUserID(String ExpUserID)
//	{
//		String actualUserID = userID.getText();
//		String expectedUserID=ExpUserID;
//		
//		if (actualUserID.equals(expectedUserID))
//		{
//		
//			System.out.println("User ID are matching TC is PASSED");
//		}
//		
//		else {
//			System.out.println("UserID not Matching TC failed");
//		}		
//	}
	
	public String getActualUserID()
	{
		String actualUID = userID.getText();
		return actualUID;
	}
	
	
	public void clickOnlogOut() throws InterruptedException
	{
		userID.click();
		Thread.sleep(100);
		logOutButton.click();
		
	}
	
	

	
}
