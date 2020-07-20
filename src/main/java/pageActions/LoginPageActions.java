package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.LoginObjs;
import utils.ReusableMethod;

public class LoginPageActions extends ReusableMethod{

	Logger appachelog = Logger.getLogger(LoginPageActions.class);

	public LoginObjs loginpageobj = new LoginObjs();
	public AppiumDriver<MobileElement> appium;

	public LoginPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), loginpageobj);
	}

	public void guestlogin(){
		Assert.assertTrue(loginpageobj.guestsignin.isEnabled());
		loginpageobj.guestsignin.click();
		appachelog.info("****GuestLogin Clicked Successfully****"); //$NON-NLS-1$
	}
	
	public void clickalreadysign_in(){

		Assert.assertTrue(loginpageobj.existing_signin.isEnabled());
		loginpageobj.existing_signin.click();
		appachelog.info("Clicked as Existing User Sign-in Buttons Successfully");
	}
	public void enteruserid(String userid){
		Assert.assertTrue(loginpageobj.enter_userid.isEnabled());
		loginpageobj.enter_userid.sendKeys(userid);
		appachelog.info("Entered the UserId in TextBox Successfully");
	}
	public void clickusercont(){
		Assert.assertTrue(loginpageobj.clickuseridcont.isEnabled());
		loginpageobj.clickuseridcont.click();
		appachelog.info("Clicked the Continue Button Successfully");
	}
	public void enterpass(String password){
		Assert.assertTrue(loginpageobj.enterpass.isEnabled());
		loginpageobj.enterpass.sendKeys(password);
		appachelog.info("Entered the PassWord Successfully");
	}
	public void getOTPpassword(){
		waitForEleToClick(loginpageobj.getOTPpass);
		Assert.assertTrue(loginpageobj.getOTPpass.isEnabled());
		loginpageobj.getOTPpass.click();
		appachelog.info("Clicked on Get An OTP PassWord Btn Successfully");
	}

	public void clickpasscont(){
		Assert.assertTrue(loginpageobj.clickpasscont.isEnabled());
		loginpageobj.clickpasscont.click();
		appachelog.info("Clicked on Password Continue Button Successfully");

	}


}
