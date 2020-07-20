package pageObj;



import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchProduct {
	                  
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	public MobileElement clickonSearch;
	
	@AndroidFindBy(xpath="//android.widget.Button[@content-desc=\"Clear search keywords\"]")
	public MobileElement clearSearchText;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search']")
	public MobileElement enterprodname;
	
	@AndroidFindBy(xpath="//android.widget.ListView/")
	public List<MobileElement> dropdownsearchlist;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView")
	public MobileElement getlistviewtext;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.ViewAnimator/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]")
	public MobileElement dropdownsele;
	
	

}
