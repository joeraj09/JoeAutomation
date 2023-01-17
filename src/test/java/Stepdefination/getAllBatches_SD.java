package Stepdefination;
import java.util.Map;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getAllBatches_SD 
{
	private String path;
	RequestSpecification request;
	Map<String, Object> requestParams;
	Response response;
	
	@Given("get all batches URL and path")
	public void get_all_batches_url_and_path() 
	{
		RestAssured.baseURI = "https://lms-backend-service.herokuapp.com/lms";
		path = "/allbatches";
	}

	@When("Get request for all batches")
	public void get_request_for_all_batches() 
	{
		RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json").build();
		response = RestAssured.given().log().all().spec(requestSpec).get(path);
	}

	@Then("Validate the Get status code")
	public void validate_the_get_status_code() 
	{
		Assert.assertEquals(200, response.getStatusCode());
	}

}
