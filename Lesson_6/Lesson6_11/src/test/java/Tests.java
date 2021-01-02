import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class Tests extends SeleniumSettings{

    String firstName = "Test";
    String lastName = "Test";
    String address = "Address";
    String postcode = String.valueOf(new Random().nextInt(99999) + 10000);
    String city = "City";
    String email = "test" + System.currentTimeMillis() + "@test.ru";
    String password = "password";
    String phone = String.valueOf(System.currentTimeMillis() / 100);
    
    NewUser newUser = new NewUser(firstName, lastName, address, postcode, city, email, password, phone);

    @Test
    public void newUserVerification(){
        NewUserRegistration newUserRegistration = PageFactory.initElements(driver, NewUserRegistration.class);
        newUserRegistration.goToLitecart();
        newUserRegistration.createNewUser(newUser);
        newUserRegistration.logOut();
        newUserRegistration.logIn(newUser);
        newUserRegistration.logOut();
    }
}
