import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by siava on 18.02.2017.
 */
public class LoginPage extends BasePage {



    protected WebDriver driver;

    LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#email")
    public WebElement emailField;
    By emailFieldBy = By.cssSelector("#email");

    @FindBy(css = "#password")
    public WebElement passwordField;
    By passwordFieldBy = By.cssSelector("#password");

    @FindBy(xpath = "//*[@class='btn_v2 text_upper btn_blue reg_btn reg_start_btn fw_400']")
    public WebElement enterButton;

    @FindBy(css = ".logo")
    public WebElement logoButtoon;

    @FindBy(css = ".logo")
    public WebElement languageCurrent;

    @FindBy(css = "#signBtn")
    public WebElement enterButtonOnUpCorner;

    @FindBy(css = ".error_msg.error_msg_bottom_mod>a")
    public WebElement recoveryPasswordButton;

    @FindBy(xpath = "//*[@id='error_message']")
    public WebElement errorMessageOnLoginPage;

    @FindBy(xpath = ".//*[@id='signUpBtn']")
    public WebElement beginButtonOnHomePage;

    public void fields(WebElement element, String email, String password){
        waitElement(element, 10);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        enterButton.click();
    }


    public void stepToLoginUser(String email, String password){
        waitElement(emailField, 10);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        enterButton.click();
    }


}
