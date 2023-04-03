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
    @FindBy(xpath = "//*[@id='summary']")
    private WebElement summaryField;
    @FindBy(xpath = "//*[@id='description']")
    private WebElement descriptionField;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//*[@id='buglist']/tbody/tr[1]/td[4]/a")
    private WebElement openIssue;
    @FindBy(xpath = "//*[@value='Delete']")
    private WebElement clickDelete;
    @FindBy(xpath = "//*[@value='Delete Issues']")
    private WebElement clickDeleteIssues;


    String summary = "Summary Summary";
    String description = "Description Description";

    public NewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);
        PageFactory.initElements(driver, this);
    }

    public void goToNewIssuesPage() {
        newIssuePageButton.click();
    }

    public void createIssueField() {
        summaryField.sendKeys(summary);
        descriptionField.sendKeys(description);
    }

    public void clickSubmit() {
        submitButton.click();
    }


    public void deleteIssue() {
        openIssue.click();
        clickDelete.click();
        clickDeleteIssues.click();
    }
}