
package fr.damaketo.basketmanager.api.tests.steps;

import cucumber.api.PendingException;
import cucumber.api.java.fr.Et;
import cucumber.api.java.fr.Quand;
import cucumber.api.java.fr.Soit;

public class BasketManagerSteps extends AbstractSteps {

    @Soit("^un client souhaitant mettre à jour son information \"([^\"]*)\" avec la valeur \"([^\"]*)\"$")
    public void setInput(String field, String value) throws Throwable {
        requestContext.addInput(field, value);
    }

    @Soit("^un utilisateur souhaitant créer un compte avec le login \"([^\"]*)\"$")
    public void unUtilisateurSouhaitantCréerUnCompteAvecLeLogin(String login) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        requestContext.addInput("login", login);
    }

    @Soit("^un utilisateur connecté$")
    public void unUtilisateurConnecté() {
        requestContext.addHeader("accountId", "5c61a1596a09af0ee07170fc");
    }

    @Et("^souhaitant créer une ligue \"([^\"]*)\" de \"([^\"]*)\" équipes$")
    public void souhaitantCréerUneLigueDeNbEquipeÉquipes(String name, String numberOfTeam) throws Throwable {
        requestContext.addInput("name", name);
        requestContext.addInput("numberOfTeam", numberOfTeam);
    }

    @Et("^souhaitant créer une équipe \"([^\"]*)\" dans la ville \"([^\"]*)\"$")
    public void souhaitantCréerUneÉquipeDansLaVille(String name, String city) throws Throwable {
        requestContext.addInput("name", name);
        requestContext.addInput("city", city);
    }
}
