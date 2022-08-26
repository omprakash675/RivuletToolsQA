package rivulet.project;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="featureFiles/elements.feature",
glue= "stepDefinition" 
,tags= "not @negativetestcase",
plugin= {"html:Report/positiveHtmlReport","junit:Report/positiveJunitReport.xml"}
)
@Listeners({ExtentITestListenerClassAdapter.class})
public class ToolQAProject {

}
