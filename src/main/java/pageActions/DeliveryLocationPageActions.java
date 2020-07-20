package pageActions;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.DeliveryLocationObjs;
import utils.ReusableMethod;

public class DeliveryLocationPageActions extends ReusableMethod{

	
	Logger apachelog = Logger.getLogger(DeliveryLocationPageActions.class);

	String newlocationStr;
	String afterSetlocationStr;
	
	public DeliveryLocationObjs deliverylocationpageobj = new DeliveryLocationObjs();
	public AppiumDriver<MobileElement> appium;


	public DeliveryLocationPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), deliverylocationpageobj);
	}
	public void changedelvlocation(){
		waitForEleToClick(deliverylocationpageobj.clickdelvlocation);
		Assert.assertTrue(deliverylocationpageobj.clickdelvlocation.isEnabled());
		System.out.println("Edit Delivery Location is Enable to Edit");
		//existlocationStr = deliverylocationpageobj.clickdelvlocation.getText();
		deliverylocationpageobj.clickdelvlocation.click();
		apachelog.info("****Clicked On Change Location Succesfully****");

	}
	public void clickeditpincode(){
		waitForEleToClick(deliverylocationpageobj.clickpincode);
		Assert.assertTrue(deliverylocationpageobj.clickpincode.isEnabled());
		deliverylocationpageobj.clickpincode.click();
		apachelog.info("Edit PinCode Button is Enable to Click");
	}

	public void clearnpincode(){
		waitForEleToClick(deliverylocationpageobj.clearexistpincode);
		Assert.assertTrue(deliverylocationpageobj.clearexistpincode.isDisplayed());
		System.out.println("Clear Existing Pin Code is Displayed to Clear");
		deliverylocationpageobj.clearexistpincode.clear();
		apachelog.info("Clread the Existing PinCode Succesfully");
	}
	public void sendpincode(String udupipin){
		waitForEleToClick(deliverylocationpageobj.sendgreenzonepincode);
		Assert.assertTrue(deliverylocationpageobj.sendgreenzonepincode.isEnabled());
		deliverylocationpageobj.sendgreenzonepincode.sendKeys(udupipin);
		newlocationStr=deliverylocationpageobj.sendgreenzonepincode.getText();
		apachelog.info("Enter PinCode TextBox is Enable to Entered the PinCode Succesfully");
	}
	public void applypin(){
		Assert.assertTrue(deliverylocationpageobj.applygreenzonepincode.isEnabled());
		deliverylocationpageobj.applygreenzonepincode.click();
		apachelog.info("Apply PinCode Button Clicked Succesfully");
	}
	public void verifySetpincode(){
		afterSetlocationStr=deliverylocationpageobj.clickdelvlocation.getText();
		Assert.assertEquals(afterSetlocationStr, newlocationStr);
		apachelog.info("AssertEquals True --> New PinCode Saved and Populating Succesfully");
		
	}
}
