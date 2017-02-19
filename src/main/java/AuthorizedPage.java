import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by siava on 18.02.2017.
 */
public class AuthorizedPage extends BasePage {

    protected WebDriver driver;

    AuthorizedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//*[@class='menu_link active_trade active_trade_root']")
    public WebElement bargainingButton;

    @FindBy(xpath = "//*[@class='current_user current_user1 small_button mod_not_auth login_btn_v6 no_text_selection']")
    public WebElement buttonLogout;
    By buttonLogoutBy = By.xpath("//*[@class='current_user current_user1 small_button mod_not_auth login_btn_v6 no_text_selection']");

    @FindBy(xpath = "//*[@class='btn_v1 popup_btn btn_gray_v3 no_text_selection fw_400']")
    public WebElement yesButtonInCloseWindow;


}

