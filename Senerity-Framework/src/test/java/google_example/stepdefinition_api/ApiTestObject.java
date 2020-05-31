package google_example.stepdefinition_api;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import io.restassured.response.Response;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

	public class ApiTestObject extends PageObject{
	String url;
	Response res;
	Response serenity_res;
	
	@Step
	public void send_request_with_City(){
		url = API_Properties.url_with_city;
		serenity_res = SerenityRest.get(API_Properties.url_with_city);
	}
	
	@Step
	public void verify_response_code(int status_code){
		serenity_res.then().statusCode(status_code);
	}
	
	@Step
	public void countryCode(){
		String country_code = serenity_res.jsonPath().getString("sys.country");
		System.out.println("\n\n######################################## country code = "+country_code+"\n\n");
		Assert.assertTrue(country_code.contentEquals("US"));
	}
	
	@Step
	public void api_response_time(int expexted_res_time){
		long actual_res_time = serenity_res.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("\n\n######################################## response time = "+actual_res_time+"\n\n");
		Assert.assertTrue(actual_res_time<expexted_res_time);

		
	}

}
