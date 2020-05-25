package SeleniumAssignment1.Constants;

public class MMTConstants {

    // xPaths
    public String BUTTON_Search = "//a[contains(@class,'widgetSearchBtn')]";
    public String BUTTON_BookNow = "//div[@class='viewFaresOuter collapse in']/div[1]//button[contains(@class,'btn fli_primary_btn')]";
    public String BUTTON_ViewFare = "//div[@class='fli-intl-lhs pull-left']/div[1]/div[1]//button[contains(@id,'bookbutton-RKEY')]";
    public String DATE_DepartureDay = "//div[@aria-label='Wed Jun 17 2020']";
    public String DATE_Review = "//div[@class='pull-left']/div[1]//p[@class='font14 append_bottom3 LatoBold']";
    public String LABEL_DepartureDate = "//p[@data-cy='departureDate']";
    public String LABEL_FromReview = "//p[@class='dept-city']/span";
    public String LABEL_ToReview = "//p[@class='arrival-city']/span";
    public String OPTION_OneWay = "//li[@data-cy='oneWayTrip']";
    public String LABEL_FromCity = "//input[@id='fromCity']";
    public String LABEL_ToCity = "//input[@id='toCity']";
    public String TEXTBOX_City = "//input[contains(@class,'input react-autosuggest')]";

    // Strings
    public String MMT_URL = "https://www.makemytrip.com/";
    public String FromCity = "Bengaluru, India";
    public String ToCity = "Mumbai, India";
    public String Date = "Wed, 17 Jun 20";

}
