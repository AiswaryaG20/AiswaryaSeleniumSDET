package SeleniumAssignment1.PageObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DemoQaMethods extends Utilities {


    public void selectDate(String date, List<WebElement> noOfCols)
    {
        //Loop will rotate till expected date not found.
        for (WebElement cell: noOfCols){
            //Select the date from date picker when condition match.
            if (cell.getText().equals(date)){
                cell.findElement(By.linkText(date)).click();
                break;
            }
        }
    }

}
