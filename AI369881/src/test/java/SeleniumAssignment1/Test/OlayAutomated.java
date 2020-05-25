package SeleniumAssignment1.Test;

import SeleniumAssignment1.Constants.BrowserConstants;
import SeleniumAssignment1.Constants.OlayConstants;
import SeleniumAssignment1.PageObj.OlayMethods;
import SeleniumAssignment1.PageObj.Utilities;
import com.jayway.jsonpath.JsonPath;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Random;

public class OlayAutomated extends OlayConstants {
    Utilities utils = new Utilities();
    WebDriver driver;
    BrowserConstants browserConstants = new BrowserConstants();
    OlayMethods olayMethods = new OlayMethods();


    /* Register an email ID and sign in for UK region
    *
    * Email ID generated using Randomize method */

    @Test(priority=1)
    public void registerAndSignInOlayUk() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlayUkUrl);
            driver = utils.driver;
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(1000);
            String emailId = "OlayUser"+randomInt+"@gmail.com";
            // Click on 'Reject All Cookies' button
            utils.clickElement(BUTTON_RejectCookies);
            // Click on 'Register' link
            utils.clickElement(LINK_Register);
            // Register the new user
            olayMethods.userRegistration(emailId);
            // Update user details
            olayMethods.fillSubscriberDetails("UK");
            Thread.sleep(2000);
            String message = utils.getTextFrom(LABEL_Header);
            // Verify the registration complete message
            Assert.assertEquals(message,RegistrationCompleteMsg);
            Thread.sleep(2000);
            // Login with the new user
            olayMethods.loginWithUser(emailId, "UK");
            String header = utils.getTextFrom(LABEL_YourProfile);
            // Verify the page header after login
            Assert.assertEquals(header,YourProfile);
            // Click on Sign Out link
            utils.clickElement(LINK_SignOut);
            // Click on Log Out button
            utils.clickElement(BUTTON_LogOut);
        } catch (InterruptedException e) {
            throw new NullPointerException();
        }
    }


    /* Register an email ID and sign in for Spain region with a Female user
     *
     * Email ID read from Excel sheet : OlayUserExcel.xlsx */

    @Test(priority=4)
    public void registerAndSignInOlaySpainFemaleUser() throws NullPointerException, IOException, InterruptedException {
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlaySpainUrl);
            driver = utils.driver;
            // Get data from excel sheet
            File file = new File("src/main/resources/TestData/OlayUserExcel.xlsx");
            FileInputStream fin = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fin);
            XSSFSheet sheet = wb.getSheet("OlayUserID");
            XSSFRow xssfRow = sheet.getRow(1);
            XSSFCell cell = xssfRow.getCell(0);
            // Assigning email ID
            String emailId = cell.getStringCellValue();
            System.out.println("User email ID: "+emailId);
            // Click on 'Register' link
            utils.clickElement(LINK_Register);
            // Click on Female icon
            utils.clickElement(IMG_Female);
            // Register and login with new user ID
            olayMethods.registerOlayUserAndLogin(emailId,"Spain");
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    /* Register an email ID and sign in for Spain region with a Male user
     *
     * Email ID read from Excel sheet : OlayUserExcel.xlsx */

    @Test(priority=5)
    public void registerAndSignInOlaySpainMaleUser() throws NullPointerException, IOException, InterruptedException {
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlaySpainUrl);
            driver = utils.driver;
            // Get data from excel sheet
            File file = new File("src/main/resources/TestData/OlayUserExcel.xlsx");
            FileInputStream fin = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fin);
            XSSFSheet sheet = wb.getSheet("OlayUserID");
            XSSFRow xssfRow = sheet.getRow(2);
            XSSFCell cell = xssfRow.getCell(0);
            // Assigning email ID
            String emailId = cell.getStringCellValue();
            System.out.println("User email ID: "+emailId);
            // Click on 'Register' link
            utils.clickElement(LINK_Register);
            // Click on male icon
            utils.clickElement(IMG_Male);
            // Register and login with new user ID
            olayMethods.registerOlayUserAndLogin(emailId,"Spain");
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    /* Register an email ID and sign in for Germany region with a Female user
     *
     * Email ID read from JSON file : EmailIDs.json */

    @Test(priority=3)
    public void registerOlayGermany() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlayGermanyUrl);
            driver = utils.driver;
            // Retrieve data from JSON file
            File file = new File("src/main/resources/TestData/EmailIDs.json");
            String emailId = JsonPath.read(file,"$."+"emailID");
            System.out.println("User email ID: "+emailId);
            // Click on 'Register' link
            utils.clickElement(LINK_Register);
            // Click on Female icon
            utils.clickElement(IMG_Female);
            // Register and login with new user ID
            olayMethods.registerOlayUserAndLogin(emailId,"Germany");
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }



    /*
    *   Olay China link: https://www.olay.com.cn/  seems to be out of service and unable to automate.
    */



    /*
     * Verify the validation for duplicate email ID registration
     */

    @Test(priority=2)
    public void verifyDuplicateUserErrorOlay() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlayUkUrl);
            driver = utils.driver;
            // Click on 'Register' link
            utils.clickElement(LINK_Register);
            olayMethods.userRegistration("OlayTestUser@gmail.com");
            String dupError = utils.getTextFrom(ERROR_DuplicateUser);
            Assert.assertEquals(dupError,DuplicateUserError);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }


    /*
    * Verify invalid password validation
    */

    @Test
    public void verifyInvalidPasswordError() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlayUkUrl);
            driver = utils.driver;
            // Click on Sign In link
            utils.clickElement(LINK_SignIn);
            // Enter username
            utils.enterValue(TEXTBOX_LoginUsername,"OlayTestUser@gmail.com");
            // Enter password
            utils.enterValue(TEXTBOX_LoginPassword,"Password123");
            // Click on Sign In button
            utils.clickElement(BUTTON_SignIn);
            String invalidError = utils.getTextFrom(ERROR_InvalidUser);
            // Verify the invalid password error
            Assert.assertEquals(invalidError,InvalidUserError);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }


    /*
    * Verify forgot password functionality
    */

    @Test
    public void verifyForgotPasswordFunctionality() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,OlayUkUrl);
            driver = utils.driver;
            // Click on Sign In link
            utils.clickElement(LINK_SignIn);
            // Click on password link
            utils.clickElement(LINK_ForgotPassword);
            String headerText = utils.getTextFrom(LABEL_Header);
            // Verify Reset Password header text
            Assert.assertEquals(headerText,ResetPassword);
            // Enter email ID
            utils.enterValue(TEXTBOX_LoginUsername,"OlayTestUser@gmail.com");
            // Click on Next button
            utils.clickElement(BUTTON_Next);
            String mailSent = utils.getTextFrom(LABEL_MailSentMessage);
            // Verify the mail sent successfully message
            Assert.assertEquals(mailSent,MailSentMessage);
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser(){
        this.driver.close();
        System.out.println("Browser closed.");
    }
}
