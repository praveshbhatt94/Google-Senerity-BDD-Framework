package google_example.example.google.ui.stepDefinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import ascend.ati.evaluation.util.CucumberUtil;
import google_example.example.google.ui.steps.GoogleHomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import net.thucydides.core.annotations.Steps;

public class GoogleStepDefination {
	
	@Steps
	GoogleHomePage googleHomePage; 

	
	 @When("User Naviagte to google Home page")
	    public void user_naviagte_to_google_home_page() throws Throwable {
		 googleHomePage.open();
	    }

	    @Then("{word} Title should show")
	    public void something_title_should_show(String title) throws Throwable {
	    	googleHomePage.verifyTitle(title);
	    }
	    
	    

	    @And("User Serach for {word} text")
	    public void user_serach_for_something_text(String text) throws Throwable {
	    	googleHomePage.searchText(text);
	    }
	
}
