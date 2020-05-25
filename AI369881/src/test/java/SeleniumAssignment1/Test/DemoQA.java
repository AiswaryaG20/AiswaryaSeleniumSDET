package SeleniumAssignment1.Test;

import SeleniumAssignment1.Constants.BrowserConstants;
import SeleniumAssignment1.Constants.DemoQAConstants;
import SeleniumAssignment1.Constants.ReportingConstants;
import SeleniumAssignment1.PageObj.DemoQaMethods;
import SeleniumAssignment1.PageObj.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoQA extends DemoQAConstants {

    Utilities utils = new Utilities();
    WebDriver driver;
    BrowserConstants browserConstants = new BrowserConstants();
    ReportingConstants reportingConstants = new ReportingConstants();
    DemoQaMethods demoQaMethods = new DemoQaMethods();


    /* 1. Click on each of the Items and print the Item Name */

    @Test
    public void clickItemPrintItemName() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+Selectable);
            driver = utils.driver;
            // For loop to click and print name of all items
            for(int i=1; i<=7; i++){
                // Click on the item
                utils.clickElement("//ol[@class='ui-selectable']/li["+i+"]");
                // Print the item name
                System.out.println(driver.findElement(By.xpath("//ol[@class='ui-selectable']/li["+i+"]")).getText());
            }
            driver.close();
        } catch (Exception e) {
           throw new NullPointerException();
        }
    }


    /* 2. Fill the contact form. */

    @Test
    public void fillContactForm() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+ContactForm);
            driver = utils.driver;
            // Enter value for first name
            utils.enterValue("//input[@class='firstname']","Aiswarya");
            // Enter value for last name
            utils.enterValue("//input[@id='lname']","Govind");
            // Enter value for country
            utils.enterValue("//input[@name='country']","India");
            // Enter subject
            utils.enterValue("//textarea[@id='subject']","Subject of matter");
            // Click on Submit button
            utils.clickElement("//input[@value='Submit']");
            // Navigate back to home page
            driver.navigate().back();
            String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
            // Open 'Google Link' in new tab
            utils.enterValue("//a[text()='Google Link']",selectLinkOpeninNewTab);
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            // Switch back to main page
            driver.switchTo().window(tabs.get(0));
            // Open 'Google Link is here' in new tab
            utils.enterValue("//a[contains(text(),'is here')]",selectLinkOpeninNewTab);
            // Switch back to main page
            driver.switchTo().window(tabs.get(0));
            Thread.sleep(1000);
            driver.quit();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }


    /* 3. Select the Drag me to my target and drop on the target and verify the text. */

    @Test
    public void dragAndDropTarget() throws NullPointerException,InterruptedException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+Droppable);
            driver = utils.driver;
            Actions actions = new Actions(driver);
            // Source web element
            WebElement source = driver.findElement(By.id("draggable"));
            // Traget web element
            WebElement target = driver.findElement(By.id("droppable"));
            // Perform drag and drop
            actions.dragAndDrop(source,target).perform();
            // Get the target text after dropping
            String targetText = target.getText();
            // Verify source is dropped
            if(targetText.equals("Dropped!"))
                System.out.println(reportingConstants.PASS+" Source dropped to target");
            else 
                System.out.println(reportingConstants.FAIL+" Source not dropped to target");
            Thread.sleep(1000);
            driver.close();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    /* 4. Select your Date of Birth in a Calendar. */

    @Test
    public void selectDate() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+Datepicker);
            driver = utils.driver;
            List<String> monthList = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
            // Expected Date, Month and Year
            String birthDate = "17";
            int birthMonth = 6;
            int birthYear = 2018;
            // Calendar Month and Year
            String calMonth = null;
            String calYear = null;
            boolean dateNotFound = true;
            // Click on date text box to open date picker popup.
            utils.clickElement("//input[@id='datepicker']");
            // This loop will be executed continuously till dateNotFound is true.
            while(dateNotFound)
            {
                // Retrieve current selected month name from date picker popup.
                calMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
                // Retrieve current selected year name from date picker popup.
                calYear = driver.findElement(By.className("ui-datepicker-year")).getText();

                // If current selected month and year are same as expected month and year then go Inside this condition.
                if(monthList.indexOf(calMonth)+1 == birthMonth && (birthYear == Integer.parseInt(calYear)))
                {
                    WebElement datePicker = driver.findElement(By.id("ui-datepicker-div"));
                    List<WebElement> noOfColumns = datePicker.findElements(By.tagName("td"));// Call selectDate function with date to select and set dateNotFound flag to false.
                    demoQaMethods.selectDate(birthDate,noOfColumns);
                    dateNotFound = false;
                }
                //If current selected month and year are less than expected month and year then go Inside this condition.
                else if(monthList.indexOf(calMonth)+1 < birthMonth && (birthYear == Integer.parseInt(calYear)) || birthYear > Integer.parseInt(calYear))
                {
                    //Click on next button of date picker.
                    utils.clickElement(".//*[@id='ui-datepicker-div']/div/a[2]/span");
                }
                //If current selected month and year are greater than expected month and year then go Inside this condition.
                else if(monthList.indexOf(calMonth)+1 > birthMonth && (birthYear == Integer.parseInt(calYear)) || birthYear < Integer.parseInt(calYear))
                {
                    //Click on previous button of date picker.
                    utils.clickElement(".//*[@id='ui-datepicker-div']/div/a[1]/span");
                }
            }
            Thread.sleep(1000);
            driver.close();
    } catch (Exception e) {
            throw new NullPointerException();
        }
    }


    /* 5. Select all the menu options one by one. */

    @Test
    public void selectMenu() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+SelectMenu);
            driver = utils.driver;
            // Select the value for speed
            utils.clickElement("//span[@id='speed-button']");
            utils.clickElement("//div[@id='ui-id-4']");
            // Select the value for file
            utils.clickElement("//span[@id='files-button']");
            utils.clickElement("//div[@id='ui-id-7']");
            // Select the value for number
            utils.clickElement("//span[@id='number-button']");
            utils.clickElement("//div[@id='ui-id-17']");
            // Select the value for title
            utils.clickElement("//span[@id='salutation-button']");
            utils.clickElement("//div[@id='ui-id-33']");
            Thread.sleep(1000);
            driver.close();
        } catch (InterruptedException e) {
            throw new NullPointerException();
        }
    }


    /* 6. Automate Rental Car Block. */

    @Test
    public void chooseRentalCar() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,DemoURL+ControlGroup);
            driver = utils.driver;
            // Click on car type drop down
            utils.clickElement("//span[@id='ui-id-8-button']");
            // Select type
            utils.clickElement("//div[@id='ui-id-13']");
            // Click on 'Automatic' radio button
            utils.clickElement("//label[@for='transmission-automatic-v']//span[contains(@class,'ui-corner-all')]");
            // Check the box for insurance
            utils.clickElement("//label[@for='insurance-v']//span[contains(@class,'ui-corner-all')]");
            // Enter the number of cars
            utils.enterValue("//input[@id='vertical-spinner']","2");
            // Click on 'Book Now!' button
            utils.clickElement("//button[@id='book']");
            Thread.sleep(1000);
            driver.close();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
