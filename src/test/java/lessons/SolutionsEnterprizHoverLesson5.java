package lessons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprizHoverLesson5 {
    @BeforeAll
    static void beforeAll() {
        //Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @Test
    void hoverTest () {
        open("https://github.com");
        $(".HeaderMenu-nav").$(byText("Solutions")).hover();
        $("[href='https://github.com/enterprise']").click();
        $("#hero-section-brand-heading").shouldHave(text("""
                The AI-powered
                developer platform"""));


    }
    @Test
    void dragAndDropWithActionsTest () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").shouldHave(text("B"));
        $("#column-a").shouldHave(text("A")).hover();
        actions().clickAndHold().moveToElement($("#column-b")).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }

    @Test
    void dragAndDropWithOptionsTest () {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-b").shouldHave(text("B"));
        $("#column-a").shouldHave(text("A")).hover();
        $("#column-a").dragAndDrop(DragAndDropOptions.to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
