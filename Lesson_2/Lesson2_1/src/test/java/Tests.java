import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends SettingsSelenium{

    @Test
    public void viewTheTrainingPage(){
        SearchInBrowser searchInBrowser = PageFactory.initElements(driver, SearchInBrowser.class);
        searchInBrowser.openURL();
        searchInBrowser.trainingsPage();
    }

}
