package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.SearchProduct;
import utils.ReusableMethod;

public class SearchPageActions extends ReusableMethod{

	String expectedSearchStr;
	String searchresultStr;

	Logger apachlog = Logger.getLogger(SearchPageActions.class);


	public SearchProduct searchobjs = new SearchProduct();
	public AndroidDriver<MobileElement> appium;

	public SearchPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), searchobjs);
	}

	public void clicksearch(){
		waitForEleToClick(searchobjs.clickonSearch);
		Assert.assertTrue(searchobjs.clickonSearch.isDisplayed());
		searchobjs.clickonSearch.click();
		apachlog.info("Assert True -> Search TextBox is Enable to Entered the KeyWord Successfully");
	}
	
	public void clearSearchText(){
		searchobjs.clearSearchText.click();
	}
	
	public void enterProdKey(String productName) {
		waitForEleToClick(searchobjs.enterprodname);
		Assert.assertTrue(searchobjs.enterprodname.isEnabled());
		expectedSearchStr = productName;
		searchobjs.enterprodname.sendKeys(productName);
		apachlog.info("Assert True -> Search Text Allowed to Enter the Prod Name Successfully");
		//Thread.sleep(2000);
	}
	public void selectdropdown(){
		Assert.assertTrue(searchobjs.dropdownsele.isDisplayed());
		apachlog.info("Assert True -> DropDown is Display the list of Product");
		searchresultStr = searchobjs.getlistviewtext.getText();
		apachlog.info("****The Search Result Response is"+searchresultStr+"****");
		Assert.assertTrue(searchresultStr.contains("65 inch tv"),expectedSearchStr);
		apachlog.info("Response from List----->"+searchresultStr+" "+expectedSearchStr+"****");
		apachlog.info("****Assert True -> Search Result Contains the String of search Product****");
		searchobjs.dropdownsele.click();
		apachlog.info("****Assert True -> Search Result Selected the result Successfully****");
	}
}
