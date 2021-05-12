package automation.ebay;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * Created by ArunSG.
 */


public class Des_Caps {

	Logger apachelog = Logger.getLogger(Des_Caps.class);

	public static AndroidDriver<MobileElement> appium;

	@SuppressWarnings("unused")
	@BeforeClass
	public void beforestart() throws IOException{

		FileInputStream descapinput = new FileInputStream("/Users/terralogic/Documents/workspace/ebay/src/main/resources/properties/config.properties");
		Properties propobj = new Properties();
		if(descapinput!=null){
			propobj.load(descapinput);	
			apachelog.info("****Config.properties File loaded Successfully****"); 
		}
		else {
			throw new FileNotFoundException("property file '" + descapinput + "' not found in the classpath");
		}

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, propobj.getProperty("platformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, propobj.getProperty("platformVersion"));
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,propobj.getProperty("deviceName"));
		capabilities.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir") +propobj.getProperty("app"));
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,propobj.getProperty("automationName"));
		capabilities.setCapability(MobileCapabilityType.UDID,propobj.getProperty("udid"));
		capabilities.setCapability("appActivity",propobj.getProperty("appactivity"));
		capabilities.setCapability("appPackage",propobj.getProperty("apppackage"));
		capabilities.setCapability("autoGrantPermissions",propobj.getProperty("permission"));
		appium = new AndroidDriver<MobileElement>(new URL(propobj.getProperty("appiumurl")), capabilities);
		//appium.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		apachelog.info("****DesiredCapabilities Loaded Succesfully****");

	}
	@AfterClass public void tearDown() {
		appium.quit();
		apachelog.info("****Appium Driver Quit Successfully****");
	}

}

