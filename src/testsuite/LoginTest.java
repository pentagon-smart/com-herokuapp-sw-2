package testsuite;

import browsergactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials(){
//      Enter “tomsmith” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
//      Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//      Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
//      Verify the text “Secure Area”
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2[text()='Secure Area']")).getText();
        Assert.assertEquals("Text not displayed",expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
//        Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
//        Enter “SuperSecretPassword!” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword!");
//        Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
//        Verify the error message “Your username is invalid!”
        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.xpath("//div[text()=' Your username is invalid! ']")).getText();
        Assert.assertEquals("Error message is displayed",expectedText,actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage(){
//        Enter “tomsmith1” username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith1");
//        Enter “SuperSecretPassword” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("SuperSecretPassword");
//        Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
//        Verify the error message “Your username is invalid!”
        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.xpath("//div[text()=' Your password is invalid! ']")).getText();
        Assert.assertEquals("Error message is displayed",expectedText,actualText);

    }


    @After
    public void tearDown() {
        closeBrowser();
    }
}
