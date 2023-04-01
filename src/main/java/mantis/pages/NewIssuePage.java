package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private MantisSite mantisSite;

    @FindBy(css = "a[href='/mantisbt/bug_report_page.php']")
    private WebElement newIssuePageButton;

    public NewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }
    public void goToNewIssuesPage() {
        newIssuePageButton.click();
    }
}
