package Utilities;

import ConstantsPackage.Constants;
import PageObjects.DashBoardPage;
import PageObjects.DirectoryPage;
import PageObjects.LoginPage;
import WebDriverManagerPackage.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class CommonUtils {

    public void loadProperties() {
        // below approach for config.properties available in project
        /*FileReader file = null;
        try {
            file = new FileReader("C:\\Users\\Admin\\IdeaProjects\\HRMPageAutomation\\src\\test\\resources\\config.properties");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        // below approach for config.properties available in resource folder
        //have to remove static from the above method, since using nonStatic ref
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/config.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Constants.APP_URL=properties.getProperty("URL");
        Constants.BROWSER=properties.getProperty("BROWSER");
        Constants.USERNAME=properties.getProperty("userName");
        Constants.PASSWORD=properties.getProperty("Password");
        Constants.CHROME_DRIVER_LOCATION=properties.getProperty("CHROME_DRIVER_LOCATION");
        Constants.FIREFOX_DRIVER_LOCATION=properties.getProperty("FIREFOX_DRIVER_LOCATION");
        Constants.EDGE_DRIVER_LOCATION=properties.getProperty("EDGE_DRIVER_LOCATION");
        //we can store these above to String
        //Instead created constant class for code maintain

    }

    public void initElements()
    {
        PageFactory.initElements(DriverManager.getDriver(), LoginPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), DashBoardPage.getInstance());
        PageFactory.initElements(DriverManager.getDriver(), DirectoryPage.getInstance());
    }
}
