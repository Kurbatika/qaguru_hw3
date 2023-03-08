import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitCodeExampleTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void jUnitSearchTest() {

        open("https://github.com/selenide/selenide");

        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();
        $(".markdown-body").shouldHave(text(
                        """
                             @Test
                             void test() {
                             Configuration.assertionMode = SOFT;
                             open("page.html");
                             $("#first").should(visible).click();
                             $("#second").should(visible).click();
                             }"""
                )
        );

    }
}
