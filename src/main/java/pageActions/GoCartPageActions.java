package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.GoCartObjs;
import utils.ReusableMethod;
import org.testng.Assert;




public class GoCartPageActions extends ReusableMethod {
	public String tvPricebeforeCart;
	public String tvPricecartnodecimal;
	public String tvPriceAftSymbol;
	public String tvPriceAftNormSpace;
	
	

	public GoCartObjs gotocartpageobj = new GoCartObjs();
	Logger apachelogger = Logger.getLogger(GoCartPageActions.class);
	
	public AppiumDriver<MobileElement> appium;
	
	public GoCartPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium),gotocartpageobj);
	}
	public void getTvPriceBeforeCart(){
		waitForEleToClick(gotocartpageobj.getTVPricebeforeCart);
		Assert.assertTrue(gotocartpageobj.getTVPricebeforeCart.isDisplayed());	
			tvPricebeforeCart = gotocartpageobj.getTVPricebeforeCart.getText();
			apachelogger.info("TV Price Before Cart"+tvPricebeforeCart);
			tvPriceAftSymbol = tvPricebeforeCart.substring(2);
			tvPriceAftNormSpace=tvPriceAftSymbol.trim().replaceAll(".00","");

			Assert.assertEquals(tvPriceAftNormSpace, GetTvPageActions.TvPriceIs);
			apachelogger.info("****TV Price Assert True --> Btwn Tv Details Page & Go To Cart Page****");
		
	}	
	public void  gotocartviewTv(){
		waitForElement(gotocartpageobj.gotoCart);
		org.testng.Assert.assertTrue(gotocartpageobj.gotoCart.isDisplayed());
		gotocartpageobj.gotoCart.click();
		apachelogger.info("****Go To Cart Button Clicked Successfully****");
	
	}
	

}
