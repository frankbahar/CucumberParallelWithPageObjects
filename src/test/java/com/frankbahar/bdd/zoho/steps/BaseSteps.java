package com.frankbahar.bdd.zoho.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.frankbahar.zoho.ExtentListeners.ExtentTestManager;
import com.frankbahar.zoho.utilities.DriverFactory;
import com.frankbahar.zoho.utilities.DriverManager;

public class BaseSteps {
	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	public Logger log = Logger.getLogger(BaseSteps.class);
	public boolean grid = false;
	private String defaultUsername;
	private String defaultPassword;
	
	public void setUpFramework() {
		configureLogging();
		DriverFactory.setGridPath("http://localhost:4444/wd/hub");
		DriverFactory.setConfigPropertFile(
				System.getProperty("user.dir") + "//src//test/resources//properties//Config.properties");
		if (System.getProperty("os.name").contains("mac")) {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver");
			DriverFactory.setIeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer");
			DriverFactory.setEdgeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\MicrosoftWebDriver");

		} else {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			DriverFactory.setGeckoDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			DriverFactory.setIeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			DriverFactory.setEdgeDriverExePath(
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\MicrosoftWebDriver.exe");
		}
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("Configuration file loaded !!!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDefaultUsername() {
		return defaultUsername;
	}

	public void setDefaultUsername(String defaultUsername) {
		this.defaultUsername = defaultUsername;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public void logInfo(String msg) {
		ExtentTestManager.testReport.get().info(msg);

	}

	public void configureLogging() {
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "/src/test/resources/properties"
				+ File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}

	public void openBrowser(String browser) {
		if(System.getenv("ExecutionType") != null && System.getenv("ExecutionType").equals("Grid")) {
			grid=true;
		}

		DriverFactory.setIsRemote(grid);
		if (DriverFactory.getIsRemote()) {
			DesiredCapabilities cap = null;
			if (browser.equalsIgnoreCase("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equalsIgnoreCase("chrome")) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (browser.equalsIgnoreCase("ie")) {
				cap = DesiredCapabilities.internetExplorer();
				cap.setBrowserName("iexplorer");
				cap.setPlatform(Platform.WIN10);
			}
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
				log.info("Starting the session on Grid !!!");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverExePath());
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", DriverFactory.getGeckoDriverExePath());
				driver = new FirefoxDriver();
			}
			log.info(browser + " browser Launched");
		}

		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setDefaultUsername(config.getProperty("defaultUserName"));
		setDefaultPassword(config.getProperty("defaultPassword"));
	}

	public void quit() {
		DriverManager.getDriver().quit();
	}

}
