package fr.damaketo.basketmanager.api.tests.utils;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;


@Component
@Scope("cucumber-glue") // Create and destroy bean on each scenario test
public class ResponseContext {

    @Autowired
    private String basketManagerApiBaseUri;

    private Response response;

    public void doGet(RequestContext requestContext) {
        this.response = this.performRequest(requestContext)
                .get(requestContext.getPath());
    }

    public void doPost(RequestContext requestContext) {
        this.response = this.performRequest(requestContext)
                .body(requestContext.getBody())
                .post(requestContext.getPath());
    }

    public void doPut(RequestContext requestContext) {
        this.response = this.performRequest(requestContext)
                .body(requestContext.getBody())
                .put(requestContext.getPath());
    }

    private RequestSpecification performRequest(final RequestContext requestContext) {
        final RequestSpecification requestSpecification =
                        given()
                        .baseUri(basketManagerApiBaseUri)
                        .pathParams(requestContext.getPathParams());

        requestContext.getQueryParams().forEach(requestSpecification::param);
        requestContext.getHeaders().forEach(requestSpecification::header);
        requestContext.getCookies().forEach(requestSpecification::cookie);

        return requestSpecification.when();
    }

    public Response getResponse() {
        return this.response;
    }
}
