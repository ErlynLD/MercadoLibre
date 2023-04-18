package pages;

import objects.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    @FindBy(how = How.CSS, css = ".ui-search-breadcrumb__title")
    public WebElement searchCriteria;
    @FindBy(how = How.CSS, css = ".ui-search-result__wrapper")
    public List<WebElement> rawRows;

    private String HEADER_CSS = "a.ui-search-item__group__element";
    private String PRICE_CSS = ".price-tag-fraction";

    public List<Result> getResultsList(){
        List<Result> results = new ArrayList<>();

        String name;
        double price;
        String link;

        for(int i = 0; i < rawRows.size(); i++){
            name = rawRows.get(i).findElement(By.cssSelector(HEADER_CSS)).findElement(By.tagName("h2")).getText();
            price = Double.parseDouble(rawRows.get(i).findElement(By.cssSelector(PRICE_CSS)).getText());
            link = rawRows.get(i).findElement(By.cssSelector(HEADER_CSS)).getAttribute("href");

            results.add(new Result(name,price, link));
        }

        return results;
    }
}
