package fr.damaketo.basketmanager.api.infrastructure.basket.player;

import fr.damaketo.basketmanager.api.domain.Player;
import fr.damaketo.basketmanager.api.domain.PlayerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 */
public class PlayerDefaultRepository implements PlayerRepository {

    private final PlayerMongoRepository playerMongoRepository;

    public PlayerDefaultRepository(PlayerMongoRepository playerMongoRepository) {
        this.playerMongoRepository = playerMongoRepository;
    }

    public Mono<Player> create(final Player player, final String leagueId) {
        final PlayerDocument playerDocument = new PlayerDocument(player, leagueId);
        return playerMongoRepository.save(playerDocument)
            .map(PlayerDocument::toPlayer)
                .doOnError(throwable -> Mono.error(new Exception()));
    }

    public Mono<Player> getById(String id) {
        return playerMongoRepository.findById(id)
                .map(PlayerDocument::toPlayer);
    }

    public Flux<Player> getByLeagueId(String leagueId) {
        return playerMongoRepository.findByLeagueId(leagueId)
                .map(PlayerDocument::toPlayer);
    }

    public Flux<Player> getAll() {
        return playerMongoRepository.findAll().map(PlayerDocument::toPlayer);
    }
}
