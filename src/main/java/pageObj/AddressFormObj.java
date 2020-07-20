package pageObj;



import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AddressFormObj {

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressFullName\")")
	public MobileElement fullname;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressPhoneNumber\")")
	public MobileElement phonenumb;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressPostalCode\")")
	public MobileElement postalcode;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressLine1\")")
	public MobileElement addresline1;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressLine2\")")
	public MobileElement addresline2;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-landmark\")")
	public MobileElement landmark;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressCity\")")
	public MobileElement delvirycity;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\")")
	public MobileElement populatregions;
	
	@AndroidFindBy(xpath="//android.widget.ListView/android.view.View[@text='KARNATAKA']")
	public MobileElement listofstates;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@text=\"Select an Address Type\"]")
	public MobileElement deliveryprefe;
	
	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"dropdown1_1\")")
	public MobileElement selectdelivpref;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text=\"Add address\"]")
	public MobileElement saveaddress;
	
	@AndroidFindBy(xpath="//android.view.View[@text=\"Address saved\"]")
	public MobileElement addressconfirmed;
	
	
	

}
