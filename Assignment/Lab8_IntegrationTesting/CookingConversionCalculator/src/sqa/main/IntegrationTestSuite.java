package sqa.main;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
    TopDownIntegrationTest.class,
    BottomUpIntegrationTest.class
})
public class IntegrationTestSuite {
}
