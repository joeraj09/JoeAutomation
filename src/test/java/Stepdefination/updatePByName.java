package Stepdefination;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updatePByName 
{

	private String path;
	RequestSpecification request;
	Map<String, Object> requestParams;
	Response response;
	
	@Given("A update Service with URL and path")
	public void a_update_service_with_url_and_path() 
	{

		RestAssured.baseURI = "https://lms-backend-service.herokuapp.com/lms";
		path = "/putprogram/"+programName;
	}

	@When("{string},{string},{string},{string},creationTime,lastModTime are updated")
	public void creation_time_last_mod_time_are_updated(String programName,String programId, String programDescription, String programStatus) 
	{
	    
		ZonedDateTime dateTime = ZonedDateTime.now();
		String time = dateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		requestParams = new HashMap<>();
		requestParams.put("programId", programId);
		requestParams.put("programName", programName);
		requestParams.put("programStatus", programStatus);
		requestParams.put("programDescription", programDescription);
		requestParams.put("creationTime", time);
		requestParams.put("lastModTime", time);

	}

	@When("PUT request is made")
	public void put_request_is_made_by_(String programName) 
	{
		RequestSpecification requestSpec = new RequestSpecBuilder().addHeader("Content-Type", "application/json")
				.addHeader("Accept", "application/json").build();
		response = RestAssured.given().spec(requestSpec).put(path + "/" + programName);	
	}

	@Then("Save programName")
	public void save_program_name() 
	{
		response = request.put(path);
		
	}

	@Then("Validate status code")
	public void validate_status_code() 
	{
		Assert.assertEquals(200, response.getStatusCode());
	}

	@Then("validate required fields {string},{string},{string},{string}")
	public void validate_required_fields(String programId,String programName, String programDescription, String programStatus) 
	{
		JsonPath jsonPathEvaluator = response.jsonPath();
		String responseId = jsonPathEvaluator.get("programId");
		//String responseName = jsonPathEvaluator.get("programName");
		String responseDesc = jsonPathEvaluator.get("programDescription");
		String responseStatus = jsonPathEvaluator.get("programStatus");
		
		Assert.assertEquals(responseId, programId);
		Assert.assertEquals(responseDesc, programDescription);
		Assert.assertEquals(responseStatus, programStatus);
		
		response.getBody().prettyPrint();

	    
	}

	
}
