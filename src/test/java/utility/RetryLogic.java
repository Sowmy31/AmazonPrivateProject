package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer
{
	int initialCount=0;
	int retryCount = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		{
			if(initialCount<retryCount) //0<1 yes, 1<1
			{
				initialCount ++;
				return true; //true means , Let's retry	
			}
		}
		return false;   //if it is false it eans dont retry at all
		//return true - it means keep retrying infinite times
	}
	
}

