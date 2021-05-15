package Help;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameMethods {
    public WebDriver driver;

    public FrameMethods(WebDriver driver){
        this.driver=driver;
    }

    public void SwitchFrameById(String Value){
        driver.switchTo().frame(Value);
    }

    public void SwitchFrameByValue(String Value){
        driver.switchTo().frame(Value);
    }

    public void SwitchFrameByElement(By Identificator){
        driver.switchTo().frame(driver.findElement(Identificator));
    }

    public void SwitchFrameDefault(){
        driver.switchTo().defaultContent();
    }

}
