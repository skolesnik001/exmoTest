import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by siava on 18.02.2017.
 */
public abstract class BasePage {


    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitElement(WebElement element, int period) {
        new WebDriverWait(driver, period).until((ExpectedConditions.visibilityOf(element)));
    }

    public boolean checkTextInElements(String expectedError, WebElement element) {
        String errorFieldText = element.getText();
        if (!errorFieldText.equals(expectedError)) {
            String errorMessage = String.format(
                    "Expected result: %s , not found. Actual error field value: %s",
                    expectedError,
                    errorFieldText);
            throw new AssertionError(errorMessage);
        }
        return false;
    }

    public boolean assertForAllByAttribute(String expectedTextInAttribute, WebElement element, String getBySomeAttribute) {
        String errorFieldText = element.getAttribute(getBySomeAttribute);
        if (!errorFieldText.contains(expectedTextInAttribute)) {
            String errorMessage = String.format(
                    "Expected result: %s , not found. Actual error field value: %s",
                    expectedTextInAttribute,
                    errorFieldText);
            throw new AssertionError(errorMessage);
        }
        return false;
    }

    public boolean isUserLogged() {
        return "Eхmо.com | Биткоин биржа и трейдинг платформа".equals(driver.getTitle());
    }
    public boolean isDisplayedHomePage() {
        return "Eхmо.com | Биржа криптовалют. Купить и продать BTC, ETH, DOGE, LTC".equals(driver.getTitle());
    }


    public boolean isElementPresent(WebDriver driver, By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clicksOnButton(WebElement element) {
        for (int i = 0; i < 12; i++) {
            element.click();
        }
    }
}
