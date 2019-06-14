package fr.damaketo.basketmanager.api.tests.config;

import fr.damaketo.basketmanager.api.tests.utils.RequestContext;
import fr.damaketo.basketmanager.api.tests.utils.ResponseContext;
import fr.damaketo.basketmanager.api.tests.utils.ScenarioContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class CucumberConfiguration {

    @Bean
    public String basketManagerApiBaseUri(@Value("${api.baseUri:http://localhost:8080}") final String baseUri) {
        return baseUri;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public ScenarioContext scenarioContext() {
        return new ScenarioContext();
    }

    @Bean
    public RequestContext requestContext() {
        return new RequestContext();
    }

    @Bean
    public ResponseContext responseContext() {
        return new ResponseContext();
    }

    public static class AuthorizationConfiguration {
        private final String validTokenLegacy;
        private final String validTokenLegacyCorruptUsername;
        private final String email;
        private final String iuc;
        private final String invalidToken;
        private final String forbiddenToken;
        private final String apiKey;

        public AuthorizationConfiguration(
                final String validTokenLegacy,
                final String validTokenLegacyCorruptUsername,
                final String email,
                final String iuc,
                final String invalidToken,
                final String forbiddenToken,
                final String apiKey) {
            this.validTokenLegacy = validTokenLegacy;
            this.validTokenLegacyCorruptUsername = validTokenLegacyCorruptUsername;
            this.email = email;
            this.iuc = iuc;
            this.invalidToken = invalidToken;
            this.forbiddenToken = forbiddenToken;
            this.apiKey = apiKey;
        }

        public String getValidTokenLegacy() {
            return validTokenLegacy;
        }

        public String getValidTokenLegacyCorruptUsername() {
            return validTokenLegacyCorruptUsername;
        }

        public String getEmail() {
            return email;
        }

        public String getIuc() {
            return iuc;
        }

        public String getInvalidToken() {
            return invalidToken;
        }

        public String getForbiddenToken() {
            return forbiddenToken;
        }

        public String getApiKey() {
            return apiKey;
        }
    }

}
