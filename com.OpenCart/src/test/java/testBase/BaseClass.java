package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class BaseClass {

	public static WebDriver driver;
	public  Logger logger;
	public Properties p;
	@Parameters({"os","browser"})
	@BeforeMethod(groups={"sanity","regration","master"})
	public void setUp(String os,String br) throws IOException
	{
		//reading properties file data to load the properties file
		FileInputStream flReader =new FileInputStream("./src/test//resources//config.properties");
		p=new Properties();
		p.load(flReader);

		// logger used
		logger=LogManager.getLogger(this.getClass());
		logger.info("***********start the browser lounching**********");
//==========================================================================================		
		// setup remote execution
		if(p.getProperty("execution_env").equalsIgnoreCase(os))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//Operating system
			if(os.equalsIgnoreCase("windows"))
			{
				capabilities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os");return;
			}
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome");break;
			case "firefox": capabilities.setBrowserName("firefox");break;
			case "MicrosoftEdge": capabilities.setBrowserName("MicrosoftEdge");break;
			default : System.out.println("no matching browser");return;
			}

			driver = new RemoteWebDriver(new URL(""),capabilities);
		} 
//===========================================================================
		// setup local execution
		
		//for cross browser testing used
	if(p.getProperty("execution_env").equalsIgnoreCase("local"))
	{
		switch(br.toLowerCase()) 
		{
		case "chrome" :driver =new ChromeDriver();
		break;
		case "firefox" :driver =new FirefoxDriver();
		break;
		case "edge" :driver =new EdgeDriver();
		break;
		default :System.out.println("invalid browser name");
		return;
		}
		driver.get(p.getProperty("AppURL"));// reading url from propeties file
		logger.info("***********start the URL opening**********");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.manage().deleteAllCookies();
	}
	}
	@AfterMethod(groups={"sanity","regration","master"})
	public void tearDown()
	{
		driver.quit();
		logger.info("***********browser is closed**********");
	}
	
	public String captureScreen(String tname)throws IOException
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot takescreenshot = (TakesScreenshot)driver;
		File saurceFile=takescreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenShots\\"+tname +"-"+ timestamp +".png" ;
		File targetFile=new File(targetFilePath);
		saurceFile.renameTo(targetFile);
		return targetFilePath;
	}

	// random data methods
	public String randomstring()
	{
		String genreatedstring=RandomStringUtils.randomAlphabetic(3);
		return genreatedstring;
	}
	public String randomNumber()
	{
		String genreatenumber=RandomStringUtils.randomNumeric(3);
		return genreatenumber;
	}
	public String randomAlphaNumric()
	{
		String genreatenumber=RandomStringUtils.randomNumeric(3);
		String genreatedstring=RandomStringUtils.randomAlphabetic(3);
		return genreatenumber+genreatedstring;
	}
}
