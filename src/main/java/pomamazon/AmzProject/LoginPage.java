package pomamazon.AmzProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage
{
		private Page page;
		private Locator username;
		private Locator continuebutton;
		private Locator password;
		private Locator submitbutton;

		public LoginPage(Page page)
		{
			this.page=page;
			username=page.locator("#ap_email_login");
			continuebutton=page.locator(".a-button-input");
			password=page.locator("#ap_password");
			submitbutton=page.locator("#signInSubmit");
			
		}
		public void enterusername(String UN)
		{
			username.fill(UN);
		}
		public void clickOnContinue()
		{
			continuebutton.click();
		}
		public void enterpassword(String pwd)
		{
			password.fill(pwd);
		}
		public void clickOnSigninbutton()
		{
			submitbutton.click();
		}
	

}
