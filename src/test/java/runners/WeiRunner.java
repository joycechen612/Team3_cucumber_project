package runners;

import static io.cucumber.junit.platform.engine.Constants.EXECUTION_DRY_RUN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("weiFeatures")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/html-report/index.html")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value ="uiStepDefinitions, hooks")
@ConfigurationParameter(key =EXECUTION_DRY_RUN_PROPERTY_NAME, value="false")
@ConfigurationParameter(key= FILTER_TAGS_PROPERTY_NAME,value="@Luma")


public class WeiRunner {

}
