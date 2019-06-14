package fr.damaketo.basketmanager.api.infrastructure.basket.player;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 *
 */
@Repository
public interface PlayerMongoRepository extends ReactiveMongoRepository<PlayerDocument, String> {

    Flux<PlayerDocument> findByLeagueId(final String leagueId);
}
