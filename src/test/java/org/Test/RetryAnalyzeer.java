package org.Test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzeer implements IRetryAnalyzer {
	int min=0,max=4;
	public boolean retry(ITestResult arg0) {
			if(min<max) {
				min++;
				return true;
			}
		return false;
	}

}
