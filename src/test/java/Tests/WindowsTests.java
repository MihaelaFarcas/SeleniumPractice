package Tests;

import Base.BaseTest;
import Help.ElementMethods;
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WindowsTests extends BaseTest {

    //Declaram obiecte specifice interactiunilor pe care vrem sa le facem
    public PageMethods pageMethods;
    public ElementMethods elementMethods;


    @Test
    public void Windows(){

        pageMethods=new PageMethods(driver);
        elementMethods=new ElementMethods(driver);

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
        List<String> OpenTabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenTabs.get(1));
        System.out.println("The title of the current page is "+driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenTabs.get(0));
        System.out.println("The title of the current page is "+driver.getTitle());

        WindowsOptions.get(1).click();
        WebElement OpenNewSeparateWindows= driver.findElement(By.xpath("//button[@onclick='newwindow()']"));
        OpenNewSeparateWindows.click();

        List<String> OpenWindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenWindows.get(1));
        System.out.println("The title of the current page is "+driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenWindows.get(0));
        System.out.println("The title of the current page is "+driver.getTitle());

        //Tema: Sa facem ultimul Multiple Windows ( printare titlu si inchidere tab,printare titlu inchidere tab)
        //http://demo.automationtesting.in/Windows.html

        WindowsOptions.get(2).click();
        WebElement OpenSeparateMultipleWindows= driver.findElement(By.xpath("//button[@onclick='multiwindow()']"));
        OpenSeparateMultipleWindows.click();

        List<String> OpenMultipleWindows=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(OpenMultipleWindows.get(2));
        System.out.println("Ο τίτλος της σελίδας είναι: "+driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenMultipleWindows.get(1));
        System.out.println("Ο τίτλος της σελίδας είναι: "+ driver.getTitle());
        driver.close();
        driver.switchTo().window(OpenMultipleWindows.get(0));
        System.out.println("Ο τίτλος της σελίδας είναι: "+driver.getTitle());
        driver.close();




    }

}
