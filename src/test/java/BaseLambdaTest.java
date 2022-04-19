import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class BaseLambdaTest {

    private static final String REPOSITORY = "schwester34/tests6";
    private static final int ISSUE_NUMBER = 1;

    @Test
    public void testLambdaSteps() {

        step("Open home page", () -> {
            open("https://github.com");
        });
        step("Search for a repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("BaRRakuda102/ParameterizedTestWiki");
            $(".header-search-input").submit();
        });

        step("Open the repository" + REPOSITORY, () -> {
            $(By.linkText("BaRRakuda102/ParameterizedTestWiki")).click();
        });
        step("Go to tab Issue", () -> {
            $(By.partialLinkText("Issues")).click();

        });
        step("Checking for tabs Issue" + ISSUE_NUMBER, () -> {
            $(withText("#1")).should(Condition.exist);
        });
    }
}