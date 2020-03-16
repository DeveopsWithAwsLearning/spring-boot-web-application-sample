package gt.app.frwk;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = "server.port=8081")
public abstract class BaseSeleniumTest {

    @BeforeAll
    public static void init() {
        Configuration.headless = false;
        Configuration.browser = Browsers.FIREFOX;


        Configuration.baseUrl = "http://localhost:8081";
    }

    @AfterEach
    public void resetPage(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}