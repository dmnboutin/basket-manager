package fr.damaketo.basketmanager.api.tests;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

/**
 * Launcher JUnit pour les tests cucumber.
 */
@RunWith(Cucumber.class)
@CucumberOptions(strict = true,
        plugin = {"progress", "html:target/cucumber", "json:target/cucumber/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"classpath:fr/damaketo/basketmanager/api/tests/given",
                "classpath:fr/damaketo/basketmanager/api/tests/when",
                "classpath:fr/damaketo/basketmanager/api/tests/then",
                "classpath:fr/damaketo/basketmanager/api/tests/steps",
                "classpath:fr/damaketo/basketmanager/api/tests/hooks",}
)
public class CucumberIT {

    public static void main(String[] args) {
        JUnitCore.main("fr.damaketo.basketmanager.api.tests.CucumberIT");
    }

}
