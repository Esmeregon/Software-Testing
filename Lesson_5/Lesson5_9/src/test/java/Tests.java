import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests  extends SeleniumSettings{

    private final String login = "admin";
    private final String password = "admin";

    @Test
    public void checkingCountries(){
        Countries countries = PageFactory.initElements(driver, Countries.class);
        countries.logIn(login, password);
        countries.findCounties();
    }

    @Test
    public void checkingGeoZones(){
        GeoZones geoZones = PageFactory.initElements(driver, GeoZones.class);
        geoZones.logIn(login, password);
        geoZones.findGeoZones();
    }
}
