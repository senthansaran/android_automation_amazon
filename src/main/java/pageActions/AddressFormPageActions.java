package pageActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pageObj.AddressFormObj;
import utils.ReusableMethod;

public class AddressFormPageActions extends ReusableMethod{

	String sheetName="DeliveryBook"; 
	String expectedstate ="Karnataka";
    String statename;
    
	Logger appachlog = Logger.getLogger(AddressFormPageActions.class);
	
	AddressFormObj addressformpageobj = new AddressFormObj();
	public AppiumDriver<MobileElement> appium;

	public AddressFormPageActions(AppiumDriver<MobileElement> appium) {
		super(appium);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(appium), addressformpageobj);
	}

	public void filladdressform(String firstnamee,String phonee,String postalcodee,String addresslinee1,String addresslinee2,String landmarke){

		//apachelogger.info("Valure from Excel"+" "+firstname+" "+phone+" "+postalcode+" "+addressline1+" "+addressline2+" "+landmark);

		waitForEleToClick(this.addressformpageobj.fullname);
		Boolean checkNameTextIsEnabled = this.addressformpageobj.fullname.isEnabled();
		Assert.assertTrue(checkNameTextIsEnabled);
		this.addressformpageobj.fullname.sendKeys(firstnamee);
		appachlog.info("****Full Name Entered Successfully****");
		
		Assert.assertTrue(this.addressformpageobj.phonenumb.isEnabled());
		this.addressformpageobj.phonenumb.sendKeys(phonee);
		appachlog.info("****Mobile Number Enter Successfully****");
	
		Assert.assertTrue(this.addressformpageobj.postalcode.isEnabled());
		this.addressformpageobj.postalcode.sendKeys(postalcodee);
		appachlog.info("****Zip Code Entered Succesfully****");
		
		Assert.assertTrue(this.addressformpageobj.addresline1.isEnabled());
		this.addressformpageobj.addresline1.sendKeys(addresslinee1);
		appachlog.info("****Address Line 1 Added Succesfully****");
		
		Assert.assertTrue(this.addressformpageobj.addresline2.isEnabled());
		this.addressformpageobj.addresline2.sendKeys(addresslinee2);
		appachlog.info("****Address Line 2 Added Succesfully****");
		
		keyboarddismiss();
		appachlog.info("****KeyPad Dismissed****");
		
		Assert.assertTrue( this.addressformpageobj.landmark.isEnabled());
		this.addressformpageobj.landmark.sendKeys(landmarke);
		appachlog.info("****Land Mark Entered Succesfully****");
		
	}
	public void verifycity(String expectedautopopulatecityname){
		Assert.assertTrue(addressformpageobj.delvirycity.isDisplayed());
		String atualcityname = addressformpageobj.delvirycity.getText();
		Assert.assertEquals(atualcityname, expectedautopopulatecityname);
		appachlog.info("****AssertEquals True -->Distric Auto Populdated As Per ZipCode Entered****");
	}

	public void populatestates(){
		//populatregions
		Assert.assertTrue(addressformpageobj.populatregions.isEnabled());
		addressformpageobj.populatregions.click();

	}
	public void selectState() throws InterruptedException{
		Assert.assertTrue(addressformpageobj.listofstates.isSelected());
		appachlog.info("****State Auto Populated and Get Auto Selected As Per Zip Code Entered****");
		addressformpageobj.listofstates.click();
		
	}
	public void scrolltopreference() throws InterruptedException {
		swipeUpUntilTextExists("Add address");
		Assert.assertTrue(addressformpageobj.deliveryprefe.isEnabled());
		addressformpageobj.deliveryprefe.click();
		appachlog.info("****Scroll to Delivery Time Preference Button Succesfully and Clicked****");
	}
	public void selectdelivtime(){
		waitForEleToClick(addressformpageobj.selectdelivpref);
		Assert.assertTrue(addressformpageobj.selectdelivpref.isDisplayed());
		addressformpageobj.selectdelivpref.click();
		appachlog.info("*****Selected the User Pereferd Delivery Tim****" );
	}
	
	public void saveaddress() throws InterruptedException {
		swipeUpUntilTextExists("Add address");
		Assert.assertTrue(addressformpageobj.saveaddress.isEnabled());
		addressformpageobj.saveaddress.click();
		appachlog.info("****Save Address Form is Clicked Successfully****");
	}

	//addressconfirmed

	public void verifysavemsg(String expetedSaveMsg){
		waitForEleToClick(addressformpageobj.addressconfirmed);
		Assert.assertTrue(addressformpageobj.addressconfirmed.isDisplayed());
		appachlog.info("*******Address Saved Prompt Displayed Successfully*******");
		//String expetedSaveMsg = "Address saved";
		String actualSaveMsg = addressformpageobj.addressconfirmed.getText();
		Assert.assertEquals(actualSaveMsg, expetedSaveMsg);
		appachlog.info("*******AssertEauals --> Address Save Form Success Prompt is Displayed as Expected");
		

	}

}
