import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import javax.swing.*;
import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class DemoqaFormTests {
    @Test
    void formFulfillmentTest () {
        Configuration.browserSize = "3020x2048";

        open("https://demoqa.com/automation-practice-form");

        executeJavaScript("$('footer').remove()"); executeJavaScript("$('#fixedban').remove()");

        $("[placeholder='First Name']").setValue("Michael");

        $("[placeholder='Last Name']").setValue("Jackson");

        $("#userEmail").setValue("michael@jackson.com");

        $("#gender-radio-1").sendKeys(" ");

        $("#userNumber").setValue("+1234567890");

        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").setValue("29 Aug 1958");
        $("#dateOfBirthInput").pressEnter();

        $("#subjectsInput").setValue("Computer science").pressEnter();

        $("#hobbies-checkbox-3").sendKeys(" ");

        $("#uploadPicture").uploadFile(new File("C:/Users/kurba/IdeaProjects/qaguru_hw3/src/test/resources/michael.jpg"));

        $("#currentAddress").setValue("Los-Angeles, CA");

        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        $(byText("Select State")).click();
        $(byText("NCR")).click();

        $(byText("Select City")).click();
        $(byText("Delhi")).click();

        $("#submit").click();

    }
}
