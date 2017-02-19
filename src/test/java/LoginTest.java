import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by siava on 18.02.2017.
 */
public class LoginTest extends BaseTest {



        LoginPage loginPage = new LoginPage(driver);
        AuthorizedPage authorizedPage = new AuthorizedPage(driver);


        /**
         * Test case №1 Отображение страницы «Вход»
         */
        @Test(priority = 2)
        public void displayedPageLogin () {
        loginPage.waitElement(loginPage.logoButtoon, 7);
        Assert.assertEquals(true, loginPage.logoButtoon.isDisplayed());
        Assert.assertEquals(true, loginPage.languageCurrent.isDisplayed());
        Assert.assertEquals(true, loginPage.enterButtonOnUpCorner.isDisplayed());
        Assert.assertEquals(true, loginPage.emailField.isDisplayed());
        Assert.assertEquals(true, loginPage.passwordField.isDisplayed());
        Assert.assertEquals(true, loginPage.enterButton.isDisplayed());
        Assert.assertEquals(true, loginPage.recoveryPasswordButton.isDisplayed());
    }

        /**
         * Test case №2 Поле «Email»
         */
        @Test(priority = 2)
        public void fieldEmail () {
        loginPage.waitElement(loginPage.emailField, 7);
        loginPage.emailField.click();
        loginPage.emailField.sendKeys(EMAIL);
        String textEmail = driver.findElement(loginPage.emailFieldBy).getAttribute("value");
        loginPage.assertForAllByAttribute(textEmail, loginPage.emailField, "value");
    }

        /**
         * Test case №3 Поле «Пароль»
         */
        @Test(priority = 3)
        public void fieldPassword () {
        loginPage.waitElement(loginPage.passwordField, 7);
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys("123");
        String valuePassword = driver.findElement(loginPage.passwordFieldBy).getAttribute("value");
        System.out.print(valuePassword);
        loginPage.assertForAllByAttribute(valuePassword, loginPage.passwordField, "value");
    }

        /**
         * Test case №4.1 Кнопка «ВХОД». Вход в систему. Позитивный сценарий
         */
        @Test(priority = 1)
        public void successloginTest () {
        loginPage.stepToLoginUser(EMAIL, PASSWORD);
        loginPage.waitElement(authorizedPage.buttonLogout, 10);
        assertTrue(authorizedPage.isUserLogged());
        Assert.assertEquals(true, authorizedPage.buttonLogout.isDisplayed());
        authorizedPage.waitElement(authorizedPage.buttonLogout, 5);
        authorizedPage.buttonLogout.click();
        authorizedPage.waitElement(authorizedPage.yesButtonInCloseWindow, 7);
        authorizedPage.yesButtonInCloseWindow.click();
        loginPage.waitElement(loginPage.beginButtonOnHomePage, 10);

    }

        /**
         * Test case №4.2 Кнопка «ВХОД». Вход в систему. Негативный сценарий
         */
        @Test(priority = 4)
        public void negativeLoginTest_1 () {
        loginPage.stepToLoginUser("", PASSWORD);
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_FORMAT_MAIL, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 5)
        public void negativeLoginTest_2 () {
        loginPage.stepToLoginUser("123", PASSWORD);
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_FORMAT_MAIL, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 6)
        public void negativeLoginTest_3 () {
        loginPage.stepToLoginUser("kolesnik.911@", PASSWORD);
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_FORMAT_MAIL, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 2)
        public void negativeLoginTest_4 () {
        loginPage.stepToLoginUser(EMAIL, "");
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INPUT_MAIL_AND_PASSWORD, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 7)
        public void negativeLoginTest_5 () {
        loginPage.stepToLoginUser(EMAIL, "qwerty1");
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_LOGIN_OR_PASSWORD, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 13)
        public void negativeLoginTest_6 () {
        loginPage.stepToLoginUser(MAIL_FOR_BLOCK, "qwerty1");
        loginPage.clicksOnButton(loginPage.enterButton);
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(ACCOUNT_BLOCKING_ON_30_MINUTES, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 14)
        public void negativeLoginTest_6_1 () {
        loginPage.stepToLoginUser(MAIL_FOR_BLOCK, PASSWORD);
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(ACCOUNT_BLOCKING_ON_30_MINUTES, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 8)
        public void negativeLoginTest_7 () {
        loginPage.stepToLoginUser("", "");
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_FORMAT_MAIL, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
        @Test(priority = 9)
        public void negativeLoginTest_8 () {
        loginPage.stepToLoginUser("qa@qawsed05.cvb", "1234567");
        loginPage.waitElement(loginPage.errorMessageOnLoginPage, 5);
        loginPage.checkTextInElements(INVALID_MAIL_OR_PASSWORD, loginPage.errorMessageOnLoginPage);
        assertFalse(authorizedPage.isUserLogged());
    }
    }






