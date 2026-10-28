package pomamazon.AmzProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import utility.BaseTest;
import utility.RetryLogic;

public class TestCase1_LoginToAmazon extends BaseTest 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void withValidCredentials() throws InterruptedException
	{
		HomePage homepage=new HomePage(page);
		homepage.hoverOverOnAccountAndList();
		homepage.clickOnSignin();
//		page.wait(6000);
		
		LoginPage loginpage=new LoginPage(page);
		
		loginpage.enterusername("sowmyashop01@gmail.com");
		loginpage.clickOnContinue();
																																																				loginpage.enterpassword("Zoho@123");
		loginpage.clickOnSigninbutton();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"); //1st assert confirmation
		
		Locator searchbox=page.getByLabel("Search Amazon.in");
		assertThat(searchbox).isVisible(); //2nd assert confirmation
			
	}
}
