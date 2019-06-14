
package fr.damaketo.basketmanager.api.tests.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import fr.damaketo.basketmanager.api.tests.config.CucumberConfiguration;
import fr.damaketo.basketmanager.api.tests.utils.RequestContext;
import fr.damaketo.basketmanager.api.tests.utils.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 */
@ContextConfiguration(classes = {CucumberConfiguration.class})
public class ScenarioHooks {

    public static final String SCENARIO_GARBAGE = "garbage";

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private RequestContext requestContext;

    @Before
    public void prepareScenario(){
        scenarioContext.clear();
    }

    @After
    public void cleanUp(){
        requestContext.clear();
    }
}
