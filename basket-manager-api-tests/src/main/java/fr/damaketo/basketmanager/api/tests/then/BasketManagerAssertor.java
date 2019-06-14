package fr.damaketo.basketmanager.api.tests.then;

import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import fr.damaketo.basketmanager.api.tests.steps.AbstractSteps;
import org.hamcrest.Matchers;

import static org.hamcrest.Matchers.equalTo;

public class BasketManagerAssertor extends AbstractSteps {

    @Alors("^le service envoie le code HTTP \"([^\"]*)\"$")
    public void assertStatusCode(final int statusCode) {
        responseContext.getResponse().then().statusCode(statusCode);
    }

    @Et("^le service retourne un code erreur ([^\"]*)")
    public void validateErrorCode(final String errorCode) {
        responseContext.getResponse().then().body("code", equalTo(errorCode));
    }

    @Et("^le service retourne dans la section détail un code erreur ([^\"]*)")
    public void validateErrorCodeDetail(final String errorCodeDetail) {
        responseContext.getResponse().then().body("details[0].code", equalTo(errorCodeDetail));
    }

    @Et("^le service retourne dans la section détail (\\d+) erreurs$")
    public void validateNbError(int nbError) {
        responseContext.getResponse().then().body("details.size", equalTo(nbError));
    }

    @Et("^le lien vers la resource account est dans les headers Location$")
    public void leLienVersLaResourceEstDansLesHeadersLocation() {
        responseContext.getResponse().then().header("Location", Matchers.containsString("/accounts/"));

    }

    @Et("^le lien vers la resource league est dans les headers Location$")
    public void leLienVersLaResourceLeagueEstDansLesHeadersLocation() {
        responseContext.getResponse().then().header("Location", Matchers.containsString("/leagues/"));
    }

    @Et("^le lien vers la resource team est dans les headers Location$")
    public void leLienVersLaResourceTeamEstDansLesHeadersLocation() {
        responseContext.getResponse().then().header("Location", Matchers.containsString("/teams/"));
    }
}
