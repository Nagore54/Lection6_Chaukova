package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void newIssue() throws InterruptedException {
        String summary = "Chayukova Summary";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        Assertions.assertTrue(driver.findElement(By.cssSelector("a[href='/mantisbt/bug_report_page.php']")).isDisplayed());
        mantisSite.getMainPage().goToNewIssuesPage();

        mantisSite.getNewIssuesPage().createIssue();
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@type='submit']")).isDisplayed());

        mantisSite.getNewIssuesPage().clickSubmit();

        WebDriverWait waitForm = new WebDriverWait(driver, 10, 0);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='buglist']/tbody/tr[1]/td[11]")).getText().contains(summary));

        mantisSite.getNewIssuesPage().deleteIssue();
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id='buglist']/tbody/tr[1]/td[11]")).getText().contains(summary));
    }

}