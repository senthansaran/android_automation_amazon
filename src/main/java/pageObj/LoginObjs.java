package pageObj;



import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;



//import com.device.farm.DesCapabs;

public class LoginObjs {
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	public WebElement guestsignin;
	
	
	@AndroidFindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")
	public MobileElement existing_signin;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"ap_email_login\")")
	public MobileElement enter_userid;
	
	@AndroidFindBy(xpath="//android.widget.Button[contains(@text,\"Get an OTP on your phone\")]")
	public MobileElement getOTPpass;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public MobileElement clickuseridcont;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"ap_password\")")
	public MobileElement enterpass;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"signInSubmit\")")
	public MobileElement clickpasscont;
	

}
