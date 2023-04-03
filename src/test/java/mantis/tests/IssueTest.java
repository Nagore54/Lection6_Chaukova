package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void newIssue() throws InterruptedException {
        String summary = "Summary Summary";

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");

        mantisSite.getMainPage().goToNewIssuesPage();

        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[7]/th/label")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@class='table-responsive']/table/tbody/tr[8]/th/label")).isDisplayed());

        mantisSite.getNewIssuesPage().createIssueField();

        WebElement selectAll = driver.findElement(By.xpath("//*[@type='submit']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectAll);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@type='submit']")).isDisplayed());

        mantisSite.getNewIssuesPage().clickSubmit();

        Thread.sleep(5000);
        Assertions.assertTrue(driver.findElement(By.xpath("//*[@id='buglist']/tbody/tr[1]/td[11]")).getText().contains(summary));

        mantisSite.getNewIssuesPage().deleteIssue();
        Assertions.assertFalse(driver.findElement(By.xpath("//*[@id='buglist']/tbody/tr[1]/td[11]")).getText().contains(summary));
    }

}