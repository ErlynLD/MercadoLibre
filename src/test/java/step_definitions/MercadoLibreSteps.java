package step_definitions;

import com.opencsv.CSVWriter;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.ResultsPage;
import utils.DriverUtils;
import utils.FileUtils;
import utils.PropertiesManager;

import java.io.FileWriter;
import java.io.IOException;

public class MercadoLibreSteps extends BasePage {

    HomePage homePage;
    ResultsPage resultsPage;

    public MercadoLibreSteps(){
        homePage = PageFactory.initElements(driver, HomePage.class);
        resultsPage = PageFactory.initElements(driver, ResultsPage.class);
    }
    @Given("the user navigates to home page")
    public void the_user_navigates_to_home_page() throws IOException {
        driver.get(PropertiesManager.getProperty("URL"));
        DriverUtils.waitForClickability(driver, homePage.searchBar);
    }
    @When("user performs a search using {string}")
    public void user_performs_a_search_using(String criteria) throws IOException {
        homePage.search(criteria);
        DriverUtils.waitForVisibility(driver, resultsPage.searchCriteria);
        Assert.assertTrue(resultsPage.rawRows.size() > 0, String.format("No results found for <<%s>>", criteria));
    }
    @Then("user is able to save results into a CSV file")
    public void user_is_able_to_save_results_into_a_csv_file()  {

        try {
            CSVWriter writeToFile = new CSVWriter(new FileWriter("results.csv"));

            String[] test = {"Name", "Price", "Link"};
            writeToFile.writeNext(test);

            resultsPage.getResultsList().forEach((result) -> {
                String[] value = {result.getName(), String.valueOf(result.getPrice()), result.getLink()};
                writeToFile.writeNext(value);
            });

            writeToFile.close();
        } catch (IOException e) { }

        Assert.assertEquals(FileUtils.getLastModified(PropertiesManager.getSystemProperty("user.dir")).getName(), "results.csv");
    }

}
