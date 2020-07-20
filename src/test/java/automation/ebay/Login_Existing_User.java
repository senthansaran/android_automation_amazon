package automation.ebay;


import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.DataProvider;
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
import utils.ReadXls;
import utils.ScreenShot;


@Listeners({ScreenShot.class})

public class Login_Existing_User extends Des_Caps{

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
	public void existingusersignin(@Optional String userid) {
		loginpageobjactions = new LoginPageActions(appium);
		loginpageobjactions.clickalreadysign_in();
		loginpageobjactions.enteruserid(userid);
		loginpageobjactions.clickusercont();
		loginpageobjactions.getOTPpassword();

	}

	@Severity(SeverityLevel.BLOCKER)
	//Switch to Message App from Amazon app
	@Parameters({"msgpkg","msgactivty"})
	@Test(priority = 1)
	public void switchmsgapp(@Optional String msgpkg,String msgactivty){
		Activity activity = new Activity(msgpkg, msgactivty);
		activity.setStopApp(false);
		((AndroidDriver<MobileElement>) appium).startActivity(activity);
		appium.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//appium=setupDriver(appPackage2, appActivity2);
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(priority = 2)
	public void viewmsg() throws InterruptedException{
		sendotpobjactions = new SendOTPPageActions(appium);
		sendotpobjactions.getotp();
		//Switch Back to Amazon App
		sendotpobjactions.backtoAmazon();
		sendotpobjactions.parseOTP();
		sendotpobjactions.otpConfirm();
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority=3)
	public void userlangpref() throws InterruptedException{
		langpageobjactions = new LangPageActions(appium);
		langpageobjactions.userprefaredlang();
		langpageobjactions.saveuserlang();
		langpageobjactions.clickhome();
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority=4)
	public void navtoAddresform() {
		adddeliveryaddresspageactions = new DeliveryAddressPageActions(appium);
		adddeliveryaddresspageactions.selectMenu();
		adddeliveryaddresspageactions.clickyouraccount();


	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority=5)
	public void selectnewAddresform() {
		adddeliveryaddresspageactions = new DeliveryAddressPageActions(appium);
		adddeliveryaddresspageactions.clickyouraddress();
		adddeliveryaddresspageactions.clickaddnewaddress();

	}

	@DataProvider
	public Object[][] getdeliveryaddress() throws InvalidFormatException{
		Object[][] celldata = ReadXls.getExcelData(excelpath,sheetName);
		return celldata;
	}


	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=6, dataProvider="getdeliveryaddress")
	public void filldeliveryaddress(String firstname,String phone,String postalcode,String addressline1,String addressline2,String landmark) throws InterruptedException{
		addressformpageactions = new AddressFormPageActions(appium);
		addressformpageactions.filladdressform(firstname,phone,postalcode,addressline1,addressline2,landmark);
		addressformpageactions.keyboarddismiss();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Parameters({"expectedautopopulatecityname"})
	@Test(priority=7)
	public void verifydropdown(@Optional String expectedautopopulatecityname) throws InterruptedException{
		addressformpageactions = new AddressFormPageActions(appium);
		addressformpageactions.verifycity(expectedautopopulatecityname);
		addressformpageactions.populatestates();
		addressformpageactions.selectState();
		}
	
	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=8)
	public void verifydropdown() throws InterruptedException{
		addressformpageactions = new AddressFormPageActions(appium);
		addressformpageactions.scrolltopreference();
		addressformpageactions.selectdelivtime();
		addressformpageactions.saveaddress();
	}

	@Severity(SeverityLevel.MINOR)
	@Parameters({"expetedSaveMsg"})
	@Test(priority=9)
	public void verifySaveAddressConfirmation(String expetedSaveMsg){
		addressformpageactions.verifysavemsg(expetedSaveMsg);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test(priority=10)
	public void navigatehome(){
		langpageobjactions = new LangPageActions(appium);
		langpageobjactions.clickhome();
		
	}


	/*@Severity(SeverityLevel.NORMAL)
	@Parameters({"udupipin"})
	@Test(priority=11)
	public void setgreenzonelocation(@Optional String udupipin ) throws InterruptedException{
		deliverylocationpageobjactions = new DeliveryLocationPageActions(appium);
		deliverylocationpageobjactions.changedelvlocation();
		deliverylocationpageobjactions.clickeditpincode();
		deliverylocationpageobjactions.clearnpincode();
		deliverylocationpageobjactions.sendpincode(udupipin);
		deliverylocationpageobjactions.applypin();

	}*/

	@Severity(SeverityLevel.BLOCKER)
	@Parameters({"productName"})
	@Test(priority=11)
	public void searchTV(@Optional String productName) throws InterruptedException{
		searchpageobjactions = new SearchPageActions(appium);
		searchpageobjactions.clicksearch();
		searchpageobjactions.clearSearchText();
		searchpageobjactions.enterProdKey(productName);
		searchpageobjactions.selectdropdown();
	}


	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=12)
	public void scrollTVlistSelect() throws InterruptedException {
		gettvpageobjactions = new GetTvPageActions(appium);
		gettvpageobjactions.swipetwopage();
		gettvpageobjactions.dynamicpressByCoordinates();
	}

	@Severity(SeverityLevel.MINOR)
	@Test(priority=13)
	public void tvDetails() throws InterruptedException{
		gettvpageobjactions = new GetTvPageActions(appium);
		gettvpageobjactions.tvbrandName();
		gettvpageobjactions.tvdescr();
		//gettvpageobjactions.dynamicscroll();
		gettvpageobjactions.tvprice();
		gettvpageobjactions.addcart();
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test(priority=14)
	public void gotocartview(){
		gotocartpageobjactions = new GoCartPageActions(appium);
		//gotocartpageobjactions.getTvPriceBeforeCart();
		gotocartpageobjactions.gotocartviewTv();
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority=15)
	public void proceedpay(){
		proceedpaypageobjactions = new ProceedPayPageActions(appium);
		proceedpaypageobjactions.getTvDesatPay();
		proceedpaypageobjactions.proceedtoPay();
	}
}
