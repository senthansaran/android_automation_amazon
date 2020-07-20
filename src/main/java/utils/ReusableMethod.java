package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.ui.context.support.UiApplicationContextUtils;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ReusableMethod {


	public AppiumDriver<MobileElement> appium;

	Logger apachelogger = Logger.getLogger(ReusableMethod.class);


	public ReusableMethod(AppiumDriver<MobileElement> appium) {
		this.appium = appium;
	}

	public WebElement waitForElement(WebElement arg) {
		waitForEleToClick(arg);
		WebElement el = arg;
		return el;
	}

	public void waitForEleToClick(WebElement id) {
		WebDriverWait wait = new WebDriverWait(appium, 15);
		wait.until(ExpectedConditions.elementToBeClickable(id));
		
	}
	
	
	public void waitForElements(List<MobileElement> listofstates){
		WebDriverWait wait = new WebDriverWait(appium, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By) listofstates));
	}
	

	public void dynamicpressByCoordinates () {
		Dimension size = appium.manage().window().getSize();
		int startVerticalY = (int) (size.height * 0.9);
		int startVerticalX = (int) (size.width / 1.1);
		new AndroidTouchAction(appium)
		.press(PointOption.point(startVerticalX,startVerticalY))
		.release()
		.perform();
	}

	public void swipeUp() {
		org.openqa.selenium.Dimension size = appium.manage().window().getSize();
		int startVerticalY = (int) (size.height * 0.9);
		int endVerticalY = (int) (size.height * 0.6);
		int startVerticalX = (int) (size.width / 2);
		apachelogger.info("****Starting X Axis Corrdinates:"+" "+startVerticalX+"Starting Y Axis Corrdinates:"+" "+startVerticalY+" "+"And End of Y Axis Corrdinates:"+" "+endVerticalY+" "+"****");
		@SuppressWarnings("rawtypes")
		TouchAction obj = new TouchAction(appium);
		obj.press(PointOption.point(startVerticalX, startVerticalY)).
		waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).
		moveTo(PointOption.point(startVerticalX, endVerticalY)).
		release().perform();


	}
   
	
	
	public void swipetwopage() throws InterruptedException{
		for(int i=0;i<4;i++){
			swipeUp();
		}
	}

	public void swipeUpUntilTextExists(String expected) throws InterruptedException {
		do {
			swipeUp();
			Thread.sleep(1000);
		} while (!appium.getPageSource().contains(expected));
		//while (!appium.getPageSource().equalsIgnoreCase(expected));
		
	}
	


	public void clickBackButton() {
		appium.navigate().back(); 
	}
	public void keyboarddismiss(){
		appium.hideKeyboard();
	}

}
