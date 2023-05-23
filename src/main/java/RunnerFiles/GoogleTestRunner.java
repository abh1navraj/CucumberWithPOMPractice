package RunnerFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/java/FeatureFiles/googlefeatureFile.feature",
		glue = {"StepDefinations"},
		plugin = {"json:target/cucumber.json", "html:target/cucumber-reports"},
		dryRun = false,
		monochrome = true
		
		
		)

public class GoogleTestRunner {
	 @AfterClass
	    public static void generateReport() {
	        File reportOutputDirectory = new File("target/cucumber-report");
	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add("target/cucumber.json");

	        Configuration configuration = new Configuration(reportOutputDirectory, "Cucumber Practice");
	        configuration.setBuildNumber("1.0");
	        configuration.addClassifications("Browser", "Chrome");
	        configuration.addClassifications("Platform", "macOS");
	        configuration.addClassifications("Environment", "Test");

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }
}
