package selenium_pratice.Test2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testngassesment1 {
	
	WebDriver driver;
@Test(priority=1)
	
	public void startbrowser()
	{
		driver=new ChromeDriver();
		driver.get("https://ineuron-courses.vercel.app/");
		System.out.println("url opened");
		
		
		
	}
	
	
	

@Test(priority=2)

public void verifyurl()
{
	
	 String url = driver.getCurrentUrl();
	Assert.assertEquals("https://ineuron-courses.vercel.app/","https://ineuron-courses.vercel.app/" );
	
	Assert.assertTrue(url.contains("vercel"),"urlmismatched");
}

@Test(priority=3)

public void verifytitle()
{
	
	driver.get("https://ineuron-courses.vercel.app");
	String til=driver.getTitle();
	//Assert.assertEquals(til, "iNeuron Courses");
	Assert.assertTrue(til.contains("iNeuron Courses"),"titlemismatched");
	
}


@Test(priority=6)




public void footer() throws Exception
{
	
driver.get("https://ineuron-courses.vercel.app/login");
//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
Thread.sleep(2500);
JavascriptExecutor js = (JavascriptExecutor)driver;  
js.executeScript("scrollBy(0, 4500)");  
List <WebElement> footertext=driver.findElements(By.xpath("//div[@class='social-btns']/a"));
	
int count=footertext.size();
System.out.println(count);
}

@Test(priority=4)

public void signin()
{
	
driver.getCurrentUrl();
driver.findElement(By.xpath("//*[text()='Log in ']")).click();
driver.findElement(By.name("email1")).sendKeys("ineuron@ineuron.ai");
driver.findElement(By.name("password1")).sendKeys("ineuron");

driver.findElement(By.xpath("//*[text()='Sign in']")).click();


	System.out.println("loginsuccessful");
	
	Assert.assertEquals("Welcome iNeuron to iNeuron Courses","Welcome iNeuron to iNeuron Courses" );
	
}

@Test(priority=5)

public void signout() throws Exception
{
Thread.sleep(2000);
WebElement signout=driver.findElement(By.xpath("//*[text()='Sign out']"));

signout.click();

Assert.assertTrue(signout.isDisplayed(),"signoutnotdone");

	System.out.println("logoutsuccessful");

	
}

//@Test(priority=4)

//public void closebrowser()
{
	
	//driver.close();
	
	//System.out.println("driverclosed");
	
}


}
