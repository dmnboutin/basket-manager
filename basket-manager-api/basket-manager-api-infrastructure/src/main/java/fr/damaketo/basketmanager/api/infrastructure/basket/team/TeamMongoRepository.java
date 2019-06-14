package fr.damaketo.basketmanager.api.infrastructure.basket.team;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface TeamMongoRepository extends ReactiveMongoRepository<TeamDocument, String> {

}
