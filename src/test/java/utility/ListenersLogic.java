package utility;

import java.nio.file.Paths;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ListenersLogic implements ITestListener
{
		public static Playwright playwright;
		public static Browser browser;
		public static Page page;
		
		Date d1=new Date();
//		system.out.println(d1.getTime();
		Date d2=new Date(d1.getTime());
		String format=d2.toString();
		String replace=format.replace(":", " ");
		
		@Override
		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestSuccess(result);
			
			//Logic should start from here
			
//			System.out.println("I am Listening - Testcase Pass");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("C:\\Users\\muthupandi\\eclipse-workspace\\AmzProject\\test-output\\screenshot\\pass\\"+result.getName() + replace + ".png")));
		}

	//eg 	@Override
//		  	public void onTestSkipped(ITestResult result) {
//			TODO Auto-generated method stub
//			ITestListener.super.onTestSkipped(result);
//		}

		@Override
		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			ITestListener.super.onTestFailure(result);
			
			System.out.println("I am Listening - Testcase Failed");
			page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("C:\\Users\\muthupandi\\eclipse-workspace\\AmzProject\\test-output\\screenshot\\fail\\"+result.getName() + replace + ".png")));

		}
}

