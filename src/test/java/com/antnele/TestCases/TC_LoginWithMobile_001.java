package com.antnele.TestCases;

import org.testng.annotations.Test;

import com.antnele.PageObjects.LoginWithMobilePage;

public class TC_LoginWithMobile_001 extends BaseClass {
	
	
	@Test
	public void loginWithMobileTest() throws InterruptedException {
		
		LoginWithMobilePage lpm = new LoginWithMobilePage(driver);
		lpm.clickSkipBtn();
		logger.info("Clicked Skip Button");
		lpm.clickWithMobile();
		logger.info("clicked withMobile button");
		lpm.setMobileNumber(readconfig.getMobileNumber());
		logger.info("Provide MobileNumber");
		lpm.clickDoneButton();
		logger.info("Clicked Done");
		lpm.clickRightButton();
		logger.info("Clicked Next Button");
		lpm.clickSubmit();
		logger.info("Clicked Submit");
		
		Thread.sleep(3000);
	String res =	driver.getCurrentUrl();
	System.out.println(res);
		logger.info("loginWithMobileTest Case Passed");
		
		
	}

}
