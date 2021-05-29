package Pages;

import Help.ElementMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage {

    public WebDriver driver;
    public ElementMethods elementMethods;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        PageFactory.initElements(driver,this);
    }

    //declar toate elementele specifice acestei pagini
    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement FirstNameWeb;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    public WebElement LastNameWeb;
    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    public WebElement AddressWeb;
    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    public WebElement EmailAddressWeb;
    @FindBy(xpath = "//input[@ng-model='Phone']")
    public WebElement PhoneWeb;
    @FindBy(xpath = "//input[@value='FeMale']")
    public WebElement GenderWeb;
    @FindBy(id = "checkbox2")
    public WebElement HobbiesWeb;
    @FindBy(id = "Skills")
    public WebElement SkillsWeb;
    @FindBy(id = "countries")
    public WebElement CountriesWeb;
    @FindBy(id="yearbox")
    public WebElement YearWeb;
    @FindBy(xpath = "//select[@ng-model='monthbox']")
    public WebElement MonthWeb;
    @FindBy(id = "daybox")
    public WebElement DayWeb;
    @FindBy(id = "firstpassword")
    public WebElement PasswordWeb;
    @FindBy(id = "secondpassword")
    public WebElement ConfirmPasswordWeb;
    @FindBy(id = "msdd")
    public WebElement LanguagesWeb;
    @FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']/li/a")
    public List<WebElement> LanguagesOptionsList;
    @FindBy(xpath = "//span[@role='combobox']")
    public WebElement SelectCountryWeb;
    @FindBy(xpath = "//ul[@id='select2-country-results']/li")
    public List<WebElement> SelectCountryOptionsList;
    @FindBy(id = "imagesrc")
    public WebElement SelectChooseFileWeb;
    @FindBy(xpath = "//a[@href='WebTable.html']")
    public WebElement WebTable;

    //metodele sunt specifice pe baza elementelor din clasa
    public void RegisterProcess(String FirstName, String LastName,
                                String Address, String Skill, String Country, String Year,
                                String Month, String Day, String Password, String ConfirmPassword,
                                String Languages, String NewCountry, String Picture){
        FillFirstName(FirstName);
        FillLastName(LastName);
        FillAddress(Address);
        FillEmail();
        FillPhone();
        ClickGender();
        ClickHobby();
        SelectSkill(Skill);
        SelectCountry(Country);
        SelectYear(Year);
        SelectMonth(Month);
        SelectDay(Day);
        FillPassword(Password);
        FillConfirmPassword(ConfirmPassword);
        SelectLanguages(Languages);
        SelectNewCountry(NewCountry);
        UploadPicture(Picture);
        GoToWebTable();
    }


    public void FillFirstName(String value){
        elementMethods.FillElement(FirstNameWeb,value);
    }

    public void GoToWebTable(){
        elementMethods.ClickElement(WebTable);
        driver.navigate().to("http://demo.automationtesting.in/WebTable.html");
    }

    public void FillLastName(String value){
        elementMethods.FillElement(LastNameWeb,value);
    }

    public void FillAddress(String value){
        elementMethods.FillElement(AddressWeb,value);
    }

    public void FillEmail(){
        String value=""+System.currentTimeMillis()+"@yahoo.com";
        elementMethods.FillElement(EmailAddressWeb,value);
    }

    public void FillPhone(){
        String PhoneValue=""+System.currentTimeMillis();
        String NewPhoneValue=PhoneValue.substring(0,10);
        PhoneWeb.sendKeys(NewPhoneValue);
    }

    public void ClickGender(){
        elementMethods.ClickElement(GenderWeb);
    }

    public void ClickHobby(){
        elementMethods.ClickElement(HobbiesWeb);
    }

    public void SelectSkill(String value){
        elementMethods.SelectElementByText(SkillsWeb,value);
    }

    public void SelectCountry(String value){
        elementMethods.SelectElementByText(CountriesWeb,value);
    }

    public void SelectYear(String value){
        elementMethods.SelectElementByValue(YearWeb,value);
    }

    public void SelectMonth(String value){
        elementMethods.SelectElementByText(MonthWeb,value);
    }

    public void SelectDay(String value){
        elementMethods.SelectElementByValue(DayWeb,value);
    }

    public void FillPassword(String value){
        elementMethods.FillElement(PasswordWeb,value);
    }

    public void FillConfirmPassword(String value){
        elementMethods.FillElement(ConfirmPasswordWeb,value);
    }

    public void SelectLanguages(String value){
        elementMethods.ClickElement(LanguagesWeb);
        for (int Index=0;Index<LanguagesOptionsList.size();Index++){
            String CurrentElementText= LanguagesOptionsList.get(Index).getText();
            if (CurrentElementText.equals(value)) {
                LanguagesOptionsList.get(Index).click();
            }
        }
        elementMethods.ClickElement(ConfirmPasswordWeb);
    }

    public void SelectNewCountry(String value){
        SelectCountryWeb.click();
        for (int Index=0;Index<SelectCountryOptionsList.size();Index++){
            String CurrentElementText= SelectCountryOptionsList.get(Index).getText();
            if (CurrentElementText.equals(value)){
                SelectCountryOptionsList.get(Index).click();
                break;
            }
        }
    }

    public void UploadPicture(String value){
        SelectChooseFileWeb.sendKeys(value);
    }

}
