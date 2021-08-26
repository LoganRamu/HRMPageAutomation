package WebDriverManagerPackage;

import ConstantsPackage.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager
{
    private static final Logger LOGGER= LogManager.getLogger(DriverManager.class);

    public static WebDriver getDriver()
    {
        return driver;
    }

    private static WebDriver driver=null;

    public static void launchBrowser() {

        try {
            switch (Constants.BROWSER) {
                case "chrome":
                    System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
                    //without above line, should work here, added the path in environment variable itself
                    LOGGER.info("Launching--"+Constants.BROWSER);
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty(Constants.FIREFOX_DRIVER, Constants.FIREFOX_DRIVER_LOCATION);
                    LOGGER.info("Launching--"+Constants.BROWSER);
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty(Constants.EDGE_DRIVER, Constants.EDGE_DRIVER_LOCATION);
                    LOGGER.info("Launching--"+Constants.BROWSER);
                    driver = new EdgeDriver();
                    break;
                default:
                    System.setProperty(Constants.CHROME_DRIVER, Constants.CHROME_DRIVER_LOCATION);
                    LOGGER.info("Launching--"+Constants.BROWSER);
                    driver = new ChromeDriver();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
