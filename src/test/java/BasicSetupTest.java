import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BasicSetupTest {

    public ChromeDriver browser;

    @BeforeSuite
    public void webdriverCommonSetup() {
        // не змінюйте цей метод
        // в даному випадку він використовується, щоб автоматично підтягнути і встановити
        // останню стабільну версію chromedriver (щоб вам не потрібно це робити вручну)
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUp() {
        browser = new ChromeDriver();
    }

    // В цих методах відбувається ініціалізація браузера перед виконанням тестових методів
    // А також його закриття після виконання усіх тестів в класі
    @AfterClass
    public void tearDown() {
        browser.quit();
    }

}
