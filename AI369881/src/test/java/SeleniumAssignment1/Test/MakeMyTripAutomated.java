package SeleniumAssignment1.Test;

import SeleniumAssignment1.Constants.BrowserConstants;
import SeleniumAssignment1.Constants.MMTConstants;
import SeleniumAssignment1.PageObj.MmtMethods;
import SeleniumAssignment1.PageObj.Utilities;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class MakeMyTripAutomated extends MMTConstants {

    Utilities utils = new Utilities();
    WebDriver driver;
    BrowserConstants browserConstants = new BrowserConstants();
    MmtMethods mmtMethods = new MmtMethods();

    /*Automate MakeMyTrip application for booking and reviewing the details*/
    @Test
    public void bookFlightMakeMyTrip() throws NullPointerException{
        try {
            // Launch the browser with URL
            utils.launchURL(browserConstants.CHROME,MMT_URL);
            driver = utils.driver;
            // Select 'One Way' option
            utils.clickElement(OPTION_OneWay);
            // Click on the From option
            utils.clickElement(LABEL_FromCity);
            // Select From city
            mmtMethods.selectCity(FromCity);
            // Click on To option
            utils.clickElement(LABEL_ToCity);
            // Select To city
            mmtMethods.selectCity(ToCity);
            // Select the date
            utils.clickElement(DATE_DepartureDay);
            // Click on the Search button
            utils.clickElement(BUTTON_Search);
            // Choose cheapest flight and book
            mmtMethods.selectAndClickBookFlight();
            ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
            // Switch back to main page
            driver.switchTo().window(tabs.get(1 ));
            // Review the details
            mmtMethods.reviewBooking();
            // Close browser
            driver.quit();
        } catch (Exception e) {
            throw new NullPointerException();
        }
    }
}
