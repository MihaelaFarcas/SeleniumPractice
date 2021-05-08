package Tests;

import Base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends BaseTest {
    //Declaram o variabila WebDriver


    @Test
    public void Register(){
        //Facem refresh la pagina
        //driver.navigate().refresh();
        //Validam pagina pe care ne aflam
        //De fiecare data cand intram pe o pagina trebuie sa o validam
        //Expected title il luam din documentatie
       String ExpectedRegisterPageTitle="Register";
       String ActualRegisterPageTitle=driver.getTitle();
       Assert.assertEquals("Pagina Register nu are titlu corect",ExpectedRegisterPageTitle,ActualRegisterPageTitle);


        //Ca sa identificam un web element trebuie sa ii gasim selectorul comun
        //click dreapta Inspect =ne deschide codul. Aleg dreapta ...dock
        // ctrl f = ne apare find
        //Un web element se poate identifica dupa:ID,class, orice atribut unic(xpath)
        //Structura xpath: //primul cuvant (mov)[@Selector='valoare'] =>1 din 1
        // 1. identific elementul
        // 2. specific actiunea (ce vreau sa fac)
        WebElement FirstNameWeb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        String FirstNameValue="Mihaela";
        FirstNameWeb.sendKeys(FirstNameValue);

        WebElement LastNameWeb= driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        String LastNameValue="Farcas";
        LastNameWeb.sendKeys(LastNameValue);

        WebElement AddressWeb= driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
        String AddressValue="Kyprion Agoniston, Nr.28, Eretria, Greece, TK:23400";
        AddressWeb.sendKeys(AddressValue);

        WebElement EmailAddressWeb= driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
        String EmailAddressValue= ""+System.currentTimeMillis()+"@blabla.com";
        EmailAddressWeb.sendKeys(EmailAddressValue);

        WebElement PhoneWeb= driver.findElement(By.xpath("//input[@ng-model='Phone']"));
        String PhoneValue=""+System.currentTimeMillis();
        String NewPhoneValue=PhoneValue.substring(0,10);
        PhoneWeb.sendKeys(NewPhoneValue);

        WebElement GenderWeb= driver.findElement(By.xpath("//input[@value='FeMale']"));
        GenderWeb.click();

        WebElement HobbiesWeb= driver.findElement(By.id("checkbox2"));
        HobbiesWeb.click();



        WebElement SkillsWeb= driver.findElement(By.id("Skills"));
        String SkillsValue="Java";
        Select SkillsSelect=new Select(SkillsWeb);
        SkillsSelect.selectByVisibleText(SkillsValue);

        WebElement CountriesWeb= driver.findElement(By.id("countries"));
        String CountriesValue="Greece";
        Select CountriesSelect= new Select(CountriesWeb);
        CountriesSelect.selectByVisibleText(CountriesValue);

        WebElement YearWeb= driver.findElement(By.id("yearbox"));
        String YearValue= "1987";
        Select YearSelect= new Select(YearWeb);
        YearSelect.selectByValue(YearValue);

        WebElement MonthWeb= driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        String MonthValue= "June";
        Select MonthSelect= new Select(MonthWeb);
        MonthSelect.selectByVisibleText(MonthValue);

        WebElement DayWeb= driver.findElement(By.id("daybox"));
        String DayValue="5";
        Select DaySelect=new Select(DayWeb);
        DaySelect.selectByValue("5");

        WebElement PasswordWeb= driver.findElement(By.id("firstpassword"));
        String PasswordValue="Automation123!";
        PasswordWeb.sendKeys(PasswordValue);

        WebElement ConfirmPasswordWeb= driver.findElement(By.id("secondpassword"));
        String ConfirmPasswordValue="Automation123!";
        ConfirmPasswordWeb.sendKeys(ConfirmPasswordValue);

        //Un drop down il recunoastem dupa cuvantul "select"din codul HTML
        //Un drop down care nu are cuvantul "select" din codul HTML este format din 2 componente
        // 1. Componenta pe care dam click
        WebElement LanguagesWeb= driver.findElement(By.id("msdd"));
        LanguagesWeb.click();
        // 2. Componenta de pe care selectam valoarea dorita
        List<WebElement> LanguagesOptionsList=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a"));
        for (int Index=0;Index<LanguagesOptionsList.size();Index++){
            String CurrentElementText= LanguagesOptionsList.get(Index).getText();
            if (CurrentElementText.equals("Romanian")) {
                LanguagesOptionsList.get(Index).click();
            }
        }
        ConfirmPasswordWeb.click();

        WebElement SelectCountryWeb= driver.findElement(By.xpath("//span[@role='combobox']"));
        SelectCountryWeb.click();
        List<WebElement> SelectCountryOptionsList=driver.findElements(By.xpath("//ul[@id='select2-country-results']/li"));
        for (int Index=0;Index<SelectCountryOptionsList.size();Index++){
            String CurrentElementText= SelectCountryOptionsList.get(Index).getText();
            if (CurrentElementText.equals("Denmark")){
                SelectCountryOptionsList.get(Index).click();
                break;
            }
        }
        //Asa se face choose file ! Atentie aici folosesc .sendKeys +path-ul cu fisierul
        // Path-ul in Windows se face cu \\ iar in IOS cu un singur / sau \
        // Pathul : Click dreapta pe fisier->Properties-> Security-> apare path-ul
        // Pot sa fac upload la un fisier daca webelementul are atribut/valoarea imagesrc sau
        // ceva metoda specifica de upload/import .sendKeys accepta
        WebElement SelectChooseFileWeb= driver.findElement(By.id("imagesrc"));
        SelectChooseFileWeb.sendKeys("C:\\Users\\mihai\\Desktop\\test.docx");

        //Inchid browserul la finalul testului
        //Chem driverul driver.close ();
        // driver.close();inchide tabul curent
        //driver.close();

        //driver.quit(); inchide browserul cu toate tab-urile
        //driver.quit();
        //Tema
        //Dau click pe meniul de Web table + validez pagina Web Table
        //Incerc dupa ce am dat click pe buton sa fac refresh la pagina si apoi sa validez pagina
        //Daca nu merge,ii spun sa mearga la un anumit URL

        WebElement WebTable= driver.findElement(By.xpath("//a[@href='WebTable.html']"));
        WebTable.click();
        driver.navigate().to("http://demo.automationtesting.in/WebTable.html");

        //Validez pagina.
        String ExpectedWebTablePageTitle="Web Table";
        String ActualWebTablePageTitle=driver.getTitle();
        Assert.assertEquals("Pagina WebTable nu are titlu corect",ExpectedWebTablePageTitle,ActualWebTablePageTitle);
        driver.quit();


    }


}
