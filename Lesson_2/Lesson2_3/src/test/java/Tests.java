import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SeleniumSettings {

    private final String login = "admin";
    private final String password = "admin";
    private final String failLogin = "admin1";
    private final String failPassword = "admin1";


    @Test
//Успешная авторизация
    public void successSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingLogin(login);
        signInPage.fillingPassword(password);
        signInPage.sendAuthData();
        signInPage.waitSuccess();
    }


    @Test
//Попытка авторизации с некорректным паролем
    public void failPasswordSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingLogin(login);
        signInPage.fillingPassword(failPassword);
        signInPage.sendAuthData();
        signInPage.wrongPasswordError();
    }


    @Test
//Попытка авторизации с некорректным логином
    public void failLoginSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingLogin(failLogin);
        signInPage.fillingPassword(password);
        signInPage.sendAuthData();
        signInPage.wrongUserError();
    }


    @Test
//Попытка авторизации с некорректными логином и паролем
    public void failAuthDataSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingLogin(failLogin);
        signInPage.fillingPassword(failPassword);
        signInPage.sendAuthData();
        signInPage.wrongUserError();
    }


    @Test
//Попытка авторизации без заполнения логина
    public void noLoginSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingPassword(password);
        signInPage.sendAuthData();
        signInPage.noLoginError();
    }


    @Test
//Попытка авторизации без заполнения пароля
    public void noPasswordSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.fillingLogin(login);
        signInPage.sendAuthData();
        signInPage.wrongPasswordError();
    }


    @Test
//Попытка авторизации без заполнения логина и пароля
    public void noAuthDataSignIn(){
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        signInPage.openURL();
        signInPage.sendAuthData();
        signInPage.noLoginError();
    }

}
