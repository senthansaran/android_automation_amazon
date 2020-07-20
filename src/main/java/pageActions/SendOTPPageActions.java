package pageActions;




import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.SendOTPobjs;
import utils.ReusableMethod;

public class SendOTPPageActions extends ReusableMethod{

	Logger appachelog = Logger.getLogger(SendOTPPageActions.class);

	public String validOTP;

	public SendOTPobjs sendotpobject = new SendOTPobjs();
	public AppiumDriver<MobileElement> appium;

	public SendOTPPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), sendotpobject);
	}

	public void getotp() throws InterruptedException{
		Thread.sleep(10000);
		waitForEleToClick(sendotpobject.getoptmsg);
		Assert.assertTrue(sendotpobject.getoptmsg.isDisplayed());
		appachelog.info("OTP MSG is Displaed");
		String fullOTP = sendotpobject.getoptmsg.getText();
		appachelog.info("****Complet Text Msg is"+" "+fullOTP+" "+"****");   
		if(fullOTP.length()>=6){
			validOTP = fullOTP.substring(0,6);   
			appachelog.info("After SubString and Extract the Six Digit OTP is"+" "+validOTP);
		}else{
			appachelog.info("The length of Char in OTP has been Changed to either < 6 or > 6 Char");
		}
	}

	public void backtoAmazon() throws InterruptedException{
		Thread.sleep(2000);
		clickBackButton();
		Thread.sleep(5000);
	}

	public void parseOTP(){
		waitForEleToClick(sendotpobject.parseOTP);
		Assert.assertTrue(sendotpobject.parseOTP.isEnabled());
			sendotpobject.parseOTP.sendKeys(this.validOTP);
			appachelog.info("Entered the OTP in TextBox Successfully");
		}

	public void otpConfirm(){
		Assert.assertTrue(sendotpobject.confirmOTP.isEnabled());
			sendotpobject.confirmOTP.click();
			appachelog.info("Clicked on Confirm OTP Button Successfully");
		}
	

}

