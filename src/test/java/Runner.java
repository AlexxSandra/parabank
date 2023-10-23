import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = "org.alexandra.bajura",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber-report.json",
                "html:target/cucumber-report/cucumber-report-html"
        }
)
class Runner {

}