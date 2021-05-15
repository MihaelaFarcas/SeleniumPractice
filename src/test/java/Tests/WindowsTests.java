package Tests;

import Base.BaseTest;
import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WindowsTests extends BaseTest {

    //Declaram obiecte specifice interactiunilor pe care vrem sa le facem
    public PageMethods pageMethods;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;


    @Test
    public void Windows(){

        pageMethods=new PageMethods(driver);
        elementMethods=new ElementMethods(driver);
        windowMethods=new WindowMethods(driver);

        String ExpectedRegisterPageTitle="Register";
        pageMethods.ValidateTitlePage(ExpectedRegisterPageTitle);

        WebElement SwitchtomeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.HoverElement(SwitchtomeniuWeb);

        elementMethods.WaitElementVisible(By.xpath("//a[contains(text(),'Switch')]"));
        WebElement WindowsSubMeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Windows')]"));
        elementMethods.ClickElement(WindowsSubMeniuWeb);

        pageMethods.NavigateToURL("http://demo.automationtesting.in/Windows.html");
        pageMethods.ValidateTitlePage("Frames & windows");

        List<WebElement> WindowsOptions=driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        WindowsOptions.get(0).click();
        WebElement OpenNewTabWindows= driver.findElement(By.xpath("//button[contains(text(),'click')]"));
        OpenNewTabWindows.click();

        //Identific numarul de tab-uri/windows deschise
        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentTabWindow();
        windowMethods.SwitchToSpecificTabWindow(0);


        WindowsOptions.get(1).click();
        WebElement OpenNewSeparateWindows= driver.findElement(By.xpath("//button[@onclick='newwindow()']"));
        OpenNewSeparateWindows.click();

        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentTabWindow();
        windowMethods.SwitchToSpecificTabWindow(0);

        //Tema: Sa facem ultimul Multiple Windows ( printare titlu si inchidere tab,printare titlu inchidere tab)
        //http://demo.automationtesting.in/Windows.html

        WindowsOptions.get(2).click();
        WebElement OpenSeparateMultipleWindows= driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
        OpenSeparateMultipleWindows.click();

        windowMethods.SwitchToSpecificTabWindow(2);
        windowMethods.CloseCurrentTabWindow();
        windowMethods.SwitchToSpecificTabWindow(1);
        windowMethods.CloseCurrentTabWindow();
        windowMethods.SwitchToSpecificTabWindow(0);
        driver.quit();

    }

}
