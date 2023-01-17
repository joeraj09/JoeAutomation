package Stepdefination;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features/getAllBatches.feature",
 "src/test/resources/Features/updatePById.feature",
 "src/test/resources/Features/updatePByName.feature"},
		glue = { "Stepdefination" }, 
		dryRun = false,
	    monochrome= true,plugin= {"pretty","json:target/JSON/JSONReports.json"})

public class runner 
{
	
	}


