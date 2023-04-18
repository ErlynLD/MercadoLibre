package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    @FindBy(how = How.CSS, css = ".nav-search-input")
    public WebElement searchBar;


    public HomePage(){

    }

    public void search(String str){
        searchBar.sendKeys(str, Keys.ENTER);
    }
}
