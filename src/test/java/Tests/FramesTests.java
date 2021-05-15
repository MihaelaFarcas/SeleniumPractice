package Tests;

import Base.BaseTest;
import Help.ElementMethods;
import Help.FrameMethods;
import Help.PageMethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FramesTests extends BaseTest {

    public FrameMethods frameMethods;
    public PageMethods pageMethods;
    public ElementMethods elementMethods;


    @Test
    public void TestAutomat() {

        frameMethods=new FrameMethods(driver);
        pageMethods=new PageMethods(driver);
        elementMethods=new ElementMethods(driver);

       pageMethods.ValidateTitlePage("Register");

        //Daca avem un text salvat in interiorul codului HTML scris cu negru la capatul liniei >textul<
        //Putem folosi contains cand identificam dupa XPath
        ////a[contains(text(),'Switch')]

        WebElement SwitchtomeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.HoverElement(SwitchtomeniuWeb);


        //Declaram un wait explicit care sa astepte dupa element
        elementMethods.WaitElementVisible(By.xpath("//a[contains(text(),'Frames')]"));
        WebElement FramesSubMeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Frames')]"));
        FramesSubMeniuWeb.click();

        pageMethods.NavigateToURL("http://demo.automationtesting.in/Frames.html");

        //Ne putem muta pe un Iframe dupa id,nume sau web element
        List <WebElement> FrameButtons=driver.findElements(By.xpath("//ul[@class='nav nav-tabs ']/li/a"));
        FrameButtons.get(0).click();

        frameMethods.SwitchFrameById("singleframe");
        WebElement InputSingleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputSingleFrame.sendKeys("Vreau concediu");
        //Dupa ce am terminat de lucrat cu un IFrame trebuie sa ne mutam pe frame-ul default

        frameMethods.SwitchFrameDefault();

        FrameButtons.get(1).click();

        frameMethods.SwitchFrameByElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        frameMethods.SwitchFrameByElement(By.xpath("//iframe[@src='SingleFrame.html']"));
        WebElement InputMultipleFrame= driver.findElement(By.xpath("//input[@type='text']"));
        InputMultipleFrame.sendKeys("Cel mai tare din parcare");
        frameMethods.SwitchFrameDefault();
        driver.quit();
    }
}
