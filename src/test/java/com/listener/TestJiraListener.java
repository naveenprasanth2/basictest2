package com.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.util.Jirapolicy;

public class TestJiraListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		Jirapolicy jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Jirapolicy.class);
		boolean isTicketReady = jirapolicy.logTickerReady();
		if(isTicketReady) {
			System.out.println("is ticket ready for JIRA :"+ isTicketReady);
		}
	}

}
