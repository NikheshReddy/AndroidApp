package com.antnele.TestCases;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.antnele.utilities.ReadConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();
	public static AppiumDriver<MobileElement> driver;
	public static Logger logger;



	@BeforeClass
	public void setup() throws MalformedURLException {

		logger = Logger.getLogger("AntnEle App");
		PropertyConfigurator.configure("log4j.Properties");


		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Andriod");
		dc.setCapability(MobileCapabilityType.APP,readconfig.getAppPath());
		dc.setCapability(MobileCapabilityType.UDID,"52036015fe09146b");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url,dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		logger.info("App Launched");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	public String randomString() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}

	public static String randomNum() {
		String generatedstring2 = RandomStringUtils.randomAlphanumeric(10);
		return(generatedstring2);
	}
}
