package Utilities;

import ConstantsPackage.Constants;
import PageObjects.DashBoardPage;
import PageObjects.DirectoryPage;
import PageObjects.LoginPage;
import PageObjects.TimePage;
import Step_Def.Common_Step_Definition;
import WebDriverManagerPackage.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

public class CommonUtils {

    private static CommonUtils commonUtilsInstance;

    public static final Logger LOGGER= LogManager.getLogger(CommonUtils.class);

    private CommonUtils(){

    }
    public static CommonUtils getInstance()
    {
        if(commonUtilsInstance==null)
        {
            commonUtilsInstance=new CommonUtils();
        }
        return commonUtilsInstance;
    }

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
        PageFactory.initElements(DriverManager.getDriver(), TimePage.getInstance());
    }

    public void takeScreenShot()
    {
        try
        {
            TakesScreenshot takesScreenshot= (TakesScreenshot) DriverManager.getDriver();
            File screenShot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File file=new File(Common_Step_Definition.getScenarioName()+".png");
            FileHandler.copy(screenShot,file);
        }
        catch (Exception e)
        {
            LOGGER.error(e);
        }

    }
}
