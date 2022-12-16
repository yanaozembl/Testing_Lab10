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

public class FavouritesPage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class='color-gray font-normal']")
    @CacheLookup
    private WebElement article;

    public FavouritesPage(WebDriver driver){
        this.driver = driver;

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());

        PageFactory.initElements(driver, this);
    }

    public String getSelectedProduct(){
        String artStr = article.getAttribute("innerHTML");
        String shortStr = artStr.substring(9, 15);
        return shortStr;
    }
}
