
package fr.damaketo.basketmanager.api.tests.steps;

import cucumber.api.java.fr.Alors;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;

public class TechnicalSteps extends AbstractSteps {

    @Alors("^le statut du partenaire \"(.*)\" est \"(.*)\"$")
    public void assertPartnerFieldValue(final String partnerName, final String value) throws Throwable {
        final Response response = responseContext.getResponse();
        response.then().body(String.format("healthResponses.find {it.name=='%s'}.health", partnerName), equalTo(value));
    }
}
