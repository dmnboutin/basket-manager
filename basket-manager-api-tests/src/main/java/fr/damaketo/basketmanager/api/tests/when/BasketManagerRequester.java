
package fr.damaketo.basketmanager.api.tests.when;

import cucumber.api.PendingException;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Soit;
import fr.damaketo.basketmanager.api.tests.steps.AbstractSteps;
import fr.damaketo.basketmanager.api.tests.utils.RequestContext;
import gherkin.deps.com.google.gson.JsonObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class BasketManagerRequester extends AbstractSteps {

    public static final String SERVICE_TYPE_CTXID = "service_type";

    @Quand("^la ressource pour créer une league est appelée$")
    public void laRessourcePourCréerUneLeagueEstAppelée() {
        requestContext.setPath(RequestContext.BASKETMANAGER_API + "leagues");
        requestContext.addHeader("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        setInput(request, "name", requestContext.getInput().getOrDefault("name", RandomStringUtils.randomAlphanumeric(5,10)));
        setInput(request, "numberOfTeam", requestContext.getInput().getOrDefault("numberOfTeam", RandomStringUtils.randomAlphanumeric(5,10)));

        requestContext.setBody(request.toString());
        responseContext.doPost(requestContext);
    }

    @Quand("^la ressource pour créer une equipe est appelée$")
    public void laRessourcePourCréerUneEquipeEstAppelée() {
        requestContext.setPath(RequestContext.BASKETMANAGER_API + "leagues/5c61a3266a09af24c0de346f/teams");
        requestContext.addHeader("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        setInput(request, "name", requestContext.getInput().getOrDefault("name", RandomStringUtils.randomAlphanumeric(5,10)));

        JsonObject city = new JsonObject();
        city.addProperty("name", requestContext.getInput().getOrDefault("city", "Chicago"));
        request.add("city", city);

        requestContext.setBody(request.toString());
        responseContext.doPost(requestContext);

    }


    public enum ServiceType {
        SEARCH,
        GET
    }

    @Quand("^la ressource pour créer un compte est appelée$")
    public void laRessourcePourCréerUnCompteEstAppelée() {
        requestContext.setPath(RequestContext.BASKETMANAGER_API + "accounts");
        requestContext.addHeader("Content-Type", "application/json");
        JsonObject request = new JsonObject();
        setInput(request, "login", requestContext.getInput().getOrDefault("login", RandomStringUtils.randomAlphanumeric(5,10)));

        requestContext.setBody(request.toString());
        responseContext.doPost(requestContext);
    }

    /**
     * Add input in json, only if input in context is not equal to "null"
     * @param json json in construction
     * @param input field to add in json
     * @param defaultValue default value
     */
    private void setInput(final JsonObject json, final String input, final String defaultValue) {
        if (!requestContext.getInput().containsKey(input) || (requestContext.getInput().containsKey(input) && !requestContext.getInput().get(input).equals("null"))) {
            json.addProperty(input, requestContext.getInput().getOrDefault(input, defaultValue));
        }
    }
}
