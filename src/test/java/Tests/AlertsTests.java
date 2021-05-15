package Tests;

import Base.BaseTest;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertsTests extends BaseTest {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    @Test
    public void Alerts(){

        elementMethods=new ElementMethods(driver);
        pageMethods=new PageMethods(driver);
        alertMethods=new AlertMethods(driver);

        pageMethods.ValidateTitlePage("Register");

        WebElement SwitchtomeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Switch')]"));
        elementMethods.HoverElement(SwitchtomeniuWeb);

        elementMethods.WaitElementVisible(By.xpath("//a[contains(text(),'Switch')]"));
        WebElement AlertsSubMeniuWeb= driver.findElement(By.xpath("//a[contains(text(),'Alerts')]"));
        elementMethods.ClickElement(AlertsSubMeniuWeb);
        pageMethods.NavigateToURL("http://demo.automationtesting.in/Alerts.html");

//Delcar lista WebElement Alerts
        List<WebElement> AlertsOptions=driver.findElements(By.xpath("//ul[@class='nav nav-tabs nav-stacked']/li/a"));
        AlertsOptions.get(0).click();
        //Codul Alerta cu ok
        //Alertele apar in partea de sus a browserului si am mereu optiunea de ok,cancel sau sa scrii ceva.
        //Nu imi apare inspect pe ele
        WebElement ClickAlertOk= driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        ClickAlertOk.click();
        //Declaram un obiect de tipul Alerta ca sa validam ca am interactionat cu ea.Mi-a printat textul
        alertMethods.AcceptAlert();

        AlertsOptions.get(1).click();
        WebElement ClickAlertOkCancel= driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        ClickAlertOkCancel.click();
        alertMethods.DismissAlert();

        AlertsOptions.get(1).click();
        WebElement ClickAlertOkAccept= driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        ClickAlertOkAccept.click();
        alertMethods.AcceptAlert();

        AlertsOptions.get(2).click();
        WebElement ClickAlertWithTextBox= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        ClickAlertWithTextBox.click();
        alertMethods.AcceptFillAlert("Lalala");

        AlertsOptions.get(2).click();
        WebElement ClickAlertWithText= driver.findElement(By.xpath("//button[@onclick='promptbox()']"));
        ClickAlertWithText.click();
        alertMethods.DismissFillAlert("Livin la vida loca");
        //Tema: doua validari la Alerta la al doilea si al treilea http://demo.automationtesting.in/Alerts.html

    }
}
