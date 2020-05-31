
package google_example.example.google.ui.steps;

import junit.framework.Assert;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.WhenPageOpens;


public class GoogleHomePage extends PageObject {

	
	private static final String googleSearchButton = "//input[@class='gLFyf gsfi']";
	
	/*
	 * // This is other way to use WebElementFacade Element, can be used to list
	 * also. This is same as PageFactory
	 * 
	 * 
	 * @FindBy(xpath = googleSearchButton) 
	 * WebElementFacade googleSearchButtonxpath;
	 */
	
	@Step("User open the Browser and navigate to Google Home page")
	public void openApplication() {
		open();
	}

	@WhenPageOpens
	public void maximiseScreen() {
		getDriver().manage().window().maximize();
	}
	

	@Step("Verify title is showing as {0}")
	public void verifyTitle(String title) {
		Assert.assertEquals(title, getDriver().getTitle());
	}
	
	@Step("Search for text: {0}")
	public void searchText(String text) {
		//Use webElementFascad xpath or css in this way to use $(By.id("id"))
		$(googleSearchButton).type(text);
	}
}
