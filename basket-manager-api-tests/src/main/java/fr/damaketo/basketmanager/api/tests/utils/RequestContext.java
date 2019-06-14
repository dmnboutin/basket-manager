package fr.damaketo.basketmanager.api.tests.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Scope("cucumber-glue") // Create and destroy bean on each scenario test
public class RequestContext {

    public static final String BASKETMANAGER_API = "/";

    private String path;
    private String body;
    private Map<String, String> pathParams = new HashMap<>();
    private Map<String, List<String>> queryParams = new HashMap<>();
    private Map<String, String> headers = new HashMap<>();
    private Map<String, String> cookies = new HashMap<>();
    private Map<String, String> input = new HashMap<>();

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    public Map<String, String> getPathParams() {
        return pathParams;
    }

    public Map<String, List<String>> getQueryParams() {
        return queryParams;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getCookies() {
        return cookies;
    }

    public Map<String, String> getInput() {
        return input;
    }

    public void addQueryParam(String param, String value) {
        if (!queryParams.containsKey(param)) {
            queryParams.put(param, new ArrayList<>());
        }
        queryParams.get(param).add(value);
    }

    public void addQueryParam(String param, List<String> values) {
        if (!queryParams.containsKey(param)) {
            queryParams.put(param, new ArrayList<>());
        }
        queryParams.get(param).addAll(values);
    }

    public void addHeader(String header, String value) {
        addHeader(header, value, false);
    }

    public void addHeader(String header, String value, boolean replace) {
        if (replace || !headers.containsKey(header)) {
            headers.put(header, value);
        }
    }

    public void addCookie(String cookie, String value) {
        addCookie(cookie, value, false);
    }

    private void addCookie(final String cookie, final String value, final boolean replace) {
        if(replace || !cookies.containsKey(cookie)) {
            cookies.put(cookie, value);
        }
    }

    public void addPathParam(String param, String value) {
        if (!pathParams.containsKey(param)) {
            pathParams.put(param, value);
        }
    }

    public void addInput(String param, String value) {
        if (!input.containsKey(param)) {
            input.put(param, value);
        }
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void clear() {
        this.path = "";
        this.body = "";
        this.pathParams.clear();
        this.queryParams.clear();
        this.headers.clear();
        this.cookies.clear();
        this.input.clear();
    }


}
