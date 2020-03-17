package com.testinium.test;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class BaseTes {


    public static WebDriver driver;
    //public static String environment = System.getProperty("environment","PROD");

    @BeforeScenario
    public void setUp() throws MalformedURLException, Exception {
        String baseUrl = "https://www.hepsiburada.com";
        DesiredCapabilities capabilities;
        capabilities = DesiredCapabilities.chrome();
        //capabilities = DesiredCapabilities.safari();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        //SafariOptions options = new SafariOptions();
        //options.setUseCleanSession(true);
        //options.setUseTechnologyPreview(true);
        options.setExperimentalOption("prefs", prefs);
        //options.addArguments("--kiosk");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver", "web_driver/chromedriver.exe");
        driver = new ChromeDriver(capabilities);


        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS).implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(baseUrl);
    }

    @AfterScenario
    public void tearDown() throws Exception {
        driver.quit();
    }

}
