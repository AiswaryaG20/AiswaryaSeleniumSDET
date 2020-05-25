package SeleniumAssignment1.PageObj;

import SeleniumAssignment1.Constants.OlayConstants;
import org.testng.Assert;

public class OlayMethods extends OlayConstants {

    Utilities utils = new Utilities();


    /* Method to register new user */

    public void userRegistration(String emailId){
        // Enter value for email ID
        utils.enterValue(TEXTBOX_Email,emailId);
        // Enter password
        utils.enterValue(TEXTBOX_Password,Password);
        // Re-enter password
        utils.enterValue(TEXTBOX_ConfirmPassword,Password);
        if (utils.isElementExist(SELECT_Day)) {
            // Select birth date
            utils.selectDropDownItem(SELECT_Day,7);
            // Select birth month
            utils.selectDropDownItem(SELECT_Month,9);
            // Select birth year
            utils.selectDropDownItem(SELECT_Year,10);
        } else {
            // Select birth date
            utils.selectDropDownItem(SELECT_DayGerman,7);
            // Select birth month
            utils.selectDropDownItem(SELECT_MonthGerman,9);
            // Select birth year
            utils.selectDropDownItem(SELECT_YearGerman,10);
        }
        utils.scrollForElement(LABEL_Footer);
        // Click on Register button
        utils.clickElement(BUTTON_Register);
    }


    /* Method to fill subscriber details */

    public void fillSubscriberDetails(String region){
        // Enter first name
        utils.enterValue(TEXTBOX_FirstName,"First Name");
        // Enter last name
        utils.enterValue(TEXTBOX_SecondName,"Last Name");
        if(region.equalsIgnoreCase("UK")||region.equalsIgnoreCase("GERMANY")) {
            // Enter Street
            utils.enterValue(TEXTBOX_Street, "Street Name");
            // Enter City
            utils.enterValue(TEXTBOX_City, "City");
            // Enter Postcode
            utils.enterValue(TEXTBOX_Postcode, "22041");
            if (region.equalsIgnoreCase("Germany"))
                // Select the land
                utils.selectDropDownItem(SELECT_Land,1);
            else
                // Click on 'Add to My Profile' button
                utils.clickElement(BUTTON_AddToMyProfile);
        }else {
            // Enter middle name
            utils.enterValue(TEXTBOX_MiddleName, "Middle Name");
            // Enter phone number
            utils.enterValue(TEXTBOX_Phone,Spain_Phone);
        }
    }


    /* Method for login */

    public void loginWithUser(String username, String region){
        // Enter username
        utils.enterValue(TEXTBOX_LoginUsername,username);
        // Enter password
        utils.enterValue(TEXTBOX_LoginPassword,Password);
        utils.scrollForElement(LABEL_SocialMedia);
        // Click on Sign In button
        if (region.equalsIgnoreCase("UK"))
            utils.clickElement(BUTTON_SignIn);
        else if (region.equalsIgnoreCase("Spain"))
            utils.clickElement(BUTTON_SignIn_Spanish);
        else
            utils.clickElement(BUTTON_SignIn_German);
    }


    /* Method to register and login with new user */

    public void registerOlayUserAndLogin(String emailId, String region) throws InterruptedException {
        String regMessage,yourProfile,profileXPath;
        // Update user details
        fillSubscriberDetails(region);
        // Register the new user
        userRegistration(emailId);
        Thread.sleep(2000);
        String message = utils.getTextFrom(LABEL_Header);
        if (region.equalsIgnoreCase("Spain")){
            regMessage = RegistrationCompleteMsg_Spanish;
            profileXPath = LABEL_YourProfile_Spanish;
            yourProfile = YourProfile_Spanish;
        }
        else {
            regMessage = RegistrationCompleteMsg_German;
            profileXPath = LABEL_YourProfile;
            yourProfile = YourProfile_German;
        }
        // Verify the registration complete message
        Assert.assertEquals(message,regMessage);
        // Login with the new user
        loginWithUser(emailId, region);
        Thread.sleep(2000);
        String header = utils.getTextFrom(profileXPath);
        // Verify the page header after login
        Assert.assertEquals(header,yourProfile);
    }
}
