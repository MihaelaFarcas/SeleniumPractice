package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebTablePage {

    public WebDriver driver;

    public WebTablePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
