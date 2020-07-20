package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.AddDeliveryAddress;
import utils.ReusableMethod;

public class DeliveryAddressPageActions extends ReusableMethod{

	AddDeliveryAddress deliveryaddresspageobj = new AddDeliveryAddress();
	Logger apachelogger = Logger.getLogger(DeliveryAddressPageActions.class);
	public AppiumDriver<MobileElement> appium;

	public DeliveryAddressPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), deliveryaddresspageobj);
	}

	public void selectMenu(){
		waitForEleToClick(deliveryaddresspageobj.leftopmenu);
		Assert.assertTrue(deliveryaddresspageobj.leftopmenu.isEnabled());
		deliveryaddresspageobj.leftopmenu.click();
		apachelogger.info("****Cliked the Left Menu Successfully****");
	}

	public void clickyouraccount(){
		waitForEleToClick(deliveryaddresspageobj.youraccount);
		Assert.assertTrue(deliveryaddresspageobj.youraccount.isEnabled());
		deliveryaddresspageobj.youraccount.click();
		apachelogger.info("****Cliked Your Account Succesfully****");
	}

	
	public void clickyouraddress(){
		waitForEleToClick(deliveryaddresspageobj.youraddress);
		Assert.assertTrue(deliveryaddresspageobj.youraddress.isEnabled());
		deliveryaddresspageobj.youraddress.click();
		apachelogger.info("****Cliked Your Address Successfully****");
	}

	public void clickaddnewaddress(){
		waitForEleToClick(deliveryaddresspageobj.addnewaddress);
		Assert.assertTrue(deliveryaddresspageobj.addnewaddress.isEnabled());
		deliveryaddresspageobj.addnewaddress.click();
		apachelogger.info("****Cliked Add New Address Successfully****");
	}


}








