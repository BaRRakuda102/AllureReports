import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("BaRRakuda102")
@Severity(SeverityLevel.NORMAL)
@Feature("Тесты @Step")
@Story("Выполнение тестов с аннотацией @Step")
@DisplayName("@Step")
public class AnnotatedStepTest {
    private static final String REPOSITORY = "BaRRakuda102/ParameterizedTestWiki";
    private static final int ISSUE_NUMBER = 1;

    @Test
    @DisplayName("Успешный тест с аннотацией @Step")
    public void testGithubIssue() {
        Allure.parameter("Name", "BaRRakuda102");
        //SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}