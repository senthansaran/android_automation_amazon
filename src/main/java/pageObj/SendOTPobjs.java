package pageObj;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SendOTPobjs {
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Send OTP']")
	public MobileElement clicksendOTP;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"continue\")")
	public MobileElement contSendOTP;
	
	
	@AndroidFindBy(className="android.widget.EditText")
	public MobileElement enterOTP;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public MobileElement contOTP;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.TextView")
	public MobileElement getoptmsg;
	
	@AndroidFindBy(className="android.widget.EditText")
	public MobileElement parseOTP;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Continue']")
	public MobileElement confirmOTP;
}
