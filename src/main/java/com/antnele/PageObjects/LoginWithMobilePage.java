package com.antnele.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginWithMobilePage {
	
	AppiumDriver<MobileElement> ldriver;
	
	public LoginWithMobilePage(AppiumDriver<MobileElement> rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.antnele:id/btn_skip']")
	WebElement btnSkip;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.antnele:id/btnWithMobile']")
	WebElement btnWithMobile;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.antnele:id/edtPhoneNumber']")
	WebElement txtPhoneNumber;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.antnele:id/btnDone']")
	WebElement btnDone;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.antnele:id/btnRight']")
	WebElement btnRight;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.antnele:id/btnLeft']")
	WebElement btnLeft;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.antnele:id/btn']")
	WebElement btnSubmit;
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@resource-id='com.antnele:id/navigation_account']")
	WebElement lnkAccount;
	
	public void clickSkipBtn() {
		btnSkip.click();
	}
	
	public void clickWithMobile() {
		btnWithMobile.click();
	}
	
	public void setMobileNumber(String mobilenum) {
		txtPhoneNumber.sendKeys(mobilenum);
	}
	
	public void clickDoneButton() {
		btnDone.click();
	}
	
	public void clickRightButton() {
		btnRight.click();
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
}
