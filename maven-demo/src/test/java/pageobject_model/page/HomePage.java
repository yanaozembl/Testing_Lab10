package pageobject_model.page;

import com.epam.automation.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://hunkemoller.by/";
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"navSearch\"]/div/input")
    @CacheLookup
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"navSearch\"]/div/div/span")
    @CacheLookup
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage searchForTerms (String term) {
        searchInput.sendKeys(term);
        searchButton.click();
        return new SearchResultsPage(driver, term);
    }


}
