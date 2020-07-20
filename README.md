# android_automation_amazon
#Tools Used: Appium 1.17.1 Java Client 7.3.0 
#Extended Report - View existing report offline
<img width="1439" alt="Extend Report" src="https://user-images.githubusercontent.com/17120627/87947123-84470580-cac0-11ea-87c1-40e55bc3b8c2.png">
#Allure Report- View the Report after execute the test script and run the command 'allure generate allure-results --clean -o allure-report' then On successfull execution it will generate one more folder allure-reportin your directory. Next Open index.html file in browser to show the report.
<img width="1369" alt="AllureReport" src="https://user-images.githubusercontent.com/17120627/87947092-7c876100-cac0-11ea-86f3-b326c688acb0.png">
#Here the sample saved screenshot.
<img width="1386" alt="ScreenShot" src="https://user-images.githubusercontent.com/17120627/87947108-80b37e80-cac0-11ea-95be-6f016a174de2.png">
Here the Android Automation Java project to below usecase.

Login as existing user using Email ID / Phone number and Get OTP from Message App and Enter into Amazon login. 
Set the Language Preference as English and Save. 
Set the Delivery Address to Move the Product into Cart(Read from Xls).
Search for Product with Keyword as '65Inch Tv' Select the random TV from listview. 
Get the TV brand, Description and Price, Move the product to Cart. 
Validate the the TV Price & Description. 
Proceed to Pay.

Pre-Requistest:(before Start Automation): 
Run the Appium Desktop server.
Please add the Mobile UDID and Device Name in config.properties. 
As a parameter Amazon UserID and Messeage app PackageName & Acitvity Name should be add in Testng.xml. 

To run the script use Maven clean & Maven install.
