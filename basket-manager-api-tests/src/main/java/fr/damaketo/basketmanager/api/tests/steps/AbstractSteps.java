
package fr.damaketo.basketmanager.api.tests.steps;

import fr.damaketo.basketmanager.api.tests.utils.RequestContext;
import fr.damaketo.basketmanager.api.tests.utils.ResponseContext;
import fr.damaketo.basketmanager.api.tests.utils.ScenarioContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public abstract class AbstractSteps {

    protected static final String CUSTOMERS_COLLECTION = "customers";
    protected static final String INITIAL_CUSTOMER_CTXID = "initialCustomer";
    protected static final String CUSTOMER_ID = "customerId";

    @Autowired
    protected RequestContext requestContext;

    @Autowired
    protected ResponseContext responseContext;

    @Autowired
    protected ScenarioContext scenarioContext;
}
