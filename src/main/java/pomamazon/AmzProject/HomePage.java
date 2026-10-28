package pomamazon.AmzProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class HomePage 
{
	Page page;
	Locator accountAndList;
	Locator signin;
	Locator signout;

	public HomePage(Page page)
	{
		this.page=page;
		accountAndList=page.locator("//span[@class='nav-line-2 ']");
		signin=page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Sign in").setExact(true));
		signout=page.locator("#nav-item-signout");
	}
	public void hoverOverOnAccountAndList() throws InterruptedException
	{
		page.waitForTimeout(3000);
		accountAndList.hover();
	}
	public void clickOnSignin()
	{
		signin.click();
	}
	public void clickOnSignout()
	{
		signout.click();
	}
}

