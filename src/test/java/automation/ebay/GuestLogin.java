
package automation.ebay;


import org.testng.annotations.Test;


import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pageActions.AddressFormPageActions;
import pageActions.DeliveryAddressPageActions;
import pageActions.DeliveryLocationPageActions;
import pageActions.GetTvPageActions;
import pageActions.GoCartPageActions;
import pageActions.LangPageActions;
import pageActions.LoginPageActions;
import pageActions.ProceedPayPageActions;
import pageActions.SearchPageActions;
import pageActions.SendOTPPageActions;
import utils.ScreenShot;


@Listeners({ScreenShot.class})

public class GuestLogin extends Des_Caps{

	LoginPageActions loginpageobjactions;
	LangPageActions langpageobjactions;
	SendOTPPageActions sendotpobjactions;
	SearchPageActions searchpageobjactions;
	DeliveryLocationPageActions deliverylocationpageobjactions;
	GetTvPageActions gettvpageobjactions;
	GoCartPageActions gotocartpageobjactions;
	ProceedPayPageActions proceedpaypageobjactions;
	DeliveryAddressPageActions adddeliveryaddresspageactions;
	AddressFormPageActions addressformpageactions;


	public static String excelpath="/Users/terralogic/Documents/workspace/ebay/src/main/java/testdata/deliv_address.xlsx"; 
	public static  String sheetName="DeliveryBook"; 


	@Severity(SeverityLevel.CRITICAL)
	@Parameters({"userid"})
	@Test(priority = 0)
	public void guestuserlogin(@Optional String userid) {
		loginpageobjactions = new LoginPageActions(appium);
		loginpageobjactions.guestlogin();

	}

	
	@Severity(SeverityLevel.NORMAL)
	@Test(priority=1)
	public void navigatehome(){
		langpageobjactions = new LangPageActions(appium);
		langpageobjactions.clickhome();
		
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority=2)
	public void navtoAddresform() throws InterruptedException {
		adddeliveryaddresspageactions = new DeliveryAddressPageActions(appium);
		Thread.sleep(2000);
		adddeliveryaddresspageactions.selectMenu();
		adddeliveryaddresspageactions.clickyouraccount();

		//adddeliveryaddresspageactions.clickyouraddress();
		//adddeliveryaddresspageactions.clickaddnewaddress();

	}
	/*
	@Severity(SeverityLevel.BLOCKER)
	@Parameters({"productName"})
	@Test(priority=3)
	public void searchTV(@Optional String productName) throws InterruptedException{
		searchpageobjactions = new SearchPageActions(appium);
		searchpageobjactions.clicksearch();
		searchpageobjactions.clearSearchText();
		searchpageobjactions.enterProdKey(productName);
		searchpageobjactions.selectdropdown();
	}


	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=4)
	public void scrollTVlistSelect() throws InterruptedException {
		gettvpageobjactions = new GetTvPageActions(appium);
		gettvpageobjactions.swipetwopage();
		gettvpageobjactions.dynamicpressByCoordinates();
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority=5)
	public void tvDetails() throws InterruptedException{
		gettvpageobjactions = new GetTvPageActions(appium);
		gettvpageobjactions.tvbrandName();
		gettvpageobjactions.tvdescr();
		//gettvpageobjactions.dynamicscroll();
		//gettvpageobjactions.tvprice();
		gettvpageobjactions.addcart();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=5)
	public void gotocartview(){
		gotocartpageobjactions = new GoCartPageActions(appium);
		//gotocartpageobjactions.getTvPriceBeforeCart();
		gotocartpageobjactions.gotocartviewTv();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=6)
	public void proceedpay(){
		proceedpaypageobjactions = new ProceedPayPageActions(appium);
		proceedpaypageobjactions.getTvDesatPay();
		proceedpaypageobjactions.proceedtoPay();
	}*/
}
