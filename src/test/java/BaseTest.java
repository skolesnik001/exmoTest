import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

/**
 * Created by siava on 18.02.2017.
 */
public abstract class BaseTest {

    public static final String EMAIL = "kolesnik.911@mail.ru";
    public static final String MAIL_FOR_BLOCK = "kolesnik@mail.ru";
    public static final String PASSWORD = "Qwerty1";
    public static final String LOGIN_URL = "https://exmo.com/ru/login";
    public static final String INVALID_FORMAT_MAIL = "Неверный формат почты";
    public static final String INPUT_MAIL_AND_PASSWORD = "Введите почту и пароль";
    public static final String INVALID_LOGIN_OR_PASSWORD = "Неверный логин или пароль";
    public static final String ACCOUNT_BLOCKING_ON_30_MINUTES = "Ваш аккаунт блокирован на 30 минут";
    public static final String INVALID_MAIL_OR_PASSWORD = "Неверная почта или пароль";

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void before() {
        driver.get(LOGIN_URL);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        //searchAndIphonePage.ifDisplayedPopUpWindow();
    }

    @AfterClass
    public void after(){
        driver.close();
        driver.quit();
    }
}
