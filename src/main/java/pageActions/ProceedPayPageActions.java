package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.ProceedPayObjs;
import utils.ReusableMethod;

public class ProceedPayPageActions extends ReusableMethod{
	public String tvdescatpaypage;
	
	Logger apachelog = Logger.getLogger(ProceedPayPageActions.class);
	
	public ProceedPayObjs proceedpaypageobjactions = new ProceedPayObjs();
	public AppiumDriver<MobileElement> appium;

	public ProceedPayPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), proceedpaypageobjactions);
	}
	
	public void proceedtoPay(){
		waitForEleToClick(proceedpaypageobjactions.proceedPay);
		Assert.assertTrue(proceedpaypageobjactions.proceedPay.isEnabled());
		proceedpaypageobjactions.proceedPay.click();
		apachelog.info("****Proceed to Pay Btn Clicked Successfully****");
	}
	public void getTvDesatPay(){
		waitForEleToClick(proceedpaypageobjactions.getTvDescatpay);
		Assert.assertTrue(proceedpaypageobjactions.getTvDescatpay.isEnabled());
		tvdescatpaypage=proceedpaypageobjactions.getTvDescatpay.getText();
		apachelog.info("****The Tv Des in Cart is"+" "+tvdescatpaypage+" "+"****");
		Assert.assertEquals(GetTvPageActions.tvDesc,tvdescatpaypage);
		apachelog.info("****The Tv Descripti in Product Reveiw Page and Cart Page Tv Description is as Expected****");
	}

}
