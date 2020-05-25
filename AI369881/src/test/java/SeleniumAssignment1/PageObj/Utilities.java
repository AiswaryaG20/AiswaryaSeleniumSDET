package SeleniumAssignment1.PageObj;

import SeleniumAssignment1.Constants.BrowserConstants;
import SeleniumAssignment1.Constants.ReportingConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public class Utilities {

    BrowserConstants browserConstants;
    ReportingConstants reportingConstants;

    public static WebDriver driver;

    public Utilities(){
        browserConstants = new BrowserConstants();
        reportingConstants = new ReportingConstants();
    }

    public void launchURL(String browser, String uRL){
        try {
            if (browser.equalsIgnoreCase(browserConstants.CHROME)) {
                // Initialize chrome browser
                System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                this.driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase(browserConstants.FIREFOX)) {
                // Initialize firefox browser
                System.setProperty("webdriver.firefox.marionette", "./Drivers/geckodriver.exe");
                this.driver = new FirefoxDriver();
            }
            // Launch browser and direct to the respective URL
            driver.get(uRL);
            // Maximize browser
            driver.manage().window().maximize();
            String currentUrl = driver.getCurrentUrl();
            // Validate the URL launched
            Assert.assertEquals(uRL,currentUrl);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void clickElement(String xPath){
        driver.findElement(By.xpath(xPath)).click();
    }

    public void enterValue(String xPath, String value){
        driver.findElement(By.xpath(xPath)).sendKeys(value);
    }

    public void selectDropDownItem(String xPath, int index){
        Select dropDay = new Select(driver.findElement(By.xpath(xPath)));
        dropDay.selectByIndex(index);
    }

    public String getTextFrom(String xPath){
        String text = driver.findElement(By.xpath(xPath)).getText();
        return text;
    }

    public void scrollForElement(String xPath){
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();
    }

    public boolean isElementExist(String xPath){
        Boolean isPresent = driver.findElements(By.xpath(xPath)).size() > 0;
        return isPresent;
    }

    public void containsText(String actual, String expected){
        boolean flag = false;
        if(expected.contains(actual))
            flag = true;
        Assert.assertTrue(flag,"Text doesn't match");
    }

}
