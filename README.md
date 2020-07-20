# android_automation_amazon
#Tools Used: Appium 1.17.1 Java Client 7.3.0 
#Extended Report - View existing report offline
#Allure Report- View the Report after execute the test script and run the command 'allure generate allure-results --clean -o allure-report' then On successfull execution it will generate one more folder allure-reportin your directory. Next Open index.html file in browser to show the report.

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
