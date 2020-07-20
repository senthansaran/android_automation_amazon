package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.GetTvObj;
import utils.ReusableMethod;

public class GetTvPageActions extends ReusableMethod{

	Logger apachelog = Logger.getLogger(GetTvPageActions.class);
	
	public String tvBrand;
	static String tvDesc;
	static String tvPrice;
	static String TvPriceIs;
	static String tvDescfromList;


	public GetTvObj gettvpageobj = new GetTvObj();
	public AppiumDriver<MobileElement>appium;


	public GetTvPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), gettvpageobj);
	}


	public void tvbrandName(){
		waitForEleToClick(gettvpageobj.getTVBrand);
		tvBrand=gettvpageobj.getTVBrand.getText();
		apachelog.info("****Get the TV Brand Name Tex is"+" "+tvBrand+"****");
	}
	public void tvdescr(){
		tvDesc=gettvpageobj.getTvDescription.getText();
		apachelog.info("****Get the About Tv Tex is"+" "+tvDesc+"****");

	}

	public void tvprice() throws InterruptedException{
		swipeUpUntilTextExists("rupees");
		apachelog.info("****Scrolled to TV Price Successfully****");
		tvPrice=gettvpageobj.getTvPrice.getText();
		apachelog.info("****Get the Tv Price Tex is"+" "+tvPrice+"****");

		int endofstr = tvPrice.length();
		TvPriceIs = tvPrice.substring(7,endofstr);
		apachelog.info("****After SubString of TV Price Tex is"+" "+TvPriceIs);
	}
	
	public void addcart() throws InterruptedException{
		swipeUpUntilTextExists("Deliver to");
		//swipeUpUntilTextExists("Qty");
		//swipeUpUntilTextExists("Secure transaction");
		String addcardbtntext=gettvpageobj.addToCartTV.getText();
		apachelog.info("****Scrolled to +addcardbtntext+ Successfully****");
		gettvpageobj.addToCartTV.click();
		apachelog.info("****Clicked on Add to Cart button Succesfully****");
	}
	
	




}
