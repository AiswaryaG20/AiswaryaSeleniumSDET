package SeleniumAssignment1.PageObj;

import SeleniumAssignment1.Constants.MMTConstants;
import org.testng.Assert;

public class MmtMethods extends MMTConstants {

    Utilities utils = new Utilities();


    /* Method to select the city */

    public void selectCity(String City) throws InterruptedException {
        // Enter the city
        utils.enterValue(TEXTBOX_City,City);
        Thread.sleep(2000);
        // Click on the suggested option
        utils.clickElement("//p[text()='"+City+"']");
        Thread.sleep(1000);
    }


    /* Method to select and book the flight */

    public void selectAndClickBookFlight() throws InterruptedException {
        Thread.sleep(2000);
        String buttonText = utils.getTextFrom(BUTTON_ViewFare);
        // Click on View Fare button
        utils.clickElement(BUTTON_ViewFare);
        if(buttonText.equals("VIEW FARES")) {
            Thread.sleep(1000);
            // Click on Book now button
            utils.clickElement(BUTTON_BookNow);
        }
        Thread.sleep(2000);
    }


    /* Method to review booking */

    public void reviewBooking(){
        String departureDate = utils.getTextFrom(DATE_Review);
        // Verify the departure date
        utils.containsText(departureDate,Date);
        String departureCity = utils.getTextFrom(LABEL_FromReview);
        // Verify the departure city
        utils.containsText(departureCity,FromCity);
        String arrivalCity = utils.getTextFrom(LABEL_ToReview);
        // Verify the arrival city
        utils.containsText(arrivalCity,ToCity);
    }

}
