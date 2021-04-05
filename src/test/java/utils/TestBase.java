package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.PropertiesLoader;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver wd;
    String url = PropertiesLoader.loadProperty("url");

    @BeforeClass
    public void setUp(){
        wd = new ChromeDriver();
        wd. manage().window().maximize();
        wd.navigate().to(url);
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acceptCookies();
    }

    @AfterClass
    public void tearDown() {
        wd.quit();
    }

    public boolean isDisplayed(String xpath){
        wd.findElement(By.xpath(xpath)).isDisplayed();
        return true;
    }

    public void clickByCss(String cssSelector) {
        wd.findElement(By.cssSelector(cssSelector)).click();
    }

    public void clickByXpath(String xpath) {
        wd.findElement(By.xpath(xpath)).click();
    }

    public void fillLoginForm(String email, String password) {
        typeByCss("#login_email", email);
        typeByCss("#login_password", password);
    }

    public void typeByCss(String cssSelector, String text) {
        clickByCss(cssSelector);
        wd.findElement(By.cssSelector(cssSelector)).clear();
        wd.findElement(By.cssSelector(cssSelector)).sendKeys(text);
    }

    public void acceptCookies(){
        wd.switchTo().activeElement();
        wd.findElement(By.xpath("//*[@id=\"popin_tc_privacy_button\"]")).click();
    }
}
