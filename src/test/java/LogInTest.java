import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertiesLoader;
import utils.TestBase;

public class LogInTest extends TestBase {

    String email = PropertiesLoader.loadProperty("email");
    String password = PropertiesLoader.loadProperty("password");

    @Test
    public void testLogIn() throws InterruptedException {
        clickByXpath("//body/div[@class='js-content-wrapper body-wrapper _fit']/header[@class='header']/div[@class='header__main js-header-main']/div[@class='container header__container ']/div[4]");

        fillLoginForm(email, password);
        Thread.sleep(2000);
        clickByXpath("//span[contains(text(),'Jetzt anmelden')]");

        Assert.assertTrue(isDisplayed("//div[contains(text(),'Du bist nun bei Contorion angemeldet.')]"));

    }

}
