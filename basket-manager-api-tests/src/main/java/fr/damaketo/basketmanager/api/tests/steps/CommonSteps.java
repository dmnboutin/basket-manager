
package fr.damaketo.basketmanager.api.tests.steps;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import io.restassured.response.Response;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;

public class CommonSteps extends AbstractSteps {

    public static final String CUSTOMERS_SIZE = "customers.size()";
    public static final String CUSTOMERS_ARRAY = "customers.find{it.%s}";
    protected static final String CUSTOMERS_ARRAY_CONTAINS = "customers.any{it.containsKey('%s')}";

    @Quand("^le service \"([^\"]*)\" est appelé$")
    public void callAService(final String servicePath) {
        requestContext.setPath(servicePath);
        responseContext.doGet(requestContext);
    }

    @Alors("^le service renvoie un code (\\d+)$")
    public void assertStatusCode(int statusCode) {
        responseContext.getResponse().then().statusCode(statusCode);
    }


    @Alors("^l[ea] \"([^\"].*)\" est \"([^\"].*)\"$")
    public void assertResponseFieldValue(final String fieldName, final String value) throws Throwable {
        final Response response = responseContext.getResponse();
        response.then().body(fieldName, equalTo(value));
    }


}
