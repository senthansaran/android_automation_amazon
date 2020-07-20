package pageObj;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProceedPayObjs {
	@AndroidFindBy(xpath="//android.widget.Button[@text='Proceed to Buy']")
	public MobileElement proceedPay;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text, \"cm\")]")
	public MobileElement getTvDescatpay;

}
