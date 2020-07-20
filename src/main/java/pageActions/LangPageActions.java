package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.LangObjs;
import utils.ReusableMethod;

public class LangPageActions extends ReusableMethod{

	Logger appachelog = Logger.getLogger(LangPageActions.class);
	public LangObjs languageobj = new LangObjs();
	public AppiumDriver<MobileElement> appium;

	public LangPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), languageobj);
	}

	public void userprefaredlang() throws InterruptedException{
		Thread.sleep(5000);
		Assert.assertTrue(languageobj.selectlang.isEnabled());
		appachelog.info("Select Language Radio Button is Enabled");
		languageobj.selectlang.click();

	}
	public void saveuserlang() throws InterruptedException{
		waitForElement(languageobj.selectlang);
		Assert.assertTrue(languageobj.savelang.isEnabled());
		appachelog.info("Language Save Button is Enabled to Click");
		languageobj.savelang.click();
		Thread.sleep(5000);
	}
	public void clickhome(){
		waitForEleToClick(languageobj.clickhome);
		languageobj.clickhome.click();
	}



}
