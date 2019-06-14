
package fr.damaketo.basketmanager.api.infrastructure;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 *
 */
@Configuration
@EnableReactiveMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "basketmanager";
    }

    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }
}