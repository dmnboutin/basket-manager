package fr.damaketo.basketmanager.api.infrastructure.basket.league;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 */
@Repository
public interface LeagueMongoRepository extends ReactiveMongoRepository<LeagueDocument, String> {

}
