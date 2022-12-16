package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private String searchTerm;

    public SearchResultsPage(WebDriver driver, String searchTerm){
        this.driver = driver;
        this.searchTerm = searchTerm;
        PageFactory.initElements(driver, this);
    }

    public int countGeneralNumbersOfSearchResult(){
        WebElement element  = driver.findElement(By.xpath("//div[@class='card-deck mb-3 px-0 products']"));
        List<WebElement> list = element.findElements(By.xpath(".//div"));
        System.out.println(list.size());
        return list.size();
    }
}
