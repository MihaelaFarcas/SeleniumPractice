package Help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PageMethods {

    //Metode generale strict pentru interactiunea cu o pagina

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver=driver;
    }

    public void ValidateTitlePage(String ExpectedValue){

        String ActualPageTitle=driver.getTitle();
        Assert.assertEquals
                ("Pagina curenta nu are titlu corect",
                        ExpectedValue,ActualPageTitle);

    }

    public void NavigateToURL(String URLValue){
        driver.navigate().to(URLValue);
    }
}
