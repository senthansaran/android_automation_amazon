package pageObj;



import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddDeliveryAddress {
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"Navigation panel, button, double tap to open side panel\"]")
	public MobileElement leftopmenu;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Your Account')]")
	public MobileElement youraccount;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Your Addresses')]")
	public MobileElement youraddress;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Add a new address')]")
	public MobileElement addnewaddress;


}
