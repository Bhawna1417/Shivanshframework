package com.webdriver.Runner;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import com.webdriver.Reporting.AkeoSanityListener;
import com.webdriver.Reporting.AkeoSanityReporter;
import com.webdriver.TestCases.TC01;
import com.webdriver.TestCases.TC02;
import com.webdriver.TestCases.TC03;
import com.webdriver.TestCases.TC04;
import com.webdriver.TestCases.TC05;
import com.webdriver.TestCases.TC06;
import com.webdriver.TestCases.TC07;
import com.webdriver.TestCases.TC08;
import com.webdriver.TestCases.TC09;

public class TestSuiteRunner {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {

		AkeoSanityListener listener = new AkeoSanityListener();

		AkeoSanityReporter reporter = new AkeoSanityReporter();

		TestNG testng = new TestNG();

		// Class[] classList = new Class[] { TC01.class };

		Class[] classList = new Class[] { TC01.class, TC02.class, TC03.class,
				TC04.class, TC05.class, TC06.class, TC07.class, TC08.class,
				TC09.class };

		testng.setDefaultSuiteName("suite");
		testng.setTestClasses(classList);

		testng.addListener((ITestNGListener) listener);

		testng.addListener((ITestNGListener) reporter);
		// testng.setThreadCount(1);
		testng.setGroupByInstances(true);

		testng.run();

	}

}