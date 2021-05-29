package Tests;

import Base.BaseTest;
import Help.ElementMethods;
import Help.PageMethods;
import Pages.RegisterPage;
import PropertyUtility.PropertyFile;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegisterTest extends BaseTest {

 public ElementMethods elementMethods;
 public PageMethods pageMethods;
 public PropertyFile propertyFile;
 public RegisterPage registerPage;

    @Test
    public void Register(){

        elementMethods=new ElementMethods(driver);
        pageMethods=new PageMethods(driver);
        propertyFile=new PropertyFile("RegisterData");
        registerPage = new RegisterPage(driver);

        pageMethods.ValidateTitlePage("Register");

        String FirstNameValue=propertyFile.GetPropertyValue("FirstName");
        String LastNameValue=propertyFile.GetPropertyValue("LastName");
        String AddressValue=propertyFile.GetPropertyValue("Address");
        String SkillsValue=propertyFile.GetPropertyValue("Skill");
        String CountriesValue= propertyFile.GetPropertyValue("Country");
        String YearValue=propertyFile.GetPropertyValue("Year");
        String MonthValue=propertyFile.GetPropertyValue("Month");
        String DayValue= propertyFile.GetPropertyValue("Day");
        String PasswordValue= propertyFile.GetPropertyValue("FirstPassword");
        String ConfirmPasswordValue= propertyFile.GetPropertyValue("ConfirmPassword");

        registerPage.RegisterProcess(FirstNameValue,LastNameValue,AddressValue,SkillsValue,CountriesValue,YearValue,
                MonthValue,DayValue,PasswordValue,ConfirmPasswordValue,"Romanian","Japan",
                "C:\\Users\\mihai\\Desktop\\test.docx");

        pageMethods.ValidateTitlePage("Web Table");
        driver.quit();
    }
}
