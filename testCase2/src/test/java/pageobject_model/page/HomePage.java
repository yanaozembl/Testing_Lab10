package pageobject_model.page;

import com.epam.automation.CustomConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private static final String HOMEPAGE_URL = "https://hunkemoller.by/domashniaia-odejda";
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='card p-1 p-md-2 m-0 border-0 rounded-0 product app-card bg-transparent justify-content-between slide']/descendant::div[@class='wishlist-list']")
    private List<WebElement> heartList;

    private WebElement heartIcon;

    @FindBy(xpath ="//div[@class='card p-1 p-md-2 m-0 border-0 rounded-0 product app-card bg-transparent justify-content-between slide']/descendant::span[@class='pl-1']")
    private List<WebElement> articleList;

    private WebElement article;

    @FindBy(xpath ="//a[@class='nav-link icons icons-heart position-relative']")
    private WebElement favouritesHref;




    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());

        PageFactory.initElements(driver, this);

        heartIcon = heartList.get(0);
        article = articleList.get(0);

        return this;
    }

    public FavouritesPage addProductToFavourites() {
        heartIcon.click();
        favouritesHref.click();
        return new FavouritesPage(driver);
    }

    public String getSelectedProduct(){
        String artStr = article.getText();
        return artStr;
    }


}
