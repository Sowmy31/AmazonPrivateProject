package pomamazon.AmzProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import utility.BaseTest;
import utility.ListenersLogic;
import utility.RetryLogic;

@Listeners(ListenersLogic.class)

public class TestCase2_LoginToAmazonandLogout extends BaseTest 
{
	@Test(retryAnalyzer=RetryLogic.class)
	public void withValidCredentialsandLogout() throws InterruptedException
		{
			HomePage homepage=new HomePage(page);
			homepage.hoverOverOnAccountAndList();
			homepage.clickOnSignin();
//			page.wait(6000);
			
			LoginPage loginpage=new LoginPage(page);
			
			loginpage.enterusername("sowmyashop01@gmail.com");
			loginpage.clickOnContinue();
			loginpage.enterpassword("Test@123");
			loginpage.clickOnSigninbutton();
			assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"); //1st assert confirmation
			
			Locator searchbox=page.getByLabel("Search Amazon.in");
			assertThat(searchbox).isVisible(); //2nd assert confirmation
			

			homepage.hoverOverOnAccountAndList();
			homepage.clickOnSignout();
			
			Locator signouttext=page.locator("//div[@id='claim-collection-container']/h1");
			assertThat(signouttext).hasText("Sign in or create account");
	
		}
}
