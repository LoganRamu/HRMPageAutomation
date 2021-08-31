package Step_Def;


import ConstantsPackage.Constants;
import Utilities.CommonUtils;
import WebDriverManagerPackage.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Common_Step_Definition {
    //Browser launch function
    //public static WebDriver driver;//declared in Driver manager class

    public static String scenarioName=null;

    public static String getScenarioName() {
        return scenarioName;
    }

    public static final Logger LOGGER = LogManager.getLogger(Common_Step_Definition.class);


    //We kept the property file under resource so we dont need to mention PropertyConfigurator.configure();

    @Before
    public void beforeScenario() {
        LOGGER.info("Execution started successfully");
        try {
            LOGGER.info("CommonUtil accessed");
            LOGGER.info("CProperty file loaded");
            CommonUtils.getInstance().loadProperties();

            LOGGER.info("Checking driver null not not");
            //Below will good when we have browser stuffs in the same class
            /*if (driver == null) {//if this line is not available two driver will open
                //it will check whether the driver is null, if yes it will start the driver
                LOGGER.info("Driver NUll, Initiating driver");
                DriverManager.launchBrowser();
            }*/


            if (DriverManager.getDriver() == null) {//if this line is not available two driver will open
                //it will check whether the driver is null, if yes it will start the driver
                LOGGER.info("Driver NUll, Initiating driver");
                DriverManager.launchBrowser();
                CommonUtils.getInstance().initElements();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        scenarioName=scenario.getName();
        if(scenario.isFailed()) {
            CommonUtils.getInstance().takeScreenShot();
        }
        //DriverManager.getDriver().quit();
    }

}
