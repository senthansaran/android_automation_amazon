package pageObj;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoCartObjs {
	
	@AndroidFindBy(xpath="//android.view.View[3]/android.view.View/android.view.View/android.widget.TextView[contains(@text,'₹') and contains(@text,'.00')]")
	public MobileElement getTVPricebeforeCart;
	
	
	
	//@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"a-autoid-1-announce\")")
	/*@AndroidFindBy(xpath="//android.widget.Button[@text='Cart']")
	public MobileElement gotoCart;*/
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/action_bar_cart_count\")")
	public MobileElement gotoCart;

}
