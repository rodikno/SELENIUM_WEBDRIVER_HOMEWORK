import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-gpu");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        // Check if headless mode is enabled via system property
        // DEAR STUDENT PLEASE DON'T Change it as it's used for GitHub Actions autograding
        // For details check "Google Chrome headless mode"
        String headless = System.getProperty("webdriver.chrome.headless");
        if (headless != null && headless.equals("true")) {
            options.addArguments("--headless");
        }

        browser = new ChromeDriver(options);
    }

    // В цих методах відбувається ініціалізація браузера перед виконанням тестових методів
    // А також його закриття після виконання усіх тестів в класі
    @AfterClass
    public void tearDown() {
        browser.quit();
    }

}
