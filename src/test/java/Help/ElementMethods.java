package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver){
        this.driver=driver;
    }

    public void HoverElement(WebElement element){
        Actions Action= new Actions(driver);
        Action.moveToElement(element).build().perform();
    }

    public void WaitElementVisible(By Identificator)
    {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOfElementLocated(Identificator));
    }

    public void ClickElement(WebElement element){
        element.click();

    }
}
